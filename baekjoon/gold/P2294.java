package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// GPT 참고
public class P2294 {
    static int n;
    static int k;
    static int[] conins;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        conins = new int[n];
        dp = new int[k + 1];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            conins[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(dp, 1000000);
        dp[0] = 0;

        for (int coin : conins) {
            for(int i = coin; i <= k; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        if(dp[k] == 1000000) {
            System.out.println(-1);
        } else {
            System.out.println(dp[k]);
        }
    }
}
