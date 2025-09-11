package baekjoon.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P20291 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] str = new String[n];
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            str[i] = br.readLine();

            String[] split = str[i].split("\\.");
            map.put(split[1], map.getOrDefault(split[1], 0) + 1);
        }

        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        for (String s : list) {
            System.out.println(s + " " + map.get(s));
        }
    }
}
