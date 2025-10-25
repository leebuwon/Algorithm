package baekjoon.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1713 {
    static int n;
    static int recommend;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        recommend = Integer.parseInt(st.nextToken());

        arr = new int[recommend];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < recommend; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 2 1 4 3 5 6 2 7 2
        // 2(1), 1(1), 4(1)
        // 1(1), 4(1), 3(1)
        // 4(1), 3(1), 5(1)
        // 3(1), 5(1), 6(1)
        // 5(1), 6(1), 2(1) -> 여기서 2번은 한번 삭제됐기 때문에 숫자를 초기화 !
        // 6(1), 2(1), 7(1)
        // 6(1), 2(2), 7(1) -> 최후로 남은 사람들 !

        Map<Integer, Integer> map = new HashMap<>(); // 학생마다 추천 수 평가
        List<Integer> frame = new ArrayList<>(); // 사진 틀안에 있는 학생 추적
        for(int i = 0; i < recommend; i++) {

            // 만약 이미 학생이 frame에 있을 경우 투표 수 더해주기!
            if(map.containsKey(arr[i])) {
                // value 올려주기 !
                map.put(arr[i], map.get(arr[i]) + 1);
                continue;
            }


            int minRecommend = Integer.MAX_VALUE; // 가장 추천을 적게 받은 학생 찾기
            int targetStudent = 0;

            // 만약에 사진이 가득차 있지 않을 경우 map과 frame에 넣어주기
            if(frame.size() < n) {
                frame.add(arr[i]);
                map.put(arr[i], 1);
            } else {
                // Frame에 있는 학생 찾기
                for (Integer target : frame) {
                    Integer studentRecommendCount = map.get(target);
                    if(studentRecommendCount < minRecommend) {
                        minRecommend = studentRecommendCount; // 추천을 가장 적게 받은 학생으로 초기화
                        targetStudent = target; // 타겟 학생 초기화
                    }
                }

                // 타겟학생 제거해주기 !
//                for(int j = 0; j < n; i++) {
//                    if(frame.get(j) == targetStudent) {
//                        frame.remove(j);
//                        break;
//                    }
//                }
                frame.remove((Integer) targetStudent);
//                frame.remove(targetStudent);
                map.remove(targetStudent);

                // 학생 넣어주기 !
                frame.add(arr[i]);
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            }


        }

        Collections.sort(frame);
        for (Integer finalStudent : frame) {
            System.out.print(finalStudent + " ");
        }

    }
}
