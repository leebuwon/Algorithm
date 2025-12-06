package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P18111 {
    static int n;
    static int m;
    static int b;
    static int[][] map;
    static int[] floorValue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        Map<Integer, Integer> floor = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                floor.put(map[i][j], floor.getOrDefault(map[i][j], 0) + 1);

                if (map[i][j] > max) {
                    max = map[i][j];
                }

                if (map[i][j] < min) {
                    min = map[i][j];
                }
            }
        }

        floorValue = new int[max + 1];
        for (int i = min; i <= max; i++) {
            int totalBlockCount = 0;
            int removeBlock = 0;
            int time = 0;
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < m; x++) {
                    if (map[y][x] == i) {
                        continue;
                    }

                    // 2초
                    if (map[y][x] > i) {
                        int diff = map[y][x] - i;
                        removeBlock += diff;
                        time += (diff * 2);
                    }

                    // 1초
                    if (map[y][x] < i) {
                        int diff = i - map[y][x];
                        totalBlockCount += diff;
                        time += diff;
                    }
                }
            }

            if (b + removeBlock < totalBlockCount) {
                floorValue[i] = Integer.MAX_VALUE;
                continue;
            }

            floorValue[i] = time;
        }

        int answerCount = Integer.MAX_VALUE;
        int answerFloor = 0;
        for(int i = min; i <= max; i++) {
            if(floorValue[i] <= answerCount) {
                answerCount = floorValue[i];
                answerFloor = i;
            }
        }

        System.out.print(answerCount + " ");
        System.out.println(answerFloor);
    }
}
