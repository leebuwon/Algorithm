package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1926 {
    static int n;
    static int m;
    static int[][] map;
    static boolean[][] visited;
    static int currentPictureCount = 0;
    static int max = 0;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int pictureCount = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!visited[i][j] && map[i][j] == 1) {
                    pictureCount++;
                    currentPictureCount++;
                    dfs(i, j);

                    if(max < currentPictureCount) {
                        max = currentPictureCount;
                    }
                    currentPictureCount = 0;
                }
            }
        }

        System.out.println(pictureCount);
        System.out.println(max);
    }

    private static void dfs(int y, int x) {
        visited[y][x] = true;

        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny < 0 || nx < 0 || ny >= n || nx >= m) {
                continue;
            }

            if(visited[ny][nx] || map[ny][nx] != 1) {
                continue;
            }


            currentPictureCount++;
            dfs(ny, nx);
        }
    }
}
