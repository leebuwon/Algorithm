package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
// GPT 참고
public class P19640 {
    static int n;
    static int m;
    static int k;
    static int[][] toilet;
    static PriorityQueue<Person> pq = new PriorityQueue<>(
            (o1, o2) -> {
                if (o1.d != o2.d) return o2.d - o1.d;
                if (o1.h != o2.h) return o2.h - o1.h;
                return o1.line - o2.line;
            }
    );

    static class Person{
        int d;
        int h;
        int line;
        int idx;
        boolean flag;

        public Person(int d, int h, int line, int idx, boolean flag) {
            this.d = d;
            this.h = h;
            this.line = line;
            this.idx = idx;
            this.flag = flag;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        toilet = new int[n][2];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            toilet[i][0] = Integer.parseInt(st.nextToken());
            toilet[i][1] = Integer.parseInt(st.nextToken());
        }

        Queue<Person>[] lines = new LinkedList[m];
        for (int i = 0; i < m; i++) {
            lines[i] = new LinkedList<>();
        }

        boolean flag;
        for (int i = 0; i < n; i++) {
            int line = i % m;
            if(i == k) {
                flag = true;
            } else {
                flag = false;
            }
            lines[line].offer(new Person(toilet[i][0], toilet[i][1], line, i, flag));
        }

        for (int line = 0; line < m; line++) {
            if (!lines[line].isEmpty()) pq.add(lines[line].poll());
        }

        int count = 0;
        while (!pq.isEmpty()) {
            Person cur = pq.poll();

            if (!lines[cur.line].isEmpty()) {
                pq.add(lines[cur.line].poll());
            }

            if(cur.flag) {
                System.out.println(count);
                break;
            }

            count++;
        }

    }
}
