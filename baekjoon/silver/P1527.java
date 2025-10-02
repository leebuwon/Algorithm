import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());


        solution(A, B);
    }

    private static void solution(long A, long B) {

        // 4 / 7 이면 됨!
        for(long i = A; i <= B; i++) {
            recursive(i);
        }

        System.out.println(count);
    }

    // 재귀 호출을 통해서 1의 자릿수부터 계속해서 올라감
    private static void recursive(long num) {
        // num == 0 이라면 모든 num을 자릿수를 검사한거기 때문에 count++ 해줘도됨!
        if(num == 0) {
            count++;
            return;
        }

        // digit의 마지막 자릿수를 검사하기 위해 추출
        long digit = num % 10; // 1의 자리 추출

        // 만약에 digit의 마지막 자릿수가 4 or 7 이 아니라면 return
        if(digit != 4 && digit != 7) {
            return;
        }

        // 마지막 자릿수를 계속 없애주는 역할
        recursive(num / 10);
    }
}
