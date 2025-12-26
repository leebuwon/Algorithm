package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// DFS 사용해서 다시한번 풀어보기
public class P14500 {
    static int n;
    static int m;
    static int[][] map;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int[] now = new int[]{i, j};
                stick(now);
                square(now);
                jet(now);
                nieun(now);
                fuck(now);
            }
        }

        System.out.println(max);
    }

    private static void stick(int[] now) {
        int y = now[0];
        int x = now[1];

        if(x + 3 < m) {
            int sum = map[y][x] + map[y][x + 1] + map[y][x + 2] + map[y][x + 3];
            max = Math.max(max, sum);
        }

        if(y + 3 < n) {
            int sum = map[y][x] + map[y + 1][x] + map[y + 2][x] + map[y + 3][x];
            max = Math.max(max, sum);
        }
    }

    private static void square(int[] now) {
        int y = now[0];
        int x = now[1];

        if(x + 1 < m && y + 1 < n) {
            int sum = map[y][x] + map[y][x + 1] + map[y + 1][x] + map[y + 1][x + 1];
            max = Math.max(max, sum);
        }
    }

    private static void jet(int[] now) {
        int y = now[0];
        int x = now[1];

        if(x + 2 < m && y + 1 < n) {
            int sum = map[y][x] + map[y][x + 1] + map[y + 1][x + 1] + map[y + 1][x + 2];
            max = Math.max(max, sum);
        }

        if(x + 2 < m && y - 1 >= 0) {
            int sum = map[y][x] + map[y][x + 1] + map[y - 1][x + 1] + map[y - 1][x + 2];
            max = Math.max(max, sum);
        }

        if(x + 1 < m && y + 2 < n) {
            int sum = map[y][x] + map[y + 1][x] + map[y + 1][x + 1] + map[y + 2][x + 1];
            max = Math.max(max, sum);
        }

        if(x - 1 >= 0 && y + 2 < n) {
            int sum = map[y][x] + map[y + 1][x] + map[y + 1][x - 1] + map[y + 2][x - 1];
            max = Math.max(max, sum);
        }
    }

    private static void nieun(int[] now) {
        int y = now[0];
        int x = now[1];

        if(x + 1 < m && y + 2 < n) {
            int sum = map[y][x] + map[y][x + 1] + map[y + 1][x] + map[y + 2][x];
            max = Math.max(max, sum);
        }

        if(x - 1 >= 0 && y + 2 < n) {
            int sum = map[y][x] + map[y][x - 1] + map[y + 1][x] + map[y + 2][x];
            max = Math.max(max, sum);
        }

        if(x + 2 < m && y + 1 < n) {
            int sum = map[y][x] + map[y][x + 1] + map[y][x + 2] + map[y + 1][x];
            max = Math.max(max, sum);
        }

        if(x + 2 < m && y - 1 >= 0) {
            int sum = map[y][x] + map[y][x + 1] + map[y][x + 2] + map[y - 1][x];
            max = Math.max(max, sum);
        }

        if(x + 1 < m && y - 2 >= 0) {
            int sum = map[y][x] + map[y -1][x] + map[y - 2][x] + map[y][x + 1];
            max = Math.max(max, sum);
        }

        if(x - 1 >= 0 && y - 2 >= 0) {
            int sum = map[y][x] + map[y -1][x] + map[y - 2][x] + map[y][x - 1];
            max = Math.max(max, sum);
        }

        if(x - 2 >= 0 && y + 1 < n) {
            int sum = map[y][x] + map[y][x - 1] + map[y][x - 2] + map[y + 1][x];
            max = Math.max(max, sum);
        }

        if(x - 2 >= 0 && y - 2 >= 0) {
            int sum = map[y][x] + map[y][x - 1] + map[y][x - 2] + map[y - 1][x];
            max = Math.max(max, sum);
        }
    }

    private static void fuck(int[] now) {
        int y = now[0];
        int x = now[1];

        if(x + 2 < m && y - 1 >= 0) {
            int sum = map[y][x] + map[y][x + 1] + map[y][x + 2] + map[y - 1][x + 1];
            max = Math.max(max, sum);
        }

        if(x + 2 < m && y + 1 < n) {
            int sum = map[y][x] + map[y][x + 1] + map[y][x + 2] + map[y + 1][x + 1];
            max = Math.max(max, sum);
        }

        if(x + 1 < m && y + 2 < n) {
            int sum = map[y][x] + map[y + 1][x] + map[y + 2][x] + map[y + 1][x + 1];
            max = Math.max(max, sum);
        }

        if(x - 1 >= 0 && y + 2 < n) {
            int sum = map[y][x] + map[y + 1][x] + map[y + 2][x] + map[y + 1][x - 1];
            max = Math.max(max, sum);
        }
    }
}
