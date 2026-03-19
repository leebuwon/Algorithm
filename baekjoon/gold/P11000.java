package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P11000 {
    static int n;
    static int[][] classroom;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        classroom = new int[n][2];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            classroom[i][0] = Integer.parseInt(st.nextToken());
            classroom[i][1] = Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;
        Arrays.sort(classroom, (a, b) -> a[0] - b[0]);

        // 1 -> 3 - 3 -> 5 (1)
        // 2 -> 4 (2)

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(classroom[0][1]);
        for(int i = 1; i < n; i++) {
            if(!pq.isEmpty() && pq.peek() > classroom[i][0]) {
                pq.add(classroom[i][1]);
            } else {
                pq.poll();
                pq.add(classroom[i][1]);
            }


            if(!pq.isEmpty() && pq.size() > max) {
                max = pq.size();
            }
        }

        System.out.println(max);
    }
}
