package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P4485 {
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    static boolean[][] visited;
    static int[][] map;
    static int n;

    static class Node{
        int y;
        int x;
        int cost;

        public Node(int y, int x, int cost) {
            this.y = y;
            this.x = x;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = 1;
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            if(n == 0) {
                break;
            }

            map = new int[n][n];
            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = dijkstra();
            sb.append("Problem ").append(count).append(": ").append(answer).append("\n");

            // dfs는 안됨..
//            int[][] duplicate = new int[n][n];
//            duplicate[0][0] = map[0][0];
//            dfs(0, 0, map[0][0], duplicate);
            count++;

        }

        System.out.println(sb.toString());

    }

    private static int dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));

        int[][] dist = new int[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        dist[0][0] = map[0][0];
        pq.add(new Node(0, 0, map[0][0]));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if(now.cost > dist[now.y][now.x]) {
                continue;
            }

            for(int i = 0; i < 4; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];

                if(ny < 0 || nx < 0 || ny >= n || nx >= n) {
                    continue;
                }

                int nowCost = now.cost + map[ny][nx];

                if(dist[ny][nx] > nowCost) {
                    dist[ny][nx] = nowCost;
                    pq.add(new Node(ny, nx, nowCost));
                }
            }
        }

        return dist[n - 1][n - 1];
    }

    private static void bfs(int y, int x, int prefix) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});
        visited[y][x] = true;

        for(int i = 0; i < 4; i++) {
            int[] now = queue.poll();


        }
    }

    private static void dfs(int y, int x, int prefix, int[][] duplicate) {
        if(y == n - 1 && x == n - 1) {
            return;
        }


        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny < 0 || nx < 0 || ny >= n || nx >= n) {
                continue;
            }

            if(visited[ny][nx]) {
                continue;
            }

            if(duplicate[ny][nx] == 0) {
                duplicate[ny][nx] = duplicate[y][x] + map[ny][nx];
            } else if(duplicate[ny][nx] > map[ny][nx] + prefix) {
                duplicate[ny][nx] = prefix + map[ny][nx];
            } else {
                continue;
            }

            visited[ny][nx] = true;
            dfs(ny, nx, prefix + map[ny][nx], duplicate);
            visited[ny][nx] = false;
        }
    }
}
