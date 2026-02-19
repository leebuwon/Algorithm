package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P16722 {
    static String[][] diagram;
    static int n;
    static String[][] input;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        diagram = new String[9][3];
        for(int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            diagram[i][0] = st.nextToken();
            diagram[i][1] = st.nextToken();
            diagram[i][2] = st.nextToken();
        }

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        input = new String[n][4];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            input[i][0] = st.nextToken();
            input[i][1] = st.hasMoreTokens() ? st.nextToken() : null;
            input[i][2] = st.hasMoreTokens() ? st.nextToken() : null;
            input[i][3] = st.hasMoreTokens() ? st.nextToken() : null;
        }

        int total = 0;

        for(int i = 0; i < 7; i++) {
            String leftDiagram = diagram[i][0];
            String leftColor = diagram[i][1];
            String leftBackground = diagram[i][2];
            for(int j = i + 1; j < 8; j++) {
                for(int k = j + 1; k < 9; k++) {
                    boolean[] totalHAB = new boolean[3];
                    String middleDiagram = diagram[j][0];
                    String middleColor = diagram[j][1];
                    String middleBackground = diagram[j][2];

                    String rightDiagram = diagram[k][0];
                    String rightColor = diagram[k][1];
                    String rightBackground = diagram[k][2];

                    // 도형
                    if(leftDiagram.equals(middleDiagram) && leftDiagram.equals(rightDiagram)) {
                        totalHAB[0] = true;
                    } else {
                        if(!leftDiagram.equals(middleDiagram) && !leftDiagram.equals(rightDiagram) && !middleDiagram.equals(rightDiagram)) {
                            totalHAB[0] = true;
                        }
                    }

                    // 색
                    if(leftColor.equals(middleColor) && leftColor.equals(rightColor)) {
                        totalHAB[1] = true;
                    } else {
                        if(!leftColor.equals(middleColor) && !leftColor.equals(rightColor) && !middleColor.equals(rightColor)) {
                            totalHAB[1] = true;
                        }
                    }

                    if(leftBackground.equals(middleBackground) && leftBackground.equals(rightBackground)) {
                        totalHAB[2] = true;
                    } else {
                        if(!leftBackground.equals(middleBackground) && !leftBackground.equals(rightBackground) && !middleBackground.equals(rightBackground)) {
                            totalHAB[2] = true;
                        }
                    }

                    if(totalHAB[0] && totalHAB[1] && totalHAB[2]) {
                        total++;
                    }
                }
            }
        }

        int score = 0;
        Set<List<Integer>> set = new HashSet<>();
        boolean flag = true;
        for(int i = 0; i < n; i++) {
            boolean[] HAB = new boolean[3];
            List<Integer> existValueCheck = new ArrayList<>();

            if(input[i][0].equals("H")) {
                int leftSelect = Integer.parseInt(input[i][1]) - 1;
                int middleSelect = Integer.parseInt(input[i][2]) - 1;
                int rightSelect = Integer.parseInt(input[i][3]) - 1;

                String leftDiagram = diagram[leftSelect][0];
                String leftColor = diagram[leftSelect][1];
                String leftBackground = diagram[leftSelect][2];

                String middleDiagram = diagram[middleSelect][0];
                String middleColor = diagram[middleSelect][1];
                String middleBackground = diagram[middleSelect][2];

                String rightDiagram = diagram[rightSelect][0];
                String rightColor = diagram[rightSelect][1];
                String rightBackground = diagram[rightSelect][2];


                // 전부가 모두 같거나 모두 다를 경우만 OK

                // 도형
                if(leftDiagram.equals(middleDiagram) && leftDiagram.equals(rightDiagram)) {
                    HAB[0] = true;
                    existValueCheck.add(leftSelect);
                } else {
                    if(!leftDiagram.equals(middleDiagram) && !leftDiagram.equals(rightDiagram) && !middleDiagram.equals(rightDiagram)) {
                        HAB[0] = true;
                        existValueCheck.add(leftSelect);
                    }
                }

                // 색
                if(leftColor.equals(middleColor) && leftColor.equals(rightColor)) {
                    HAB[1] = true;
                    existValueCheck.add(middleSelect);
                } else {
                    if(!leftColor.equals(middleColor) && !leftColor.equals(rightColor) && !middleColor.equals(rightColor)) {
                        HAB[1] = true;
                        existValueCheck.add(middleSelect);
                    }
                }

                if(leftBackground.equals(middleBackground) && leftBackground.equals(rightBackground)) {
                    HAB[2] = true;
                    existValueCheck.add(rightSelect);
                } else {
                    if(!leftBackground.equals(middleBackground) && !leftBackground.equals(rightBackground) && !middleBackground.equals(rightBackground)) {
                        HAB[2] = true;
                        existValueCheck.add(rightSelect);
                    }
                }

                Collections.sort(existValueCheck);

                if(HAB[0] && HAB[1] && HAB[2]) {
                    if(set.contains(existValueCheck)) {
                        score--;
                        continue;
                    }

                    score++;
                    set.add(existValueCheck);
                } else {
                    score--;
                }

                continue;
            }

            if(total == set.size() && flag) {
                score += 3;
                flag = false;
            } else {
                score--;
            }
        }

        System.out.println(score);
    }
}
