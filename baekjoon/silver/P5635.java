package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P5635 {
    static int n;
    static String[][] str;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        str = new String[n][4];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            str[i][0] = st.nextToken();
            str[i][1] = st.nextToken();
            str[i][2] = st.nextToken();
            str[i][3] = st.nextToken();
        }

        Arrays.sort(str, (a, b) -> {
            int aYear = Integer.parseInt(a[3]);
            int bYear = Integer.parseInt(b[3]);

            int aMonth = Integer.parseInt(a[2]);
            int bMonth = Integer.parseInt(b[2]);

            int aDay = Integer.parseInt(a[1]);
            int bDay = Integer.parseInt(b[1]);

            if(aYear == bYear && aMonth == bMonth) {
                return aDay - bDay;
            }

            if(aYear == bYear) {
                return aMonth - bMonth;
            }

            return aYear - bYear;
        });

        System.out.println(str[n - 1][0]);
        System.out.println(str[0][0]);
    }
}
