package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2343 {
    static int n;
    static int m;
    static int[] lesson;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        lesson = new int[n];
        st = new StringTokenizer(br.readLine());
        int max = Integer.MIN_VALUE;
        int total = 0;
        for(int i = 0; i < n; i++) {
            lesson[i] = Integer.parseInt(st.nextToken());
            if(max < lesson[i]) {
                max = lesson[i];
            }

            total += lesson[i];
        }

        int answer = 0;
        int left = max;
        int right = total;
        while (left <= right) {
            int middle = (left + right) / 2;
            int count = 1;
            int sum = 0;

            for(int i = 0; i < n; i++) {
                sum += lesson[i];

                if(sum > middle) {
                    sum = lesson[i];
                    count++;
                }
            }

            if(count > m) {
                left = middle + 1;
            } else {
                right = middle - 1;
                answer = middle;
            }
        }

        System.out.println(answer);


    }
}
