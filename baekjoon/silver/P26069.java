package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P26069 {
    static int n;
    static String[][] str;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        str = new String[n][2];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            str[i][0] = st.nextToken();
            str[i][1] = st.nextToken();
        }

        Set<String> sets = new HashSet<>();
        sets.add("ChongChong");
        for(int i = 0; i < n; i++) {
            if(sets.contains(str[i][0])) {
                sets.add(str[i][1]);
                continue;
            }

            if(sets.contains(str[i][1])) {
                sets.add(str[i][0]);
            }
        }

        System.out.println(sets.size());
    }
}
