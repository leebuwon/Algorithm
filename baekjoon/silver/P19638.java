package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

import java.util.StringTokenizer;

public class P19638 {
    static int n;
    static int h;
    static int t;
    static int[] giant;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        giant = new int[n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            giant[i] = Integer.parseInt(st.nextToken());
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < n; i++) {
            queue.add(giant[i]);
        }

        int count = 0;
        boolean flag = true;
        while (!queue.isEmpty() && t != count) {
            if(queue.peek() < h) {
                System.out.println("YES");
                System.out.println(count);
                flag = false;
                break;
            }

            Integer mostTallGiant = queue.poll();

            if(mostTallGiant == 1) {
                mostTallGiant = 1;
            } else {
                mostTallGiant /= 2;
            }
            count++;
            queue.add(mostTallGiant);

            if(!queue.isEmpty() && queue.peek() < h) {
                System.out.println("YES");
                System.out.println(count);
                flag = false;
                break;
            }
        }


        if(flag) {
            System.out.println("NO");
            System.out.println(queue.peek());
        }
    }
}
