package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P3055 {
    static int r;
    static int c;
    static String[][] map;
    static int[][] waterTime;
    static int[][] beaverTime;
    static boolean[][] beaverVisited;
    static boolean[][] waterVisited;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    static int moveCount = Integer.MAX_VALUE;
    static boolean isTrue = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new String[r][c];
        waterTime = new int[r][c];
        beaverTime = new int[r][c];
        beaverVisited = new boolean[r][c];
        waterVisited = new boolean[r][c];

        int[] startPosition = new int[2];
        Queue<int[]> waterQueue = new LinkedList<>();
        for(int i = 0; i < r; i++) {
            String s = br.readLine().trim();
            for(int j = 0 ; j < s.length(); j++) {
                char c = s.charAt(j);
                map[i][j] = String.valueOf(c);

                if(map[i][j].equals("S")) {
                    startPosition[0] = i;
                    startPosition[1] = j;
                }

                if(map[i][j].equals("*")) {
                    waterQueue.add(new int[]{i, j, 0});
                    waterVisited[i][j] = true;
                }
            }
        }

        waterBfs(waterQueue);
        beaverBfs(startPosition[0], startPosition[1]);

        if(isTrue) {
            System.out.println(moveCount);
        } else {
            System.out.println("KAKTUS");
        }
    }

    private static void beaverBfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x, 0});
        beaverVisited[y][x] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for(int i = 0; i < 4; i++) {
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];
                int time = now[2];

                if (ny < 0 || nx < 0 || ny >= r || nx >= c) {
                    continue;
                }

                if(map[ny][nx].equals("X")) {
                    continue;
                }

                if(map[ny][nx].equals("D")) {
                    if(moveCount > beaverTime[now[0]][now[1]] + 1) {
                        moveCount = beaverTime[now[0]][now[1]] + 1;
                    }
                    isTrue = true;
                }

                if(beaverVisited[ny][nx]) {
                    continue;
                }

                // 물이 범란하고 고슴도치가 들어가는거기 때문에 continue
                if(waterVisited[ny][nx]) {
                    if(waterTime[ny][nx] <= beaverTime[now[0]][now[1]] + 1) {
                        continue;
                    }
                }

                if(map[ny][nx].equals(".")) {
                    beaverTime[ny][nx] = time + 1;
                    queue.add(new int[]{ny, nx, time + 1});
                    beaverVisited[ny][nx] = true;
                }
            }
        }
    }

    private static void waterBfs(Queue<int[]> waterQueue) {
        while (!waterQueue.isEmpty()) {
            int[] now = waterQueue.poll();
            int y = now[0];
            int x = now[1];
            int time = now[2];

            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];

                if (ny < 0 || nx < 0 || ny >= r || nx >= c) {
                    continue;
                }

                if (map[ny][nx].equals("X") || map[ny][nx].equals("D") || map[ny][nx].equals("S")) {
                    continue;
                }

                if (waterVisited[ny][nx]) {
                    continue;
                }

                waterVisited[ny][nx] = true;
                waterTime[ny][nx] = time + 1;
                waterQueue.add(new int[]{ny, nx, time + 1});
            }
        }
    }
}
