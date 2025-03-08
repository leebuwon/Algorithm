import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.max;

public class P14501 {
    static int max = Integer.MIN_VALUE;
    static int n;
    static int[]dp;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        dp = new int[n + 1];

        arr = new int[n][2];
        for (int i = 0; i < arr.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            if (i + arr[i][0] > n) {
                dp[i] = dp[i + 1];
            } else {
                dp[i] = max(dp[i + arr[i][0]] + arr[i][1], dp[i + 1]);
            }
        }

        Arrays.sort(dp);

        System.out.println(dp[n]);
    }
}
