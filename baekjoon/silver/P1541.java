package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P1541 {
    static String str;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        str = st.nextToken();

        String[] split = str.split("-");
        List<String> strList = new ArrayList<>(Arrays.asList(split));


        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < strList.size(); i++) {
            String s = strList.get(i);
            if(s.contains("+")) {
                String[] plus = s.split("\\+");
                int sum = 0;
                for (String num : plus) {
                    sum += Integer.parseInt(num);
                }
                list.add(sum);
            } else {
                list.add(Integer.parseInt(strList.get(i)));
            }
        }

        Integer answer = list.get(0);
        for(int i = 1; i < list.size(); i++) {
            answer -= list.get(i);
        }

        System.out.println(answer);
    }
}
