package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P21609 {
    static int n;
    static int m;
    static int[][] map;
    static int num = 0;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    static int target;
    static int[] startPosition;
    static boolean[][] visited;
    static int stdY;
    static int stdX;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            startPosition = new int[2];

            int maxCount = 0;
            int maxZeroCount = 0;
            int bestY = 0;
            int bestX = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    visited = new boolean[n][n];
                    List<Integer> count;
                    if (map[i][j] >= 1 && map[i][j] <= m) {
                        count = bfs(i, j, map[i][j], false);
                    } else {
                        continue;
                    }

                    if(maxCount < count.get(0)) {
                        maxCount = count.get(0);
                        maxZeroCount = count.get(1);
                        bestY = stdY;
                        bestX = stdX;
                        startPosition[0] = i;
                        startPosition[1] = j;
                        target = map[i][j];
                    } else if (maxCount == count.get(0) && maxZeroCount < count.get(1)) {
                        maxCount = count.get(0);
                        maxZeroCount = count.get(1);
                        bestY = stdY;
                        bestX = stdX;
                        startPosition[0] = i;
                        startPosition[1] = j;
                        target = map[i][j];
                    } else if(maxCount == count.get(0) && maxZeroCount == count.get(1) && stdY > bestY) {
                        maxCount = count.get(0);
                        maxZeroCount = count.get(1);
                        bestY = stdY;
                        bestX = stdX;
                        startPosition[0] = i;
                        startPosition[1] = j;
                        target = map[i][j];
                    } else if(maxCount == count.get(0) && maxZeroCount == count.get(1) && stdY == bestY && stdX > bestX) {
                        maxCount = count.get(0);
                        maxZeroCount = count.get(1);
                        bestY = stdY;
                        bestX = stdX;
                        startPosition[0] = i;
                        startPosition[1] = j;
                        target = map[i][j];
                    }
                }
            }

            if(maxCount <= 1) {
                break;
            }

            num += maxCount * maxCount;
            visited = new boolean[n][n];
            bfs(startPosition[0], startPosition[1], target, true);
            // 중력 작용
            gravity();
            changeDegree();
            gravity();

        }

        System.out.println(num);
    }

    private static void changeDegree() {
        int[][] temp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = map[j][n - 1 - i];
            }
        }

        map = temp;
    }

    private static void gravity() {
        for (int x = 0; x < n; x++) {
            int writeRow = n - 1;

            for (int y = n - 1; y >= 0; y--) {
                if (map[y][x] == -1) {
                    writeRow = y - 1;
                } else if (map[y][x] != -100) {
                    int temp = map[y][x];
                    map[y][x] = -100;
                    map[writeRow][x] = temp;
                    writeRow--;
                }
            }
        }
    }

    private static List<Integer> bfs(int y, int x, int num, boolean flag) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});
        visited[y][x] = true;

        if (flag) {
            map[y][x] = -100;
        }

        int count = 1;
        int zeroCount = 0;
        stdY = y;
        stdX = x;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            if (map[now[0]][now[1]] == 0) {
                zeroCount++;
            } else {
                if (now[0] < stdY || (now[0] == stdY && now[1] < stdX)) {
                    stdY = now[0];
                    stdX = now[1];
                }
            }

            for (int i = 0; i < 4; i++) {
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];

                if (ny < 0 || nx < 0 || ny >= n || nx >= n) {
                    continue;
                }
                
                if (visited[ny][nx]) {
                    continue;
                }
                
                if (map[ny][nx] != num && map[ny][nx] != 0) {
                    continue;
                }
                
                if (flag) {
                    map[ny][nx] = -100;
                }

                visited[ny][nx] = true;
                count++;
                queue.add(new int[]{ny, nx});
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) {
                    visited[i][j] = false;
                }
            }
        }

        return Arrays.asList(count, zeroCount);
    }
}
