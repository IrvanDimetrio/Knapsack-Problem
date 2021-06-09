package knapsack;
// Dibuat Oleh : Muhamad Irvan Dimetrio

public class knapsack_branch_bound {

    public static double UpperBound(int[] w, int[] p, int n, int ccourante, int j) {
        int r = 0;
        int i = j;
        do {
            r += w[i - 1];
            i++;
        } while (r <= ccourante);
        if (i > n) {
            i = n;
        }
        int u = ccourante * p[i - 1] / w[i - 1];
        if (i > j) {
            for (int k = j; k <= i - 1; k++) {
                u = u + p[k - 1] - w[k - 1] * p[i - 1] / w[i - 1];
            }
        }
        return u;
    }

    public static void main(String[] args) {

        System.out.print("Knapsack problem solved in Branch and Bound");
        int n = 6;
        int c = 160;
        int[] p = {40, 35, 18, 4, 10, 2};
        int[] w = {100, 50, 45, 20, 10, 5, 1000};

        int[] x = new int[n + 1];
        int[] xcourante = new int[n + 1];

        int z = 0;
        int zcourante = 0;
        int ccourante = c;
        int j = 1;
        int i = -1;
        /* il faut penser a faire des opérations (comme compute move..)comme des fonctions
         */
        // 3 perform a forward step
        do {
            do {
                while (w[j - 1] <= ccourante) {
                    ccourante -= w[j - 1];
                    zcourante += p[j - 1];
                    xcourante[j - 1] = 1;
                    j++;
                }
                //System.out.println(zcourante);
                if (j <= n) {
                    xcourante[j - 1] = 0;
                    j++;
                }
            } while (j == n || (j < n && z < zcourante + UpperBound(w, p, n, ccourante, j)));
//System.out.println(j);
            if (j > n) {
//System.out.println("j>n"+(j>n));
                //if (j<n) System.out.println("go to 2"); // go to 2
                //if (j==n) System.out.println("go to 3"); // go to 3

                // 4 update the best solution so far
                if (zcourante > z) {
                    z = zcourante;
                    for (int k = 1; k <= n; k++) {
                        x[k - 1] = xcourante[k - 1];
                    }
                }
                j = n;
                if (xcourante[n - 1] == 1) {
                    ccourante += w[n - 1];
                    zcourante -= p[n - 1];
                    x[n - 1] = 0;
                }
            }
// System.out.println("upperbound"+(j==n || (j<n && z>=zcourante +UpperBound(w,p,n,ccourante,j) )));
            if (j == n || (j < n && z >= zcourante + UpperBound(w, p, n, ccourante, j))) {// 5 backtrack
                do {
                    i = -1;
                    int k = 1;
                    //System.out.println("ici");
                    while (k < j) {
                        if (xcourante[k - 1] == 1) {
                            i = k;
                        }
                        k++;
                    }
                    //System.out.println("encore un tour");
                    if (i == -1) {
                        System.out.println("ok z = " + z);
                        for (int l = 1; l <= n; l++) {
                            System.out.print("x[" + l + "]=" + x[l - 1] + " ");
                        }
                    } else {
                        //System.out.println("2eme tour avec i="+i);	
                        ccourante += w[i - 1];
                        //System.out.println("hop");
                        zcourante -= p[i - 1];
                        xcourante[i - 1] = 0;
                        j = i + 1;
                        //System.out.println("la avec ccourante="+ccourante);
                    }
                    boolean verification = (z >= zcourante + UpperBound(w, p, n, ccourante, j) && i != -1);
//System.out.println("verification"+verification);
                    // go to 2;
                } while (z >= zcourante + UpperBound(w, p, n, ccourante, j) && i != -1);
            }
            //System.out.println(zcourante);	

            //System.out.println("i!=-1"+(i!=1));
        } while (i != -1);
    }
}
