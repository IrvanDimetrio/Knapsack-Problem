package knapsack;
// Dibuat Oleh : Muhamad Irvan Dimetrio

import java.util.*;

public class Knapsack {

    public int[] w;

    private int m;

    private int n;

    public int[] p;

    public int fp;

    public Knapsack() {
        w = new int[]{100, 50, 45, 20, 10, 5};
        p = new int[]{40, 35, 18, 4, 10, 2};
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        Knapsack p = new Knapsack();
        int[] x = new int[6];
        int[] y = new int[6];
        p.m = 160;
        p.n = 6;
        p.BKnapsack(0, 0, 0, x, y);
        for (int i = 0; i < 6; i++) {
            System.out.println(x[i]);
        }
    }

    public int Bound(int k, int cp, int cw) {
        int b = cp, c = cw; // The current yield CP and the weight of CW invariant(xk=0)
        for (int i = k + 1; i < n; i++) // Asked the general knapsack problem on the remaining articles solution
        {
            c += w[i];
            if (c < m) {
                b += p[i]; // Article I of items can be put into
            } else {
                return b;
            }
        }
        return b;

    }

    public void BKnapsack(int k, int cp, int cw, int[] x, int[] y) {
        if (cw + w[k] <= m) //The left sub tree, need to compute the upper bound constraint function, function without calculating
        {
            y[k] = 1;
            if (k < n - 1) {
                BKnapsack(k + 1, cp + p[k], cw + w[k], x, y);
            }
            if (cp + p[k] > fp && k == n - 1) //To the bottom
            {
                fp = cp + p[k];		//Update the optimal estimation value solution bound
                for (int j = 0; j <= k; j++) {
                    x[j] = y[j];
                }
            }
        }
        if (Bound(k, cp, cw) >= fp) //The right subtree, need to re calculate the upper bound function, constraint functions without calculating
        {
            y[k] = 0;
            if (k < n - 1) //Not exactly
            {
                BKnapsack(k + 1, cp, cw, x, y);
            }
            if (cp > fp && k == n - 1) //To the bottom
            {
                fp = cp;		//Update the optimal estimation value solution bound
                for (int j = 0; j <= k; j++) {
                    x[j] = y[j];
                }
            }
        }
    }

    void knapsack(int[] P, int[] W, int C, int n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
