package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1032 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        String[] arr = new String[n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = st.nextToken();
        }

        int count = 0;
        Boolean[] flag = new Boolean[arr[0].length()];
        Arrays.fill(flag, true);
        while (count <= arr[0].length() - 1) {

            for(int i = 0; i < n - 1; i++) {
                char now = arr[i].charAt(count);
                char next = arr[i + 1].charAt(count);

                if(now != next) {
                    flag[count] = false;
                    break;
                }
            }

            count++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr[0].length(); i++) {
            char c = arr[0].charAt(i);
            if(flag[i]) {
                sb.append(c);
            } else {
                sb.append("?");
            }
        }

        System.out.println(sb.toString());
    }
}
