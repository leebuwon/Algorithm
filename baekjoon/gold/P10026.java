package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10026 {
    static int n;
    static String[][] rectangle;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int cnt = 0;
    static int[] answer = new int[2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        rectangle = new String[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            String[] line = br.readLine().split("");
            for(int j = 0; j < n; j++) {
                rectangle[i][j] = line[j];
            }
        }

        // 적록색약이 아닌 사람의 경우
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                // i == y / j == x
                String color = rectangle[i][j];
                if(!visited[i][j]) {
                    visited[i][j] = true;
                    cnt++;
                    nonBlindnessDfs(i, j, color);
                }
            }
        }

        answer[0] = cnt;

        cnt = 0;
        visited = new boolean[n][n];
        // 적록색약인 사람의 경우
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                // i == y / j == x
                String color = rectangle[i][j];
                if(!visited[i][j]) {
                    visited[i][j] = true;
                    cnt++;
                    blindnessDfs(i, j, color);
                }
            }
        }

        answer[1] = cnt;
        System.out.print(answer[0] + " " + answer[1]);
    }

    private static void nonBlindnessDfs(int y, int x, String color) {
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= n || ny >= n) {
                continue;
            }

            if(rectangle[ny][nx].equals(color) && !visited[ny][nx]) {
                visited[ny][nx] = true;
                nonBlindnessDfs(ny, nx, color);
            }
        }
    }

    private static void blindnessDfs(int y, int x, String color) {
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= n || ny >= n) {
                continue;
            }


            if(!visited[ny][nx] && isSameColor(color, rectangle[ny][nx])) {
                visited[ny][nx] = true;
                blindnessDfs(ny, nx, color);
            }
        }
    }

    private static boolean isSameColor(String color, String nextColor) {
        if(color.equals(nextColor)) {
            return true;
        }

        // GPT 참고
        return (color.equals("R") || color.equals("G")) && (nextColor.equals("R") || nextColor.equals("G"));
    }
}
