package baekjoon.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String s = st.nextToken();

        int zeroCount = 0;
        int oneCount = 0;

        // 시작 단어
        if(s.charAt(0) == '0'){
            zeroCount++;
        } else {
            oneCount++;
        }

        for(int i = 0; i < s.length() - 1; i++) {
            char c = s.charAt(i);

            // 첫번째로 들어온 단어

            if(c == s.charAt(i + 1)) {
                continue;
            }

            if(c != s.charAt(i + 1)) {
                if(s.charAt(i + 1) == '1') {
                    oneCount++;
                }

                if(s.charAt(i + 1) == '0') {
                    zeroCount++;
                }
            }

        }

        System.out.println(Math.min(zeroCount, oneCount));
    }
}
