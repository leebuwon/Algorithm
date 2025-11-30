package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1389 {
    static int n;
    static int m;
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int[] friendLink = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            int count = bfs(i);
            friendLink[i] = count;
        }

        for(int i = 1; i <= n; i++) {
            if(friendLink[i] == min) {
                System.out.println(i);
                break;
            }
        }


    }

    private static int bfs(int start) {
        int answer = 0;
        int linkCount = 0;
        int[] relatives = new int[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        relatives[start] = linkCount;

        while (!queue.isEmpty()) {
            Integer me = queue.poll();

            List<Integer> friends = graph.get(me);
            for (Integer friend : friends) {
                if(!visited[friend]) {
                    relatives[friend] += relatives[me] + 1;
                    queue.add(friend);
                    visited[friend] = true;
                }
            }

        }

        for (int count : relatives) {
            answer += count;
        }

        if(answer < min) {
            min = answer;
        }
        return answer;
    }
}
