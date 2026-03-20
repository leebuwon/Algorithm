package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2457 {
    static int n;
    static int[][] flowers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        flowers = new int[n][2];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a1 = Integer.parseInt(st.nextToken());
            int a2 = Integer.parseInt(st.nextToken());
            int b1 = Integer.parseInt(st.nextToken());
            int b2 = Integer.parseInt(st.nextToken());

            flowers[i][0] = a1 * 100 + a2;
            flowers[i][1] = b1 * 100 + b2;
        }

        Arrays.sort(flowers, (a, b) -> {
            if(a[0] != b[0]) {
                return a[0] - b[0];
            }

            return  a[1] - b[1];
        });

        // [215, 323],
        // [228, 425],
        // [412, 605],
        // [502, 531],
        // [603, 615],
        // [615, 903],
        // [615, 927],
        // [714, 901],
        // [914, 1224],
        // [1005, 1231]

        int startTarget = 301;
        int endTarget = 1201;
        int answer = 0;
        int max = Integer.MIN_VALUE;
        while (startTarget < endTarget) {
            for(int i = 0; i < n; i++) {
                int start = flowers[i][0];
                int end = flowers[i][1];

                if(start <= startTarget) {
                   if(max <= end) {
                       max = end;
                   }
                }
            }

            if(startTarget < max) {
                answer++;
            } else {
                answer = 0;
                break;
            }
            startTarget = max;
        }
        System.out.println(answer);
    }
}
