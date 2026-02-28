package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 블로그 참고
public class P21758 {
    static int n;
    static int[] arr;
    static long[] prefix;
    static Long max = Long.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        prefix = new long[n];
        prefix[0] = arr[0];
        for(int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        for(int i = 1; i < n - 1; i++){
            long sum = prefix[n - 1]  * 2L - arr[0] - arr[i] - prefix[i];
            max=Math.max(sum,max);
        }

        for(int i = 1; i < n - 1; i++){
            long sum = (prefix[n - 2] - arr[i]) + (prefix[i - 1]);
            max = Math.max(sum,max);
        }

        for(int i = 1; i < n - 1; i++){
            long sum = prefix[i] + (prefix[n - 2] - prefix[i - 1]) - arr[0];
            max = Math.max(sum,max);
        }

        System.out.println(max);
    }
}
