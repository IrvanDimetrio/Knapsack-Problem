package knapsack;
// Dibuat Oleh : Muhamad Irvan Dimetrio

public class knapsack_dp {

    public void knapsack_dp(int P[], int W[], int C, int n) {
        int hasil[][] = new int[n][C + 1];
        for (int i = 1; i < n; i++) {
            for (int w = 1; w <= C; w++) {
                if (W[i] <= w) {
                    if (P[i] + hasil[i - 1][w - W[i]] > hasil[i - 1][w]) {
                        hasil[i][w] = P[i] + hasil[i - 1][w - W[i]];
                    } else {
                        hasil[i][w] = hasil[i - 1][w];
                    }
                } else {
                    hasil[i][w] = hasil[i - 1][w];
                }
//                System.out.print(hasil[i][w] + " ");
            }
//            System.out.println("");
        }
        System.out.print("Jumlah Maksimum profit  : " + hasil[n - 1][C]);
        System.out.print("\nBarang yang diambil     : ");
        int i = n - 1;
        int k = C;
        while (i > 0 && k > 0) {
            if (hasil[i][k] != hasil[i - 1][k]) {
                System.out.print(i + " ");
                k = k - W[i];
            }
            i--;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        // TODO code application logic here
        int P[] = new int[]{0, 40, 35, 18, 4, 10, 2};
        int W[] = new int[]{0, 100, 50, 45, 20, 10, 5};
        int C = 160;
        int n = P.length;
        knapsack_dp k = new knapsack_dp();
        k.knapsack_dp(P, W, C, n);
    }
}
