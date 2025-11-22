package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1966 {
    static int t;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        t = Integer.parseInt(st.nextToken());

        int count = 0;
        List<Integer> list = new ArrayList<>();
        while (count < t) {
            count++;
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Queue<Integer> queue = new LinkedList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            for(int i = 0; i < n; i++) {
                queue.add(i);
                pq.add(arr[i]);
            }

            int individualCount = 0;

            while (!queue.isEmpty()) {
                int idx = queue.poll();
                int max = pq.peek();

                if(arr[idx] == max) {
                    individualCount++;
                    pq.poll();
                    if(idx == m) {
                        list.add(individualCount);
                    }
                } else {
                    queue.add(idx);
                }
            }

        }

        for (Integer num : list) {
            System.out.println(num);
        }

    }
}
