package baekjoon.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (a, b) -> {
            // y 좌표가 같다면 x 좌표로 비교 (오름차순)
            if(a[1] == b[1]) {
                return a[0] - b[0];
            }

            // y 좌표와 x 좌표가 다르다면 오름차숨 정렬
            return a[1] - b[1];
        });

        StringBuilder sb = new StringBuilder();
        for (int[] ints : arr) {
            sb.append(ints[0]).append(" ").append(ints[1]).append("\n");
        }

        System.out.println(sb);
    }
}
