package baekjoon.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P10819 {
    static int n;
    static int[] arr;
    static int max = Integer.MIN_VALUE;
    static boolean[] visited;
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        visited = new boolean[n];
        result = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 35 46 53 55
        // 10, 1, 15, 4, 20, 8
        // 10 - 1 = 9
        // 1 - 15 = 14
        // 15 - 4 = 11
        // 4 - 20 = 16
        // 20 - 8 = 12
        // 9 + 14 + 11 + 16 + 12

        recursive(0, 0);

        System.out.println(max);

    }

    private static void recursive(int depth, int sum) {
        if(depth == n) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                result[depth] = i;

                int newSum = sum;
                if (depth > 0) {
                    newSum += Math.abs(arr[result[depth]] - arr[result[depth - 1]]);
                }

                recursive(depth + 1, newSum);
                visited[i] = false;
            }
        }

    }
}
