package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P14497 {
    static int n;
    static int m;
    static int[] position;
    static boolean[][] visited;
    static char[][] map;
    static int[][] dist;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

         n = Integer.parseInt(st.nextToken());
         m = Integer.parseInt(st.nextToken());
         position = new int[4];
         map = new char[n][m];
         dist = new int[n][m];
         visited = new boolean[n][m];

         st = new StringTokenizer(br.readLine());
         for(int i = 0; i < 4; i++) {
             position[i] = Integer.parseInt(st.nextToken());
         }

         for(int i = 0; i < n; i++) {
             String str = br.readLine();
             for(int j = 0; j < m; j++) {
                 map[i][j] = str.charAt(j);
             }
         }

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

//         overlap(position[0] - 1, position[1] - 1);
        dijkstra(position[0] - 1, position[1] - 1);

        int answer = dist[position[2] - 1][position[3] - 1];
        System.out.println(answer);
    }

    private static void dijkstra(int y, int x) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.add(new int[]{y, x, 0});

        while (!pq.isEmpty()) {
            int[] now = pq.poll();

            if(visited[now[0]][now[1]]) {
                continue;
            }

            visited[now[0]][now[1]] = true;

            for(int i = 0; i < 4; i++) {
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];

                if(ny < 0 || nx < 0 || ny >= n || nx >= m) {
                    continue;
                }

                int nextCost = 0;
                if(map[ny][nx] == '1' || map[ny][nx] == '#') {
                    nextCost = now[2] + 1;
                } else {
                    nextCost = now[2];
                }

                if(!visited[ny][nx] && dist[ny][nx] > nextCost) {
                    dist[ny][nx] = nextCost;
                    pq.add(new int[]{ny, nx, nextCost});
                }
            }
        }
    }

    // bfs 메모리 초과
    private static void overlap(int y, int x) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{y, x});
        dist[y][x] = 0;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for(int i = 0; i < 4; i++) {
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];

                if(ny < 0 || nx < 0 || ny >= n || nx >= m) {
                    continue;
                }

                if(dist[ny][nx] != Integer.MAX_VALUE && dist[ny][nx] < dist[now[0]][now[1]] + 1) {
                    continue;
                }

                queue.add(new int[]{ny, nx});
                if(map[ny][nx] == '1') {
                    dist[ny][nx] = dist[now[0]][now[1]] + 1;
                } else {
                    dist[ny][nx] = dist[now[0]][now[1]];
                }
            }
        }
    }
}
