package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1461 {
    static int n;
    static int m;
    static int[] books;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        books = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            books[i] = Integer.parseInt(st.nextToken());

            if(max < Math.abs(books[i])) {
                max = Math.abs(books[i]);
            }
        }

        int dist = 0;
        boolean flag = true;
        PriorityQueue<Integer> minus = new PriorityQueue<>();
        PriorityQueue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < n; i++) {
            if(books[i] > 0) {
                plus.add(books[i]);
            } else {
                minus.add(books[i]);
            }
        }


        while (!minus.isEmpty()) {
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < m; i++) {
                if(minus.isEmpty()) {
                    continue;
                }

                Integer book = minus.poll();
                if(min > book) {
                    min = book;
                }
            }

            if(Math.abs(min) == max && flag) {
                dist += Math.abs(min);
                flag = false;
            } else {
                dist += Math.abs(min * 2);
            }
        }

        while (!plus.isEmpty()) {
            int plusMax = Integer.MIN_VALUE;
            for(int i = 0; i < m; i++) {
                if(plus.isEmpty()) {
                    continue;
                }

                Integer book = plus.poll();
                if(plusMax < book) {
                    plusMax = book;
                }
            }

            if(plusMax == max && flag) {
                dist += plusMax;
                flag = false;
            } else {
                dist += plusMax * 2;
            }
        }


        System.out.println(dist);
    }
}
