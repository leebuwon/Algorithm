package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P7576 {
    static int x; // 가로 칸 (x축)
    static int y; // 세로 칸 (y축)
    static int[][] map;
    static boolean[][] visited;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    static int totalTomato = 0;
    static int checkCount = 0;
    static int day = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        x = Integer.parseInt(st.nextToken()); // x축
        y = Integer.parseInt(st.nextToken()); // y축
        map = new int[y][x];
        visited = new boolean[y][x];

        // 안 익은 사과의 갯수 구하기
        List<int[]> tomatoList = new ArrayList<>();
        for(int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < x; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) {
                    tomatoList.add(new int[]{i, j});
                }

                if(map[i][j] == -1) {
                    visited[i][j] = true;
                }

                if(map[i][j] == 0){
                    totalTomato++;
                }
            }
        }
        bfs(tomatoList);
        if (checkCount == totalTomato) {
            System.out.println(--day);
        } else {
            System.out.println(-1); // 모든 토마토를 체크하지 못했을 경우 -1 리턴
        }
    }

    private static void bfs(List<int[]> tomatoList) {
        Queue<int[]> queue = new LinkedList<>();
        for (int[] tomato : tomatoList) {
            queue.add(new int[]{tomato[0], tomato[1]});
            visited[tomato[0]][tomato[1]] = true;
        }

        while (!queue.isEmpty()) {
            int currentTomatoSize = queue.size();

            for(int i = 0; i < currentTomatoSize; i++) {
                int[] tomato = queue.poll();

                // 동서남북으로 순회
                for(int j = 0; j < 4; j++) {
                    int ny = tomato[0] + dy[j];
                    int nx = tomato[1] + dx[j];

                    // 범위를 벗어날 경우
                    if(ny < 0 || nx < 0 || ny >= y || nx >= x) {
                        continue;
                    }

                    if(!visited[ny][nx]) {
                        checkCount++;
                        visited[ny][nx] = true;
                        queue.add(new int[]{ny, nx});
                    }
                }
            }
            day++;
        }
    }
}
