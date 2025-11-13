package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P9375 {
    static int n;
    static int m;
    static String[] clothes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> answer = new ArrayList<>();

        n = Integer.parseInt(st.nextToken());

        // hat headgear
        // sunglasses eyewear
        // turban wear
        // hat / sunglasses / turban / hat, sunglasses / hat, turban / sunglasses, turban / sunglasses, turban, hat
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            clothes = new String[m];

            for (int j = 0; j < m; j++) {
                clothes[j] = br.readLine();
            }

            Map<String, Integer> map = new HashMap<>();

            int count = 1;
            for (int k = 0; k < m; k++) {
                String[] currentClothes = clothes[k].split(" ");

                map.put(currentClothes[1], map.getOrDefault(currentClothes[1], 0) + 1);
            }

            for (Integer clothesNumber : map.values()) {
                count *= (clothesNumber + 1);
            }
            answer.add(count - 1);
        }

        StringBuilder sb = new StringBuilder();
        for (Integer num : answer) {
            sb.append(num).append(" ");
        }

        System.out.println(sb);
    }
}
