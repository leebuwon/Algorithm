package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1806 {
    static int n;
    static int s;
    static int[] arr;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int right = 0;
        for (int left = 0; left < n; ) {
            if(sum >= s) {
                min = Math.min(min, right - left);
                sum -= arr[left];
                left++;
                continue;
            }

            // 만약에 right가 끝까지 갔을 경우 right는 더이상 증가 X
            if(right == n) {
                sum -= arr[left];
                left++;
                continue;
            }

            sum += arr[right];
            right++;
        }

        System.out.println(min == Integer.MAX_VALUE ? 0 : min);
    }
}
