package baekjoon.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P17245 {
    static int n;
    static int[][] computer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        computer = new int[n][n];
        int maxComputerTop = 0;
        long totalComputer = 0;

//        Map<Integer, Integer> computerTop = new HashMap<>();
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                computer[i][j] = Integer.parseInt(st.nextToken());
                totalComputer += computer[i][j];

//                if(computer[i][j] > 0) {
//                    computerTop.put(computer[i][j], computerTop.getOrDefault(computer[i][j], 0) + 1);
//                }

                maxComputerTop = Math.max(maxComputerTop, computer[i][j]);
            }
        }

        // 높이 별로 count 구하기
        int[] floorCount = new int[maxComputerTop + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 햔제 층수의 index 더해주기!
                floorCount[computer[i][j]]++;
            }
        }

        // 누적합
        int[] cumulativeSum = new int[maxComputerTop + 2]; // 0번쨰 인덱스와 마지막 인덱스는 포함 X
        for (int i = maxComputerTop; i >= 1; i--) {
            // 현재 층과 윗 층의 계수를 누적합으로 판별해준다.
            cumulativeSum[i] = cumulativeSum[i + 1] + floorCount[i];
        }

        // 14 -> 7개 켜지면 ok
        // 85 -> 34
        long halfComputer = totalComputer % 2 == 0 ? totalComputer / 2 : totalComputer / 2 + 1;
        int time = 0;
        long computerOn = 0;

        while (computerOn < halfComputer) {
            time++;
            computerOn += cumulativeSum[time];
        }

        System.out.println(time);



        // 시간 초과
//        while (halfComputer >= computerOn) {
//            time++;
//            Map<Integer, Integer> next = new TreeMap<>();
//
//            for (Map.Entry<Integer, Integer> entry : computerTop.entrySet()) {
//                int floor = entry.getKey();
//                int count = entry.getValue();
//
//                if (floor == 0) {
//                    continue;
//                }
//
//                int nextFloor = floor - 1;
//
//                // 기존에 있던 층에 더해주기
//                next.put(nextFloor, count);
//
//                // 켜진 컴퓨터 수 누적
//                computerOn += count;
//            }
//            // 이번 회차의 이동 결과로 map 업데이트
//            computerTop = next;
//        }
    }
}
