package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1411 {
    static int n;
    static String[] str;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        str = new String[n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            str[i] = st.nextToken();
        }

        for(int i = 0; i < n; i++) {
            Map<Character, Integer> standard = new HashMap<>();
            List<Integer> pattern1 = new ArrayList<>();

            String s = str[i];
            int count = 0;

            for(int j = 0; j < s.length(); j++) {
                if(!standard.containsKey(s.charAt(j))) {
                    count++;
                }
                standard.put(s.charAt(j), standard.getOrDefault(s.charAt(j), count));
                pattern1.add(standard.get(s.charAt(j)));
            }

            for(int j = i + 1; j < n; j++) {
                String compareS = str[j];
                int compareCount = 0;
                Map<Character, Integer> compare = new HashMap<>();
                List<Integer> pattern2 = new ArrayList<>();

                for(int k = 0; k < compareS.length(); k++) {
                    if(!compare.containsKey(compareS.charAt(k))) {
                        compareCount++;
                    }

                    compare.put(compareS.charAt(k), compare.getOrDefault(compareS.charAt(k), compareCount));
                    pattern2.add(compare.get(compareS.charAt(k)));
                }

                boolean flag = true;
                for(int l = 0; l < pattern1.size(); l++) {
                    if(!Objects.equals(pattern1.get(l), pattern2.get(l))) {
                        flag = false;
                        break;
                    }
                }

                if(flag) {
                    answer++;
                }

            }
        }

        System.out.println(answer);
    }
}
