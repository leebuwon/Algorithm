package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1515 {
    static String n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = st.nextToken();

        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < n.length(); i++) {
            queue.offer(n.charAt(i));
        }

        int num = 1;

        while (!queue.isEmpty()) {
            String current = String.valueOf(num);

            for (int i = 0; i < current.length(); i++) {
                if (!queue.isEmpty() && current.charAt(i) == queue.peek()) {
                    queue.poll();
                }
            }

            if (queue.isEmpty()) {
                System.out.println(num);
                break;
            }

            num++;
        }
    }
}
