package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2178 {
    static int n;
    static int m;
    static int[][] map;
    static boolean[][] visited;
    static int[][] countMap;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        countMap = new int[n][m];

        for(int i = 0; i < n; i++) {
            String str = br.readLine().trim();
            for(int j = 0; j < m; j++) {
                char num = str.charAt(j);
                map[i][j] = num - '0';
            }
        }

        bfs(0, 0);
//        dfs(0, 0);

        System.out.println(countMap[n - 1][m - 1]);
    }

    private static void bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});
        visited[y][x] = true;
        count++;
        countMap[y][x] = count;
        
        while (!queue.isEmpty()) {
            int[] location = queue.poll();
            
            for(int i = 0; i < 4; i++) {
                int ny = location[0] + dy[i];
                int nx = location[1] + dx[i];

                if(ny < 0 || nx < 0 || ny >= n || nx >= m) {
                    continue;
                }

                if(visited[ny][nx]) {
                    continue;
                }

                if(map[ny][nx] != 1) {
                    continue;
                }

                visited[ny][nx] = true;
                countMap[ny][nx] = countMap[location[0]][location[1]] + 1;
                queue.add(new int[]{ny, nx});
            }
        }
        
    }

    // 깊이 우선탐색으로는 해결을 하지 못할것같음...
    private static void dfs(int y, int x) {
        // 방문한곳은 true 표시
        visited[y][x] = true;
        count++;
        countMap[y][x] = count;

        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny < 0 || nx < 0 || ny >= n || nx >= m) {
                continue;
            }

            if(visited[ny][nx]) {
                continue;
            }

            if(map[ny][nx] != 1) {
                continue;
            }

            dfs(ny, nx);
            count--;
        }

    }
}
