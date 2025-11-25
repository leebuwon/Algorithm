package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P5567 {
    static int n;
    static int m;
    static int[][] friend;
    static boolean[] visited;
    static List<List<Integer>> graph = new ArrayList<>();
    static int friendCount = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        friend = new int[m][2];
        visited = new boolean[m + 1];

        for(int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        visited[1] = true;
        dfs(1, 0);

        System.out.println(friendCount);
    }

    private static void dfs(int start, int depth) {
        // 친구의 친구까지만 가능
        if(depth == 2) {
            return;
        }

        List<Integer> friend = graph.get(start);

        for(int i = 0; i < friend.size(); i++) {
            Integer currentFriend = friend.get(i);

            if(!visited[currentFriend]) {
                friendCount++;
            }

            visited[currentFriend] = true;
            dfs(currentFriend, depth + 1);
        }


    }
}
