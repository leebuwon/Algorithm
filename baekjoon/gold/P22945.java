package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P22945 {
    static int n;
    static int[] people;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        people = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = n - 1;
        int min = 0;
        int result = 0;
        while (left < right) {
            int diff = right - left - 1;

            min = Math.min(people[left], people[right]);
            result = diff * min;

            max = Math.max(max, result);

            if(people[left] < people[right]) {
                left++;
            } else {
                right--;
            }
        }


        System.out.println(max);
    }
}
