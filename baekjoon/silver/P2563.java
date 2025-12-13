package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2563 {
    static int n;
    static int[][] confettis;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        confettis = new int[n][2];
        map = new int[100][100];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            confettis[i][0] = Integer.parseInt(st.nextToken());
            confettis[i][1] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        for (int[] confetti : confettis) {
            int width = confetti[0];
            int height = confetti[1];
            int anotherHeight = height + 10;
            int anotherWidth = width + 10;

            for(int i = height; i < anotherHeight; i++) {
                for(int j =width; j < anotherWidth; j++) {
                    map[i][j] = 1;
                }
            }
        }

        for(int i = 0; i < 100; i++) {
            for(int j = 0; j < 100; j++) {
                if(map[i][j] == 1) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
