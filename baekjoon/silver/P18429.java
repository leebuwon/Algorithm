package baekjoon.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P18429 {
    static int n;
    static int k;
    static int[] arr;
    static int fitness = 500;
    static int cnt = 0;
    static int[] result;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n];
        result = new int[n];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // N과 M이랑 같은 문제인데..기억이안남...
        recursive(0, 500);

        System.out.println(cnt);
    }


    private static void recursive(int depth, int score) {
        if(depth == n) {
            // n개의 숫자를 모두 사용한 순열 완성
            cnt++;
            return;
        }

        if(score < fitness) {
            return;
        }

        // n의 배열만큼 순회..?
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                recursive(depth + 1, score + arr[i] - k);
                visited[i] = false;
            }
        }
    }
}
