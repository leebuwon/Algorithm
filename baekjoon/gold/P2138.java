package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// GPT 참고
public class P2138 {
    static int n;
    static String[] bulb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        bulb = new String[2];

        for(int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            bulb[i] = st.nextToken();
        }

        int zeroStart = 0;
        int nonZeroStart = 0;
        if(!bulb[0].equals(bulb[1])) {
            zeroStart = simulate(true);
            nonZeroStart = simulate(false);
        }

        int answer = Math.min(zeroStart, nonZeroStart);

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    private static int simulate(boolean flag) {
        int count = 0;
        char[] toChar = bulb[0].toCharArray();
        char[] target = bulb[1].toCharArray();
        
        for(int i = 1; i < n; i++) {
            if(flag) {
                toggle(toChar, 0);
                if(n > 1) toggle(toChar, 1);
                count++;
                flag = false;
            }

            if(toChar[i - 1] != target[i - 1]) {
                toggle(toChar, i - 1);
                toggle(toChar, i);
                if(i + 1 < n) {
                    toggle(toChar, i + 1);
                }
                count++;
            }
        }

        return new String(toChar).equals(bulb[1]) ? count : Integer.MAX_VALUE;
    }

    private static void toggle(char[] toChar, int idx) {
        if(toChar[idx] == '0') {
            toChar[idx] = '1';
        } else {
            toChar[idx] = '0';
        }
    }
}
