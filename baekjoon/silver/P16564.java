package baekjoon.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P16564 {
    static int n;
    static int k;
    static int[] level;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        level = new int[n];

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            level[i] = Integer.parseInt(st.nextToken());
            pq.add(level[i]);
            max = Math.max(max, level[i]);
            min = Math.min(min, level[i]);
        }

        // GPT 참고 코드
        long left = min;
        long right = max + k; // 가장 큰 값에 모든 레벨을 줬을 경우

        long answer = 0;
        while (left <= right) {
            long middle = (left + right) / 2;

            long needed = 0;
            for (int lv : level) {
                if (lv < middle) {
                    needed += (middle - lv); // mid까지 올리려면 얼마나 필요한지
                }
            }

            if (needed <= k) {
                // mid까지 만드는 게 가능 → 더 높여볼 수 있음
                answer = middle;
                left = middle + 1;
            } else {
                // 너무 높음 → 줄이자
                right = middle - 1;
            }
        }

        System.out.println(answer);


        // min 값을 유지하면서 가장 작은 값에 숫자를 더해줘야함
//        int left = 1;
//        int right = k;
//        while(left <= right && !pq.isEmpty()) {
//            // 중앙값 구하기
////            int middle = (left + right) % 2 == 0 ? (left + right) / 2 : (left + right) / 2 + 1;
//            int middle = (left + right) / 2;
//
//            // 가장 작은 값 뽑기!
//            Integer lowNumber = pq.poll();
//
//            if(pq.isEmpty()) {
//                lowNumber += k;
//                pq.add(lowNumber);
//                break;
//            }
//
//            // 1 2 3 4 5 6 7 8 9 10
//            // -> 15 20 15 // k = 5 로 초기화
//            // right = 5;
//            // 1 2 3 4 5
//            if(lowNumber + middle >= pq.peek()) {
//                // lowNumber에다 middle 더해줘서 값 변경!
//                lowNumber += middle;
//                // 올릴 수 있는 레벨 범위 줄여주기!
//                k -= middle;
//                // 다시 값 넣어주기!
//                pq.add(lowNumber);
//                right = k;
//            } else {
//                pq.add(lowNumber);
//                left = middle + 1;
//            }
//        }
//
//        if(k != 0 && n != 1) {
//            Integer lowNumber = pq.poll();
//            lowNumber += k;
//            pq.add(lowNumber);
//        }
//
//        System.out.println(pq);
//        System.out.println(pq.peek());


        // 25 + 20 + 30


        // 75
        // 25남음
        // 40 40 40
        // 48 49 48 // 1남음

    }
}
