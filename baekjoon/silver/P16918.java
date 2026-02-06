package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P16918 {
    static int r;
    static int c;
    static int n;
    static String[][] map;
    static int[][] seconds;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new String[r][c];
        seconds = new int[r][c];

        for(int i = 0; i < r; i++) {
            String str = br.readLine().trim();
            for(int j = 0; j < str.length(); j++) {
                map[i][j] = String.valueOf(str.charAt(j));

                if(map[i][j].equals("O")) {
                    seconds[i][j] = 3;
                }
            }
        }

        // 붐버맨이 있는 곳에는 폭탄이 터지면 현장소 + 상하좌우에 폭탄이 터짐


        // n초로 카운터
        for(int second = 2; second <= n; second++) {
            // 폭탄이 터질때는 체크하지 않도록 수정
            visited = new boolean[r][c];

            // n % 2 == 0 (이경우에는 격자판을 다 채우자)
            if(second % 2 == 0) {
                for(int i = 0; i < r; i++) {
                    for(int j = 0; j < c; j++) {
                        if(map[i][j].equals(".")) {
                            map[i][j] = "O";
                            seconds[i][j] = second + 3;
                        }
                    }
                }
            }

            if(second % 2 == 1) {
                for(int i = 0; i < r; i++) {
                    for(int j = 0; j < c; j++) {
                        if(seconds[i][j] == second) {
                            boom(i, j, second);
                        }
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void boom(int y, int x, int second) {
        map[y][x] = ".";
        seconds[y][x] = 0;
        visited[y][x] = true;

        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny < 0 || nx < 0 || ny >= r || nx >= c) {
                continue;
            }

            if(visited[ny][nx]) {
                continue;
            }

            if(map[ny][nx].equals("O") && seconds[ny][nx] == second) {
                continue;
            }

            map[ny][nx] = ".";
            seconds[ny][nx] = 0;
            visited[ny][nx] = true;
        }
    }
}
