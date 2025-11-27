package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1406 {
    static String str;
    static int n;
    static String[][] command;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        str = st.nextToken();
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        command = new String[n][2];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            command[i][0] = st.nextToken();
            if(command[i][0].equals("P")) {
                command[i][1] = st.nextToken();
            } else {
                command[i][1] = null;
            }
        }

        Stack<String> stack = new Stack<>();
        for(int i = 0; i < str.length(); i++) {
            stack.add(String.valueOf(str.charAt(i)));
        }

        // 우선 커서는 맨뒤에 위치하고 있음!
        Stack<String> tempStack = new Stack<>();
        int cursor = str.length(); // 커서 시작 위치
        for(int i = 0; i < command.length; i++) {
            // 커서 내리기
            if(command[i][0].equals("L")) {
                if(cursor > 0) {
                    cursor--;
                    if(!stack.isEmpty()) {
                        tempStack.add(stack.pop());
                    }
                }
                continue;
            }

            // 커서 올리기
            if(command[i][0].equals("D")) {
                if(cursor < stack.size() + tempStack.size()) {
                    cursor++;
                    if(!tempStack.isEmpty()) {
                        stack.add(tempStack.pop());
                    }
                }
                continue;
            }

            if(command[i][0].equals("P")) {
                stack.add(command[i][1]);
                cursor = stack.size();
                continue;
            }

            if(command[i][0].equals("B")) {
                if(cursor != 0) {
                    stack.pop();
                    cursor = stack.size();
                }
            }
        }


        while (!tempStack.isEmpty()) {
            stack.add(tempStack.pop());
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb.reverse());
    }
}
