package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P9012 {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            Stack<String> stack = new Stack<>();
            for(int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);

                if(stack.isEmpty()) {
                    // 만약에 하나도 없는데 )부터 들어오면 break
                    if(String.valueOf(c).equals(")")) {
                        stack.add(String.valueOf(c));
                        break;
                    }
                    stack.add(String.valueOf(c));
                    continue;
                }

                // 만약 stack의 맨 위에 저장된 걸 확인했을 경우 c가 ")" 라면 pop
                if(stack.peek().equals("(")) {
                    if(String.valueOf(c).equals(")")) {
                        stack.pop();
                        continue;
                    }

                    stack.add(String.valueOf(c));
                }
            }

            if(stack.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }
}
