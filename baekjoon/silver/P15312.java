package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P15312 {
    static String name;
    static String her;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        name = st.nextToken();
        st = new StringTokenizer(br.readLine());
        her = st.nextToken();

        int[] arr = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < name.length(); i++) {
            list.add(arr[name.charAt(i) - 'A']);
            list.add(arr[her.charAt(i) - 'A']);
        }

        List<Integer> answer;
        answer = list;
        while (answer.size() > 2) {
            answer = new ArrayList<>();
            for(int i = 0; i < list.size() - 1; i++) {
                int num = (list.get(i) + list.get(i + 1)) % 10;
                answer.add(num);
            }

            list = answer;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 2; i++) {
            sb.append(answer.get(i));
        }

        System.out.println(sb.toString());

    }
}
