package programmers.LV0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P12865 {
    static int n, m;
    static int[][] dp;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken()); // 최대 무게

        arr = new int[n][2];
        dp = new int[n][m + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); // 무게
            arr[i][1] = Integer.parseInt(st.nextToken()); // 가치
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = -1;
            }
        }

        int solution = solution(0, 0);
        System.out.println(solution);
    }

//            4 7
//            6 13
//            4 8
//            3 6
//            5 12
    private static int solution(int idx, int weight) {
        if (weight > m) {
            return Integer.MIN_VALUE;
        }

        if (idx == n) {
            return 0;
        }

        if (dp[idx][weight] != -1) {
            return dp[idx][weight];
        }

        int in = weight + arr[idx][0] <= m ? solution(idx + 1, weight + arr[idx][0]) + arr[idx][1] : Integer.MIN_VALUE;
        int out = solution(idx + 1, weight);

        dp[idx][weight] = Math.max(in, out);
        return dp[idx][weight];
    }
}
