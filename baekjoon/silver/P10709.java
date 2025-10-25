package baekjoon.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P10709 {
    static int H;
    static int W;
    static String[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        arr = new String[H];
        for(int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = st.nextToken();
        }


        // H만큼 순회
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < H; i++) {
            int count = 0;
            // 처음으로 c를 만난다면 false -> true 변경
            boolean flag = false;
            String line = arr[i];
            for(int j = 0; j < W; j++) {
                char c = line.charAt(j);
                // 배열의 라인이 c일 경우 숫자로 출력 그리고 다음 c가 나올 경우까지 ++로 올려주기!



                if(c == 'c') {
                    if(count != 0) {
                        count = 0;
                    }
                    flag = true;
                    sb.append(count).append(" ");
                    count++;
                } else {
                    if(flag) {
                        sb.append(count).append(" ");
                        count++;
                    } else {
                        sb.append("-1").append(" ");
                    }
                }
            }

            // 끝나면 개행처리
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
