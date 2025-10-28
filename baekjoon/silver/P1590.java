package baekjoon.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1590 {
    static int n;
    static int t;
    static int[][] bus;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        bus = new int[n][3];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++) {
                bus[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 시작 시각, 간격, 대수

        // 150 50 10
        // 150 200 250 300 350 400 450 500 550 600

        // 1 123456
        // 123456 10000 1
        // 123456 133456
        int waiting = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            int startTime = bus[i][0];  // 버스 출발 시간
            int interval = bus[i][1];   // 버스 간격
            int totalBus = bus[i][2];   // 버스 총 대수

            int[] busInterval = new int[totalBus];
            busInterval[0] = startTime;

            if (busInterval[0] == t) {
                waiting = 0;
                break;
            }
            
            // 2 20
            // 10 10 2
            // 30 5 3
            // 10 20
            // 30 35 40
            int time = startTime;
            int count = 1;
            while (count <= totalBus) {
                // 버스가 한대 출발했다고 생각
                if (time < t) {
                    time += interval;
                    count++;
                } else {
                    waiting = Math.min(waiting, Math.abs(time - t));
                    break;
                }
            }
        }

        System.out.println(waiting == Integer.MAX_VALUE ? -1 : waiting);

    }
}
