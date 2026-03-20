import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P16507 {
    static int r;
    static int c;
    static int q;
    static int[][] map;
    static int[][] position;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        map = new int[r][c];
        for(int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        position = new int[q][4];
        for(int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 4; j++) {
                position[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 누적합으로 풀어야되나..
        int[][] prefix = new int[r + 1][c + 1];

        // 2차원 누적합
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                // 상 + 좌 - 왼쪽 대각선 + map의 현재 좌표
                prefix[i][j] = prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1] + map[i - 1][j - 1];
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < q; i++) {
            int r1 = position[i][0];
            int c1 = position[i][1];
            int r2 = position[i][2];
            int c2 = position[i][3];

            // 2 2 4 5
            // 78 - 21 - 14 + 4
            int sum = prefix[r2][c2] - prefix[r1 - 1][c2] - prefix[r2][c1 - 1] + prefix[r1 - 1][c1 - 1];
            int count = (r2 - r1 + 1) * (c2 - c1 + 1);
            sb.append(sum / count).append("\n");
        }

        System.out.println(sb.toString());


        int[][] prefix2 = new int[r][c];

        // 내 방식대로 풀었을 경우
        for (int i = 0; i < r; i++) {
            prefix2[i][0] = map[i][0];
            for (int j = 1; j < c; j++) {
                prefix2[i][j] = prefix2[i][j - 1] + map[i][j];
            }
        }


        StringBuilder sb2 = new StringBuilder();

        for (int i = 0; i < q; i++) {
            int rStart = position[i][0] - 1;
            int rEnd = position[i][2] - 1;
            int cStart = position[i][1] - 1;
            int cEnd = position[i][3] - 1;

            int sum = 0;
            int count = (rEnd - rStart + 1) * (cEnd - cStart + 1);

            for (int y = rStart; y <= rEnd; y++) {
                if (cStart == 0) {
                    sum += prefix2[y][cEnd];
                } else {
                    sum += prefix2[y][cEnd] - prefix2[y][cStart - 1];
                }
            }

            int answer = sum / count;
            sb2.append(answer).append('\n');
        }

        System.out.print(sb2);
    }
}
