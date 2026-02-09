package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P23305 {
    static int n;
    static int[] arr1;
    static int[] arr2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        arr1 = new int[n];
        arr2 = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> compare = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
            map.put(arr1[i], map.getOrDefault(arr1[i], 0) + 1);
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
            compare.put(arr2[i], compare.getOrDefault(arr2[i], 0) + 1);
        }

        int count = 0;
        for (Integer num : map.keySet()) {
            int value = map.get(num);
            int minus = compare.getOrDefault(num, 0);

            int sum = Math.max(0, value - minus);
            count += sum;
        }

        System.out.println(count);
    }
}
