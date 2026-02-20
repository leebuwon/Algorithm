package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P3085 {
    static int n;
    static String[][] str;
    static int max = Integer.MIN_VALUE;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        str = new String[n][n];
        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            for(int j = 0; j < s.length(); j++) {
                str[i][j] = String.valueOf(s.charAt(j));
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                move(str[i][j], i, j);
            }
        }

        System.out.println(max);
    }

    private static void move(String s, int y, int x) {
        String[][] tempStr = new String[n][n];

        for(int i = 0; i < n; i++) {
            tempStr[i] = str[i].clone();
        }

        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny < 0 || nx < 0 || ny >= n || nx >= n) {
                continue;
            }

            String temp = tempStr[y][x];
            tempStr[y][x] = tempStr[ny][nx];
            tempStr[ny][nx] = temp;

            int rowMax = checkRow(tempStr, y);
            rowMax = Math.max(rowMax, checkRow(tempStr, ny));

            int colMax = checkCol(tempStr, x);
            colMax = Math.max(colMax, checkCol(tempStr, nx));

            max = Math.max(max, Math.max(rowMax, colMax));

            // 원산복구
            temp = tempStr[ny][nx];
            tempStr[ny][nx] = tempStr[y][x];
            tempStr[y][x] = temp;
        }
    }

    private static int checkRow(String[][] board, int row) {
        int count = 1;
        int result = 1;

        for (int j = 1; j < n; j++) {
            if (board[row][j].equals(board[row][j - 1])) {
                count++;
            } else {
                count = 1;
            }
            result = Math.max(result, count);
        }

        return result;
    }

    private static int checkCol(String[][] board, int col) {
        int count = 1;
        int result = 1;

        for (int i = 1; i < n; i++) {
            if (board[i][col].equals(board[i - 1][col])) {
                count++;
            } else {
                count = 1;
            }
            result = Math.max(result, count);
        }

        return result;
    }
}
