package baekjoon.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        String[][] str = new String[n][2];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            str[i][0] = st.nextToken();
            str[i][1] = st.nextToken();
        }

        List<String[]> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list.add(str[i]);
        }

        // String으로 비교할 경우 비교가 잘 안됨
        // 이유는 String은 아스키코드로 비교하기 때문에 1 = 49 / 2 = 50 이므로
        // 2 > 10 (이유는 2는 처음이 50으로 시작하고 1은 49로 시작하기 때문임)
        // 그래서 정렬 순서가 이상해질 수 밖에 없음
//        list.sort(Comparator.comparing(o -> o[0]));

        // 람다식 정순 정렬
        list.sort(Comparator.comparingInt(o -> Integer.parseInt(o[0])));

        // 정순 정렬
//        list.sort((o2, o1) -> Integer.parseInt(o2[0]) - Integer.parseInt(o1[0]));
        // 역순 정렬
//        list.sort((o1, o2) -> Integer.parseInt(o2[0]) - Integer.parseInt(o1[0]));

        for (String[] strings : list) {
            System.out.println(strings[0] + " " + strings[1]);
        }
    }
}
