package baekjoon.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P5568 {
    static int n;
    static int k;
    static String[] arr;
    static Set<String> set = new HashSet<>();
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        arr = new String[n];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = st.nextToken();
        }

        // 시작할 인덱스 보내기
        recursive(0);

        System.out.println(set.size());
    }

    private static void recursive(int depth) {
        // 만약에 idx == k 일 경우 set에 넣어주기
        if(depth == k) {
            set.add(sb.toString());
            return;
        }

        // 해당 인덱스는 유지해야되고 더해지는 값이 계속 올라가야함... // 인자를 두개를 받아야한다. (현재 idx와 다음받을 idx
        // sb에 idx 넣어주기
        for (int i = 0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                sb.append(arr[i]);
                recursive(depth + 1);
                int len = arr[i].length();
                sb.delete(sb.length() - len, sb.length());
                visited[i] = false;
            }
        }
    }
}
