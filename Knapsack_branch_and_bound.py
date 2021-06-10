from operator import truediv
data_item = ['Barang 1', 'Barang 2', 'Barang 3', 'Barang 4', 'Barang 5', 'Barang 6']
data_weight = [100, 50, 45, 20, 10, 5]
data_value = [40, 35, 18, 4, 10, 2]
data_eff = map(truediv, data_value, data_weight)
order = [i[0] for i in sorted(enumerate(data_eff), key=lambda x:x[1], reverse=True)]
#sort data based on their 'efficiency', i.e. value/weight
data_eff = [data_eff[i] for i in order]
data_weight = [data_weight[i] for i in order]
data_value = [data_value[i] for i in order]
data_item = [data_item[i] for i in order]
max_weight = 160

class State(object):
    def __init__(self, level, benefit, weight, token):
        #token = list marking if a task is token. ex. [1, 0, 0] means item0 token, item1 non-token, item2 non-token
        #available = list marking all tasks available, i.e. not explored yet
        self.level = level
        self.benefit = benefit
        self.weight = weight
        self.token = token
        self.available = self.token[:self.level]+[1]*(len(data_value)-level)
        self.ub = self.upperbound()


    def upperbound(self): #define upperbound using fractional knaksack
        upperbound = 0 #initial upperbound
        weight_accumulate = 0 #accumulated weight used to stop the upperbound summation
        for i in range(len(data_weight)):
            if data_weight[i] * self.available[i] <= max_weight - weight_accumulate:
                weight_accumulate += data_weight[i] * self.available[i]
                upperbound += data_value[i] * self.available[i]
            else:
                upperbound += data_value[i] * (max_weight - weight_accumulate) / data_weight[i] * self.available[i]
                break
        return upperbound

    def develop(self):
        level = self.level + 1
        if self.weight + data_weight[self.level] <= max_weight: #if not overweighted, give left child
            left_weight = self.weight + data_weight[self.level]
            left_benefit = self.benefit + data_value[self.level]
            left_token = self.token[:self.level]+[1]+self.token[self.level+1:]
            left_child = State(level, left_benefit, left_weight, left_token)
        else: left_child = None
        #anyway, give right child
        right_child = State(level, self.benefit, self.weight, self.token)
        if left_child != None:
            return [left_child, right_child]
        else: return [right_child]

Root = State(0, 0, 0, [0]*len(data_value)) #start with nothing
waiting_States = [] #list of States waiting to be explored
current_state = Root
while current_state.level < len(data_value):
    waiting_States.extend(current_state.develop())
    waiting_States.sort(key=lambda x: x.ub) #sort the waiting list based on their upperbound
    current_state = waiting_States.pop() #explor the one with largest upperbound
best_solution = current_state
best_item = []
for i in range(len(best_solution.token)):
    if (best_solution.token[i] == 1):
        best_item.append(data_item[i])

print "Total weight: ", best_solution.weight
print "Total Value: ", best_solution.benefit
print "Items:", best_item
