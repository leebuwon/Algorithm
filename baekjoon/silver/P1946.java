package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class P1946 {
    static int t;
    static int n;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        t = Integer.parseInt(st.nextToken());

        int count = 0;
        while (count < t) {
            count++;
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            arr = new int[n][2];
            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 2; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
            int passFreshMan = 0;

            // [1, 4], -> 합격
            // [2, 5], -> 불합
            // [3, 6], -> 불합
            // [4, 2], -> 합격
            // [5, 7], -> 불합
            // [6, 1], -> 합격
            // [7, 3]  -> 불합
            int interviewScore = Integer.MAX_VALUE;
            for(int i = 0; i < n; i++) {
                int[] currentPeople = arr[i];
                int interview = currentPeople[1];

                if(interview < interviewScore) {
                    interviewScore = interview;
                } else {
                    continue;
                }

                passFreshMan++;
            }

            System.out.println(passFreshMan);
        }
    }
}
