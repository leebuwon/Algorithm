package baekjoon.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P25206 {
    static String[][] subjects;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        subjects = new String[20][3];

        for(int i = 0; i < 20; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < subjects[i].length; j++) {
                subjects[i][j] = st.nextToken();
            }
        }

        Map<String, Double> score = new HashMap<>();
        score.put("A+", 4.5);
        score.put("A0", 4.0);
        score.put("B+", 3.5);
        score.put("B0", 3.0);
        score.put("C+", 2.5);
        score.put("C0", 2.0);
        score.put("D+", 1.5);
        score.put("D0", 1.0);
        score.put("F", 0.0);

        // 전공평점은 전공과목별 (학점 × 과목평점)의 합을 학점의 총합으로 나눈 값
        double sum = 0;
        double totalGradePoint = 0;
        for(int i = 0; i < subjects.length; i++) {
            if(subjects[i][2].equals("P")) {
                continue;
            }

            double gradePoint = Double.parseDouble(subjects[i][1]); // 학점
            double subjectAvg = score.get(subjects[i][2]);
            totalGradePoint += gradePoint;
            sum += gradePoint * subjectAvg;
        }

        sum /= totalGradePoint;

        System.out.printf("%.6f", sum);

    }
}
