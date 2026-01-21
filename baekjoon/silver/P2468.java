package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2468 {
    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(max < map[i][j]) {
                    max = map[i][j];
                }

                if(min > map[i][j]) {
                    min = map[i][j];
                }
            }
        }

        for(int num = min; num <= max; num++) {
            visited = new boolean[n][n];

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(map[i][j] <= num) {
                        visited[i][j] = true;
                    }
                }
            }


            int count = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(!visited[i][j]) {
                        count++;
                        bfs(i, j);
                    }
                }
            }


            if(answer < count) {
                answer = count;
            }
        }
        System.out.println(answer == 0 ? 1 : answer);
    }

    private static void bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for(int i = 0; i < 4; i++) {
                int ny = dy[i] + now[0];
                int nx = dx[i] + now[1];

                if(ny < 0 || nx < 0 || ny >= n || nx >= n) {
                    continue;
                }

                if(visited[ny][nx]) {
                    continue;
                }

                visited[ny][nx] = true;
                queue.add(new int[]{ny, nx});
            }
        }
    }
}
