package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P4307 {
    static int t;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        t = Integer.parseInt(st.nextToken());

        int count = 0;
        while (count < t) {
            count++;

            st = new StringTokenizer(br.readLine());
            int length = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            int max = Integer.MIN_VALUE;
            int longMax = Integer.MIN_VALUE;

            int[] arr = new int[n];
            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                arr[i] = Integer.parseInt(st.nextToken());
            }

            // 2 6 7
            // 2번 개미는 왼쪽으로 6 7 번개미는 오른쪽으로
            StringBuilder sb = new StringBuilder();
            int middle = length / 2;
            for(int i = 0; i < n; i++) {
                int now = arr[i];

                // 길이를 가장 짧게 갔을 경우
                if(now < middle) {
                    if(now > max) {
                        max = now;
                    }
                } else {
                    int num = length - arr[i];

                    if(num > max) {
                        max = num;
                    }
                }

            }

            sb.append(max).append(" ");

            for(int i = 0; i < n; i++) {
                int now = arr[i];

                // 길이를 가장 길게 잡았을 경우
                if(now < middle) {
                    if(length - arr[i] > longMax) {
                        longMax = length - arr[i];
                    }
                } else {
                    if(now > longMax) {
                        longMax = now;
                    }
                }
            }

            sb.append(longMax);

            System.out.println(sb.toString());
        }


    }
}
