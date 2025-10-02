package baekjoon.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2961 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][2];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        solution(n, arr);
    }

    //    4
    //    1 7
    //    2 6
    //    3 8
    //    4 9

    // 신맛은 곱
    // 쓴맛은 합
    // 적절히 섞어서 요리의 신맛과 쓴맛의 차이를 작게 만드는게 목표
    private static void solution(int n, int[][] arr) {

        // 모든 값을 넣어줄 배열 선언 (n의 배열에서 만들어줄 수 있는 경우의 수는 제곱이라고 판단)
        int[] zValue = new int[n * n];

        // 모든 경우의 수를 넣어서 값에 넣어줘야함
        // 1 1 1 1
        // 1 - 2 / 1 - 3 / 1 - 4 | 2 - 3 / 2 - 4 | 3 - 4
        // 1 - 2 - 3 / 1 - 2 - 4 / 1 - 3 - 4 | 2 - 3 - 4
        // 1 - 2 - 3 - 4

        List<Integer> arrList = new ArrayList<>();

        // 1 1 1 1
        if(n >= 1) {
            for(int i = 0; i < n; i++) {
                arrList.add(Math.abs(arr[i][0] - arr[i][1]));
            }
        }

        // 1 - 2 / 1 - 3 / 1 - 4 | 2 - 3 / 2 - 4 | 3 - 4
        // 1 * 2 - 7 + 6 = 11
        // 1 * 3 - 7 + 8 = 12
        // 1 * 4 - 7 + 9 = 12
        // 2 * 3 - 6 + 8 = 8
        if(n >= 2) {
            for(int i = 0; i < n - 1; i++) {
                for(int j = i + 1; j < n; j++) {
                    arrList.add(Math.abs((arr[i][0] * arr[j][0]) - (arr[i][1] + arr[j][1])));
                }
            }
        }

        // 1 - 2 - 3 / 1 - 2 - 4 / 1 - 3 - 4 | 2 - 3 - 4
        if(n >= 3) {
            for(int i = 0; i < n - 2; i++) {
                for(int j = i + 1; j < n - 1; j++) {
                    for(int k = j + 1; k < n; k++) {
                        arrList.add(Math.abs((arr[i][0] * arr[j][0] * arr[k][0]) - (arr[i][1] + arr[j][1] + arr[k][1])));
                    }
                }
            }
        }

        if(n >= 4) {
            for(int i = 0; i < n - 3; i++) {
                for(int j = i + 1; j < n - 2; j++) {
                    for(int k = j + 1; k < n - 1; k++) {
                        for(int l = k + 1; l < n; l++) {
                            arrList.add(Math.abs((arr[i][0] * arr[j][0] * arr[k][0] * arr[l][0]) - (arr[i][1] + arr[j][1] + arr[k][1] + arr[l][1])));
                        }
                    }
                }
            }
        }

        if(n >= 5) {
            for(int i = 0; i < n - 4; i++) {
                for(int j = i + 1; j < n - 3; j++) {
                    for(int k = j + 1; k < n - 2; k++) {
                        for(int l = k + 1; l < n - 1; l++) {
                            for(int m = l + 1; m < n; m++) {
                                arrList.add(Math.abs((arr[i][0] * arr[j][0] * arr[k][0] * arr[l][0] * arr[m][0]) - (arr[i][1] + arr[j][1] + arr[k][1] + arr[l][1] + arr[m][1])));
                            }
                        }
                    }
                }
            }
        }

        if(n >= 6) {
            for(int i = 0; i < n - 5; i++) {
                for(int j = i + 1; j < n - 4; j++) {
                    for(int k = j + 1; k < n - 3; k++) {
                        for(int l = k + 1; l < n - 2; l++) {
                            for(int m = l + 1; m < n - 1; m++) {
                                for (int p = m + 1; p < n; p++) {
                                    arrList.add(Math.abs((arr[i][0] * arr[j][0] * arr[k][0] * arr[l][0] * arr[m][0] * arr[p][0])
                                            - (arr[i][1] + arr[j][1] + arr[k][1] + arr[l][1] + arr[m][1] + arr[p][1])));
                                }
                            }
                        }
                    }
                }
            }
        }

        if(n >= 7) {
            for(int i = 0; i < n - 6; i++) {
                for(int j = i + 1; j < n - 5; j++) {
                    for(int k = j + 1; k < n - 4; k++) {
                        for(int l = k + 1; l < n - 3; l++) {
                            for(int m = l + 1; m < n - 2; m++) {
                                for (int p = m + 1; p < n - 1; p++) {
                                    for(int q = p + 1; q < n; q++) {
                                        arrList.add(Math.abs((arr[i][0] * arr[j][0] * arr[k][0] * arr[l][0] * arr[m][0] * arr[p][0] * arr[q][0])
                                                - (arr[i][1] + arr[j][1] + arr[k][1] + arr[l][1] + arr[m][1] + arr[p][1] + arr[q][1])));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        if(n >= 8) {
            for(int i = 0; i < n - 7; i++) {
                for(int j = i + 1; j < n - 6; j++) {
                    for(int k = j + 1; k < n - 5; k++) {
                        for(int l = k + 1; l < n - 4; l++) {
                            for(int m = l + 1; m < n - 3; m++) {
                                for (int p = m + 1; p < n - 2; p++) {
                                    for(int q = p + 1; q < n - 1; q++) {
                                        for(int r = q + 1; r < n; r++) {
                                            arrList.add(Math.abs((arr[i][0] * arr[j][0] * arr[k][0] * arr[l][0] * arr[m][0] * arr[p][0] * arr[q][0] * arr[r][0])
                                                    - (arr[i][1] + arr[j][1] + arr[k][1] + arr[l][1] + arr[m][1] + arr[p][1] + arr[q][1] + arr[r][1])));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        if(n >= 9) {
            for(int i = 0; i < n - 8; i++) {
                for(int j = i + 1; j < n - 7; j++) {
                    for(int k = j + 1; k < n - 6; k++) {
                        for(int l = k + 1; l < n - 5; l++) {
                            for(int m = l + 1; m < n - 4; m++) {
                                for (int p = m + 1; p < n - 3; p++) {
                                    for(int q = p + 1; q < n - 2; q++) {
                                        for(int r = q + 1; r < n - 1; r++) {
                                            for(int s = r + 1; s < n; s++) {
                                                arrList.add(Math.abs((arr[i][0] * arr[j][0] * arr[k][0] * arr[l][0] * arr[m][0] * arr[p][0] * arr[q][0] * arr[r][0] * arr[s][0])
                                                        - (arr[i][1] + arr[j][1] + arr[k][1] + arr[l][1] + arr[m][1] + arr[p][1] + arr[q][1] + arr[r][1] + arr[s][1])));
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        if(n >= 10) {
            for(int i = 0; i < n - 9; i++) {
                for(int j = i + 1; j < n - 8; j++) {
                    for(int k = j + 1; k < n - 7; k++) {
                        for(int l = k + 1; l < n - 6; l++) {
                            for(int m = l + 1; m < n - 5; m++) {
                                for (int p = m + 1; p < n - 4; p++) {
                                    for(int q = p + 1; q < n - 3; q++) {
                                        for(int r = q + 1; r < n - 2; r++) {
                                            for(int s = r + 1; s < n - 1; s++) {
                                                for(int t = s + 1; t < n; t++) {
                                                    arrList.add(Math.abs((arr[i][0] * arr[j][0] * arr[k][0] * arr[l][0] * arr[m][0] * arr[p][0] * arr[q][0] * arr[r][0] * arr[s][0] * arr[t][0])
                                                            - (arr[i][1] + arr[j][1] + arr[k][1] + arr[l][1] + arr[m][1] + arr[p][1] + arr[q][1] + arr[r][1] + arr[s][1] + arr[t][1])));
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        Collections.sort(arrList);

        System.out.println(arrList.get(0));

    }
}
