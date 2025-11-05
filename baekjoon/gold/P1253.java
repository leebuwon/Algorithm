package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1253 {
    static int n;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int like = 0;
        for(int i = 0; i < n; i++) {
            // 나 자신의 index는 받으면 안됨..
            int currentNum = arr[i];

            int left = 0;
            int right = n - 1;

            // 1 2 3 4 5 6 7 8 9 10
            while (left < right) {
                if(left == i) {
                    left++;
                    continue;
                }

                if(right == i) {
                    right--;
                    continue;
                }

                if(arr[left] + arr[right] == currentNum) {
                    like++;
                    break;
                }

                if(arr[left] + arr[right] > currentNum) {
                    right--;
                } else {
                    left++;
                }

            }
        }
        System.out.println(like);
    }
}
