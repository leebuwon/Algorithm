package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P20366 {
    static int n;
    static int[] arr;
    static List<Integer> min = new ArrayList<>();
    static List<int[]> combinationSnowList = new ArrayList<>(); // 조합 가능한 모든 눈사람의 크기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++){
                int sum = arr[i] + arr[j];
                combinationSnowList.add(new int[]{sum, i, j});
            }
        }

        combinationSnowList.sort(Comparator.comparingInt(a -> a[0]));
        
        // 슬라이딩 윈도우
        int right = 0;
        for(int i = 0; i < combinationSnowList.size() - 1; i++) {
            right++;
            int[] sisterSnow = combinationSnowList.get(i);
            int[] brotherSnow = combinationSnowList.get(right);

            if(sisterSnow[1] == brotherSnow[1] || sisterSnow[1] == brotherSnow[2]) {
                continue;
            }

            if(sisterSnow[2] == brotherSnow[1] || sisterSnow[2] == brotherSnow[2]) {
                continue;
            }

            min.add(Math.abs(sisterSnow[0] - brotherSnow[0]));


        }

        Collections.sort(min);

        System.out.println(min.get(0));
    }
}
