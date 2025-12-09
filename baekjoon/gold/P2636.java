package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2636 {
    static int n;
    static int m;
    static int[][] cheese;
    static boolean[][] meltCheese;
    static boolean[][] visited;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        cheese = new int[n][m];
        meltCheese = new boolean[n][m];
        visited = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                cheese[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int day = 0;
        while (true) {
            int cheeseCount = 0;
            bfs(0, 0);

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(meltCheese[i][j]) {
                        cheese[i][j] = 0;
                        cheeseCount++;
                    }
                }
            }

            if(cheeseCount == 0) {
                break;
            }

            day++;
            min = cheeseCount;
            visited = new boolean[n][m];
            meltCheese = new boolean[n][m];
        }

        System.out.println(day);
        System.out.println(min);
    }

    private static int bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});
        int cheeseCount = 1;

        while (!queue.isEmpty()) {
            int[] currentCheese = queue.poll();


            for (int i = 0; i < 4; i++) {
                int ny = currentCheese[0] + dy[i];
                int nx = currentCheese[1] + dx[i];

                if (ny < 0 || nx < 0 || ny >= n || nx >= m) {
                    continue;
                }

                // 현재 치즈의 위치에서 동서남북을 판단하여 0이라면 meltCheese에 true 표시
                if (cheese[ny][nx] == 1) {
                    meltCheese[ny][nx] = true;
                }

                if (visited[ny][nx]) {
                    continue;
                }

                if (cheese[ny][nx] == 0) {
                    queue.add(new int[]{ny, nx});
                    cheeseCount++;
                    visited[ny][nx] = true;
                }
            }
        }

        return cheeseCount;
    }
}
