package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 첫째 줄에 S가 둘째 줄에 T가 주어진다. (1 ≤ S의 길이 ≤ 49, 2 ≤ T의 길이 ≤ 50, S의 길이 < T의 길이)
public class P12919 {
    static int length = 0;
    static String answerString = "";
    static int answer = 0;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String s = st.nextToken();

        st = new StringTokenizer(br.readLine());
        String t = st.nextToken();

        length = t.length();
        answerString = t;

        // s = t가 되도록 해야함
        // 문자열의 뒤에 A를 추가한다.
        // 문자열의 뒤에 B를 추가하고 문자열을 뒤집는다.

        // 재귀 활용!
        recursive(s);

        System.out.println(answer);
    }

    // 시간 초과 풀이 방법 (s -> t로 탐색방법)
    private static void recursive(String s) {
        if(s.charAt(s.length() - 1) == 'B' && count != 0) {
            StringBuilder sb = new StringBuilder(s).reverse();
            s = sb.toString();
        }

        // s와 t의 length가 일치할 경우에만 if문 통과
        if(s.length() == length) {
            // 같다면 1출력 다르다면 0출력
            if(s.equals(answerString)) {
                answer = 1;
                return;
            } else {
                return;
            }
        }

        count++;

        // A를 추가할 경우에는 뒤에 A를 추가만해주면 됨!
        recursive(s + "A");

        // B를 추가할 경우 모든 문자열을 뒤집어야함
        recursive(s + "B");
    }
    // T -> S로 탐색하는 방법 (시간초과 안남)
    private static void recursive(String t) {
        // 이미 정답 찾았으면 더 이상 탐색하지 않음
        if(answer == 1) return;

        // 만약에 끝까지 탐색하면 return
        if(t.isEmpty()) return;


        // t와 s가 같을 경우 정답처리
        if(t.equals(answerString)) {
            answer = 1;
            return;
        }

        if(t.charAt(t.length() - 1) == 'A') {
            // subString 사용하면 됨!
            recursive(t.substring(0, t.length() - 1));
        }

        if(t.charAt(0) == 'B') {
            String next = new StringBuilder(t.substring(1)).reverse().toString();
            recursive(next);
        }
    }
}
