package baekjoon.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        String[] arr = new String[n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = st.nextToken();
        }

        // 우선 map에다 넣어줘서 중복 제거, length 같이 넣어줘서 문자열 길이 판별
        Map<String, Integer> maps = new HashMap<>();
        for(int i=0; i<n; i++) {
            maps.put(arr[i], arr[i].length());
        }

        // map을 정렬하기 위해서 list로 선언
        List<Map.Entry<String, Integer>> list = new ArrayList<>(maps.entrySet());
        list.sort((o1, o2) -> {
            // 만약에 길이가 같을 경우 key로 비교하여서 값 추출
            if(o1.getValue() - o2.getValue() == 0) {
                return o1.getKey().compareTo(o2.getKey());
            }
            // 길이가 다를 경우에는 value로 비교하여 올림차순
            return o1.getValue() - o2.getValue();
        });


        for (Map.Entry<String, Integer> stringIntegerEntry : list) {
            System.out.println(stringIntegerEntry.getKey());
        }
    }
}
