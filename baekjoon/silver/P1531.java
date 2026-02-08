package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1531 {
    static int n;
    static int m;
    static int[][] coordinate;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        coordinate = new int[n][4];
        map = new int[100][100];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            coordinate[i][0] = Integer.parseInt(st.nextToken()) - 1;
            coordinate[i][1] = Integer.parseInt(st.nextToken()) - 1;
            coordinate[i][2] = Integer.parseInt(st.nextToken()) - 1;
            coordinate[i][3] = Integer.parseInt(st.nextToken()) - 1;
        }

        for(int i = 0; i < n; i++) {

            // 왼쪽 아래   x :21 | y : 21
            // 오른쪽 아래 x : 80 | y : 80
            for(int y = coordinate[i][1]; y <= coordinate[i][3]; y++) {
                for(int x = coordinate[i][0]; x <= coordinate[i][2]; x++) {
                    map[y][x]++;
                }
            }
        }

        int count = 0;
        for(int i = 0; i < 100; i++) {
            for(int j = 0; j < 100; j++) {
                if(map[i][j] > m) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
