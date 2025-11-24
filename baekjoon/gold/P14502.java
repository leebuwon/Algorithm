package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P14502 {
    static int n;
    static int m;
    static int[][] map;
    static int[][] duplicateMap;
    static boolean[][] visited;
    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {1, -1, 0, 0};
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        duplicateMap = new int[n][m];
        visited = new boolean[n][m];

        List<int[]> zeroPoint = new ArrayList<>();
        List<int[]> virusPoint = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 0) {
                    zeroPoint.add(new int[]{i, j});
                }

                if(map[i][j] == 2) {
                    virusPoint.add(new int[]{i, j});
                }
            }
        }

        // 벽은 3개만 세울 수 있음!
        for(int i = 0; i < zeroPoint.size(); i++) {
            for(int j = i + 1; j < zeroPoint.size(); j++) {
                for(int k = j + 1; k < zeroPoint.size(); k++) {
                    int[] firstWall = zeroPoint.get(i);
                    int[] secondWall = zeroPoint.get(j);
                    int[] thirdWall = zeroPoint.get(k);

                    for (int a = 0; a < n; a++) {
                        duplicateMap[a] = map[a].clone();
                    }

                    // 임시벽 설치
                    duplicateMap[firstWall[0]][firstWall[1]] = 1;
                    duplicateMap[secondWall[0]][secondWall[1]] = 1;
                    duplicateMap[thirdWall[0]][thirdWall[1]] = 1;

                    visited = new boolean[n][m];
                    for (int[] virus : virusPoint) {
                        dfs(virus[0], virus[1]);
                    }

                    int count = 0;
                    for(int y = 0; y < n; y++) {
                        for (int x = 0; x < m; x++) {
                            if(duplicateMap[y][x] == 0) {
                                count++;
                            }
                        }
                    }

                    max = Math.max(count, max);

                    if(max == 30) {
                        System.out.println(Arrays.deepToString(duplicateMap));
                    }

                    // 벽 허물기
                    duplicateMap[firstWall[0]][firstWall[1]] = 0;
                    duplicateMap[secondWall[0]][secondWall[1]] = 0;
                    duplicateMap[thirdWall[0]][thirdWall[1]] = 0;
                }
            }
        }

        System.out.println(max);
    }

    private static void dfs(int virusY, int virusX) {
        visited[virusY][virusX] = true;

        for(int i = 0; i < 4; i++) {
            int ny = virusY + dy[i];
            int nx = virusX + dx[i];

            if(ny < 0 || nx < 0 || ny >= n || nx >= m) {
                continue;
            }

            if(duplicateMap[ny][nx] != 0 || visited[ny][nx]) {
                continue;
            }

            duplicateMap[ny][nx] = 2;
            dfs(ny, nx);
        }

    }
}
