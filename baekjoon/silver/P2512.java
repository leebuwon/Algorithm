package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2512 {
    static int n;
    static int[] budget;
    static int m;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        budget = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            budget[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());

        Arrays.sort(budget);

        int left = 0;
        int right = budget[n - 1];
        while (left <= right) {
            int middle = (left + right) / 2;
            int tempBudget = m;


            for(int i = 0; i < n; i++) {
                if(middle > budget[i]) {
                    tempBudget -= budget[i];
                } else {
                    tempBudget -= middle;
                }
            }


            if(tempBudget < 0) {
                right = middle - 1;
            } else {
                left = middle + 1;
                if(max < middle) {
                    max = middle;
                }
            }
        }

        System.out.println(max);

    }
}
