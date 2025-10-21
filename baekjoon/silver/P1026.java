package baekjoon.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1026 {
    static int n;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 5
        // 1 1 1 6 0
        // 2 7 8 3 1
        // 2 + 7 + 0 + 3 + 6 = 18

        n = Integer.parseInt(st.nextToken());
        arr = new int[2][n];

        for(int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

//        Arrays.sort(arr);
        Integer[] multipleArr = new Integer[n];
        Integer[] num = new Integer[n];
        for(int i = 0; i < n; i++) {
            multipleArr[i] = arr[0][i];
        }

        for(int i = 0; i < n; i++) {
            num[i] = arr[1][i];
        }

        Arrays.sort(multipleArr);
        Arrays.sort(num, (a, b) -> b - a);

        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += multipleArr[i] * num[i];
        }


        System.out.println(sum);

    }
}
