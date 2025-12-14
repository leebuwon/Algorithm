package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P16236 {
    static int n;
    static int[][] map;
    static int[] startPosition;
    static int shark = 2;
    static int level = 2;
    static boolean[][] visited;
    static int[][] moveMap;
    static int moveCount = 0;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        startPosition = new int[2];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 9) {
                    startPosition[0] = i;
                    startPosition[1] = j;
                }
            }
        }

        while (true) {
            visited = new boolean[n][n];
            moveMap = new int[n][n];
            int move = bfs(startPosition[0], startPosition[1]);

            if(move == Integer.MAX_VALUE) {
                break;
            } else {
                level--;
                if(level == 0) {
                    shark++;
                    level = shark;
                }
                moveCount += move;
            }
        }

        System.out.println(moveCount);
    }

    private static int bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});
        visited[y][x] = true;
        List<int[]> candidate = new ArrayList<>();

        int minDist = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for(int i = 0; i < 4; i++) {
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];

                if(ny < 0 || nx < 0 || ny >= n || nx >= n) {
                    continue;
                }

                if(map[ny][nx] > shark) {
                    continue;
                }

                if(visited[ny][nx]) {
                    continue;
                }

                moveMap[ny][nx] = moveMap[now[0]][now[1]] + 1;

                // shark level up (물고기를 잡았으니간 visited 초기화)
                if(map[ny][nx] != 0 && map[ny][nx] < shark) {
                    int dist = moveMap[ny][nx];

                    if(dist < minDist) {
                        minDist = dist;
                        candidate.clear();
                        candidate.add(new int[]{ny, nx});
                    } else if(dist == minDist) {
                        candidate.add(new int[]{ny, nx});
                    }
                }

                queue.add(new int[]{ny, nx});
                visited[ny][nx] = true;
            }
        }

        if(candidate.isEmpty()) {
            return Integer.MAX_VALUE;
        }

        // 위쪽에 있는거부터 먹기
        candidate.sort((a, b) -> {
            if(a[0] != b[0]) {
                return a[0] - b[0];
            }

            return a[1] - b[1];
        });

        int[] targetFish = candidate.get(0);
        map[targetFish[0]][targetFish[1]] = 9;
        map[y][x] = 0;
        startPosition[0] = targetFish[0];
        startPosition[1] = targetFish[1];

        return moveMap[targetFish[0]][targetFish[1]];
    }
}
