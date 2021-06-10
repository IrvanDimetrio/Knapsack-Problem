package knapsack;
// Dibuat Oleh : Muhamad Irvan Dimetrio

import java.util.Arrays;

public class knapsack_back {

    static int valueAux = 0;    // added
    static int weightAux = 0;   // added

    public static void main(String[] args) {
        int[] weights = {100, 50, 45, 20, 10, 5};
        int[] values = {40, 35, 18, 4, 10, 2};
        int[] sol = new int[weights.length];
        int[] finalSol = new int[weights.length];
        int max = 160;

        knapsack_back(weights, values, max, 0, sol, finalSol);    // removed the two parameters
        for (int i = 0; i < finalSol.length; i++) {
            System.out.println(finalSol[i] * weights[i]);
        }

    }

    public static void knapsack_back(int[] weights, int[] values, int max, int index, int[] sol, int[] finalSol) {  // removed the parameters
        sol[index] = -1;
        int n = weights.length;
        while (sol[index] < 1) {
            sol[index] = sol[index] + 1;
            if (sum(index, sol, weights) <= max && index == n - 1) {
                System.out.println("Sol: " + Arrays.toString(sol));
                System.out.println("weight = " + sum(index, sol, weights));
                update(weights, values, max, index, sol, finalSol);
                System.out.println("*******************************");
            } else if (index < n - 1) {    // changed
                knapsack_back(weights, values, max, index + 1, sol, finalSol);

            }
//            sol[index]=-1;   // removed this line

        }

    }

    private static int sum(int index, int[] weights, int[] sol) {
        int res = 0;
//        for (int i = 0; i < index; i++) {   // thrown out
        for (int i = 0; i < sol.length; i++) {
            if (sol[i] < 0) {
                System.out.println("in sum: i = " + i + "   sol[i] = " + sol[i]);
            }
            res += sol[i] * weights[i];
        }
        return res;
    }

    private static void update(int[] weights, int[] values, int max, int index, int[] sol, int[] finalSol) {  //removed the two parameters

        int totalValue = 0;
        int totalWeight = 0;

        for (int i = 0; i < weights.length; i++) {
            if (sol[i] == 1) {
                totalValue += values[i];
                totalWeight += weights[i];
            }
        }

        if (totalValue > valueAux) {
            for (int i = 0; i < weights.length; i++) {
                finalSol[i] = sol[i];
            }
            valueAux = totalValue;
            weightAux = totalWeight;
            System.out.println("new valueAux: " + valueAux);   // changed
        }
    }
}

