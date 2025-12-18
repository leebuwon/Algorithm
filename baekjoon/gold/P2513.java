package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// GPT 참고
public class P2513 {
    static int n;
    static int k;
    static int s;
    static int[] remain;
    static int[][] apart;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // n : 아파트 단지 수
        // k : 통학버스 정원
        // s : 학교 위치
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        apart = new int[n][2];

        int max = Integer.MIN_VALUE;
        PriorityQueue<Integer> leftQ = new PriorityQueue<>();
        PriorityQueue<Integer> rightQ = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            apart[i][0] = Integer.parseInt(st.nextToken());
            apart[i][1] = Integer.parseInt(st.nextToken());

            if(apart[i][0] > max) {
                max = apart[i][0];
            }

            if(s > apart[i][0]) {
                leftQ.add(apart[i][0]);
            } else {
                rightQ.add(apart[i][0]);
            }
        }

        remain = new int[max + 1];
        for(int i = 0; i < n; i++) {
            remain[apart[i][0]] = apart[i][1];
        }

        int leftDist = 0;
        int capacity = 0;
        while (!leftQ.isEmpty()) {
            int now = leftQ.poll();
            int people = remain[now];

            while (people > 0) {
                if(capacity == 0) {
                    int abs = Math.abs(s - now);
                    leftDist += abs * 2;
                }

                int take = Math.min(k - capacity, people);
                capacity += take;
                people -= take;

                if (capacity == k) {
                    capacity = 0;
                }
            }

            remain[now] = 0;
        }

        int rightDist = 0;
        capacity = 0;
        while (!rightQ.isEmpty()) {
            int now = rightQ.poll();
            int people = remain[now];

            while (people > 0) {
                if (capacity == 0) {
                    int abs = Math.abs(s - now);
                    rightDist += abs * 2;
                }

                int take = Math.min(k - capacity, people);
                capacity += take;
                people -= take;

                if (capacity == k) {
                    capacity = 0;
                }
            }

            remain[now] = 0;
        }

        System.out.println(leftDist + rightDist);
    }
}
