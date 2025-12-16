package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P30804 {
    static int n;
    static int[] tanghulu;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        tanghulu = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            tanghulu[i] = Integer.parseInt(st.nextToken());
        }

        int[] fruit = new int[10];

        int left = 0;
        int count = 0;
        int maxLength = 0;

        for(int right = 0; right < n; right++) {
            if(fruit[tanghulu[right]] == 0) {
                count++;
            }

            fruit[tanghulu[right]]++;

            while (count > 2) {
                fruit[tanghulu[left]]--;
                if(fruit[tanghulu[left]] == 0) {
                    count--;
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        System.out.println(maxLength);

    }
}
