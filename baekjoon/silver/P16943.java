package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P16943 {
    static int a;
    static int b;
    static String[] str;
    static boolean[] visited;
    static int depth;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        sb.append(a);

        str = new String[sb.length()];
        depth = str.length;
        for(int i = 0; i < sb.length(); i++) {
            str[i] = String.valueOf(sb.charAt(i));
        }

        for(int i = 0; i < str.length; i++) {
            visited = new boolean[sb.length()];
            visited[i] = true;
            StringBuilder num = new StringBuilder();
            recursive(num.append(str[i]));
        }

        if(max == Integer.MIN_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(max);
        }
    }

    private static void recursive(StringBuilder num) {
        StringBuilder length = new StringBuilder();
        length.append(Integer.parseInt(num.toString())); // 0001 -> 1
        if(length.length() == depth && Integer.parseInt(num.toString()) < b) {
            if(max < Integer.parseInt(num.toString())) {
                max = Integer.parseInt(num.toString());
                return;
            }
        }

        for(int i = 0; i < depth; i++) {
            if(visited[i]) {
                continue;
            }
            visited[i] = true;
            recursive(num.append(str[i]));
            num.setLength(num.length() - 1);
            visited[i] = false;
        }
    }
}
