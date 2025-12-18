package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P17609 {
    static int n;
    static String[] str;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        str = new String[n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            str[i] = st.nextToken();
        }

        for(int i = 0; i < str.length; i++) {

            int left = 0;
            int right = str[i].length() - 1;
            int count = 0;

            while (left < right) {
                char leftC = str[i].charAt(left);
                char rightC = str[i].charAt(right);

                if(leftC == rightC) {
                    left++;
                    right--;
                    continue;
                }

                count++;
                int plus1 = find(left + 1, right, str[i]);
                int plus2 = find(left, right - 1, str[i]);

                int min = Math.min(plus1, plus2);
                count += min;
                break;

            }

            System.out.println(count);
        }
    }

    private static int find(int left, int right, String str) {
        while (left < right) {
            if(str.charAt(left) == str.charAt(right)) {
                left++;
                right--;
            } else {
                return 1;
            }
        }

        return 0;
    }
}
