package programmers.LV0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.max;

public class PP14501 {
    static int max = Integer.MIN_VALUE;
    static int n;
    static int[]dp;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        dp = new int[n + 1];

        arr = new int[n + 1][2];
        for (int i = 1; i < arr.length; i++) {
            st = new StringTokenizer(br.readLine());
            dp[i] = -1;
            for (int j = 0; j < 2; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int solution = solution(1);
        System.out.println(solution);
    }

    /**
     * [0, 0],
     * [3, 10],
     * [5, 20],
     * [1, 10],
     * [1, 20],
     * [2, 15],
     * [4, 40],
     * [2, 200]
     */
    private static int solution(int day) {
        if(day > n + 1) {
            return -1001;
        }

        if(day == n + 1) {
            return 0;
        }

        if(dp[day] != -1) {
            return dp[day];
        }

        dp[day] = max(solution(day + 1), solution(day + arr[day][0]) + arr[day][1]);
        return dp[day];
    }
}
