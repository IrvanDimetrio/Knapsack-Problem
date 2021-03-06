def fill_tables(values, weights, m, n, W ):
    # Initialize the tables by filling the 0 row (no items)
    for j in xrange(0, W+1):
        m.append([])
        for i in xrange(0, n+1):
            m[j].append(0)
    for i in xrange(0, n+1):
        for j in xrange(0, W+1):
            if i == 0 or j == 0:
                m[j][i] = 0
            elif weights[i - 1] <= j:
                m[j][i] = max(m[j][i - 1], m[j - weights[i - 1]][i - 1] + values[i - 1])
            else:
                m[j][i] = m[j][i - 1]

def get_solution(k, weights, n, W):
    items = []
    for i in xrange(0, n):
        k.append(0)
    cap = W + 1
    for i in xrange(n, 0, -1):

        if m[cap - 1][i] > m[cap - 1][i - 1]:
            k[i - 1] = 1
            cap = cap - weights[i - 1]

    value = m[W][n]
    for i in xrange(0, n):
        if k[i] == 1:
            items.append(i+1)
    return value, items

# Run the code

values = [40,35,18,4,10,2] # The values of our items
weights = [100,50,45,20,10,5] # The weights of our items

n = len(values) # We always want to take all, if we can!
W = 160 # The maximum weigth of the knapsack

m = []
k = []
fill_tables(values, weights, m, n, W)
solution = get_solution(k, weights, n, W)

print solution
