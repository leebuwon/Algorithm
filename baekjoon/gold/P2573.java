package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2573 {
    static int n;
    static int m;
    static int[][] icebergs;
    static boolean[][] visited;
    static int[][] minus;
    static int year = 0;
    static int divide = 0; // 빙하 갯수 판단
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        icebergs = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                icebergs[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            minus = new int[n][m];
            divide = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(icebergs[i][j] != 0) {
                        // 빙산의 상하좌우를 판단
                        visited[i][j] = true;
                        for(int k = 0; k < 4; k++) {
                            int ny = i + dy[k];
                            int nx = j + dx[k];

                            if(ny < 0 || nx < 0 || ny >= n || nx >= m || visited[ny][nx]) {
                                continue;
                            }

                            if(icebergs[ny][nx] == 0) {
                                minus[i][j]++;
                            }
                        }

                        icebergs[i][j] -= minus[i][j];
                        if(icebergs[i][j] < 0) {
                            icebergs[i][j] = 0;
                        }
                    }
                }
            }
            // 한번 모든 빙산을 녹였기 때문에 year++
            year++;
            // 방문한거 초기화
            visited = new boolean[n][m];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(!visited[i][j] && icebergs[i][j] != 0) {
                        divide++;
                        dfs(i, j);
                    }
                }
            }

            // 빙하가 2개이상으로 쪼개졌을 경우
            if(divide >= 2) {
                System.out.println(year);
                break;
            }

            // 빙하가 전부 녹았을 경우
            if(divide == 0) {
                System.out.println(0);
                break;
            }


        }

    }

    private static void dfs(int y, int x) {
        visited[y][x] = true;

        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny < 0 || nx < 0 || ny >= n || nx >= m) {
                continue;
            }

            if(visited[ny][nx]) {
                continue;
            }

            if (icebergs[ny][nx] > 0) {
                dfs(ny, nx);
            }

        }
    }
}
