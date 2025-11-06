package baekjoon.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P15654 {
    static int n;
    static int m;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    static int[] result;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        visited = new boolean[n];
        result = new int[n];
//        result = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        recursive(0);

        System.out.println(sb.toString());

    }

    private static void recursive(int depth) {
        if(depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(arr[result[i]]).append(" ");
            }

//            for (int num : result) {
//                sb.append(arr[num]).append(" ");
//            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                result[depth] = i;
                recursive(depth + 1);
                visited[i] = false;
            }
        }
    }
}
