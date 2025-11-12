package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1715 {
    static int n;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(Integer.parseInt(st.nextToken()));
        }

        int prefixSum = 0;
        while (!pq.isEmpty()) {
            int combine = 0;
            Integer minNum = pq.poll();

            // 만약 하나를 뻇는데 pq가 비었을 경우
            if(pq.isEmpty()) {
               break;
            }

            Integer nextMinNum = pq.poll();

            combine += minNum + nextMinNum;
            prefixSum += combine;
            pq.add(combine);
        }

        System.out.println(prefixSum);
    }
}
