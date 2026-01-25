package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2668 {
    static int n;
    static int[][] arr;
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static List<Integer> answer = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        arr = new int[n][2];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = i + 1;
            arr[i][1] = Integer.parseInt(st.nextToken());

        }

        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < n; i++) {
            graph.get(arr[i][0]).add(arr[i][1]);
            if(arr[i][0] == arr[i][1]) {
                graph.get(arr[i][1]).add(arr[i][0]);
            }
        }

        for(int i = 0; i < n; i++) {
            visited = new boolean[n + 1];

            dfs(arr[i][0], arr[i][0], 0);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(answer.size()).append("\n");
        for (Integer num : answer) {
            sb.append(num).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void dfs(int num, int origin, int count) {
        if(origin == num && count > 0) {
            if(!answer.contains(origin)) {
                answer.add(origin);
            }
            return;
        }

        for (int nextNum: graph.get(num)) {
            if(nextNum == origin) {
                dfs(nextNum, origin, count + 1);
                continue;
            }

            if(visited[nextNum]) {
                continue;
            }

            visited[nextNum] = true;
            dfs(nextNum, origin, count + 1);
            visited[nextNum] = false;
        }
    }
}
