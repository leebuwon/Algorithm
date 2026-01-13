package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P21318 {
    static int n;
    static int[] music;
    static int q;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        music = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            music[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        q = Integer.parseInt(st.nextToken());
        arr = new int[q][2];
        for(int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] mistake = new int[n];
        int count = 0;
        for(int i = 0; i < n - 1; i++) {
            if(music[i] > music[i + 1]) {
                count++;
            }

            mistake[i + 1] = count;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < q; i++) {
            int leftIdx = arr[i][0] - 1;
            int rightIdx = arr[i][1] - 1;

            int answer = mistake[rightIdx] - mistake[leftIdx];

            sb.append(answer).append("\n");
        }


        System.out.println(sb.toString());
    }
}
