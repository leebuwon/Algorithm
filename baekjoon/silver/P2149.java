package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.Key;
import java.util.*;

public class P2149 {
    static String key;
    static String password;

    static class keyIdx {
        char ch;
        int idx;

        keyIdx(char ch, int idx) {
            this.ch = ch;
            this.idx = idx;
        }

        @Override
        public String toString() {
            return "keyIdx{" +
                    "ch=" + ch +
                    ", idx=" + idx +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        key = st.nextToken();
        st = new StringTokenizer(br.readLine());
        password = st.nextToken();

        keyIdx[] keys = new keyIdx[key.length()];
        for(int i = 0; i < key.length(); i++) {
            keys[i] = new keyIdx(key.charAt(i), i);
        }

        Arrays.sort(keys, Comparator.comparingInt(a -> a.ch));
        
        int blockSize = password.length() / key.length();
        String[] passwords = new String[key.length()];
        int sum = 0;
        for (int i = 0; i < key.length(); i++) {
            passwords[i] = password.substring(sum, sum + blockSize);
            sum += blockSize;
        }

        String[] str = new String[key.length()];
        for(int i = 0; i < key.length(); i++) {
            // 원래 idx에 넣어주기
            str[keys[i].idx] = passwords[i];
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str[0].length(); i++) {
            for(int j = 0; j < str.length; j++) {
                sb.append(str[j].charAt(i));
            }
        }

        System.out.println(sb.toString());
    }
}
