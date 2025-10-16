package baekjoon.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P2841 {
    static int n;
    static int p;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());

        arr = new int[n][2];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 2; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

//        5 15
//        1 8   -> 1회   (아무것돕없음)
//        1 10  -> 1회   (8보다 크기 때문에 1회)
//        1 12  -> 1회   (10보다 크기 떄문에 1회)
//        1 10  -> 1회   (12보다 작기 때문에 12에서 손을 떔 -> 하지만 10은 이미 눌러져 있기 때문에 1회만 추가하면됨)
//        1 5   -> 3회   (10과 8에서 손을 떼기 때문에 2회 -> 5에 손을 올리기 떄문에 1회 플러스)

        int count = 0;
        // 각 줄마다 stack 선언
        Stack<Integer> oneLine = new Stack<>();
        Stack<Integer> twoLine = new Stack<>();
        Stack<Integer> threeLine = new Stack<>();
        Stack<Integer> fourLine = new Stack<>();
        Stack<Integer> fiveLine = new Stack<>();
        Stack<Integer> sixLine = new Stack<>();

        for(int i = 0; i < n; i++) {
            if(arr[i][0] == 1) {
                // 만약에 현재 줄에 값이 비어있을 경우
                if(oneLine.isEmpty()) {
                    // 값을 넣어주고 count를 증가시켜준다.
                    oneLine.push(arr[i][1]);
                    count++;
                    continue;
                }

                // 만약에 다음에 들어올 줄의 p가 크다면 손을 떼지 않고 count만 증가
                if(oneLine.peek() < arr[i][1]) {
                    oneLine.push(arr[i][1]);
                    count++;
                } else {
                    // 만약에 다음에 들어올 줄의 p가 더 작거나 같다면 stack을 비워주면서 count 증가
                    while(!oneLine.isEmpty()) {
                        if(oneLine.peek() > arr[i][1]) {
                            oneLine.pop();
                            count++;
                        } else {
                            break;
                        }

                    }
                    // 만약에 현재 stack의 맨 위에 값이 같을 경우 count를 증가시켜주지 않음
                    if(!oneLine.isEmpty() && oneLine.peek() != arr[i][1]) {
                        // 그리고 값 넣어주기!
                        oneLine.push(arr[i][1]);
                        count++;
                    } else if(oneLine.isEmpty()) {
                        oneLine.push(arr[i][1]);
                        count++;
                    }
                }

            } else if(arr[i][0] == 2) {
                // 만약에 현재 줄에 값이 비어있을 경우
                if(twoLine.isEmpty()) {
                    // 값을 넣어주고 count를 증가시켜준다.
                    twoLine.push(arr[i][1]);
                    count++;
                    continue;
                }

                // 만약에 다음에 들어올 줄의 p가 크다면 손을 떼지 않고 count만 증가
                if(twoLine.peek() < arr[i][1]) {
                    twoLine.push(arr[i][1]);
                    count++;
                } else {
                    // 만약에 다음에 들어올 줄의 p가 더 작거나 같다면 stack을 비워주면서 count 증가
                    while(!twoLine.isEmpty()) {
                        if(twoLine.peek() > arr[i][1]) {
                            twoLine.pop();
                            count++;
                        } else {
                            break;
                        }

                    }
                    // 만약에 현재 stack의 맨 위에 값이 같을 경우 count를 증가시켜주지 않음
                    if(!twoLine.isEmpty() && twoLine.peek() != arr[i][1]) {
                        // 그리고 값 넣어주기!
                        twoLine.push(arr[i][1]);
                        count++;
                    } else if(twoLine.isEmpty()) {
                        twoLine.push(arr[i][1]);
                        count++;
                    }
                }
            } else if(arr[i][0] == 3) {
                // 만약에 현재 줄에 값이 비어있을 경우
                if(threeLine.isEmpty()) {
                    // 값을 넣어주고 count를 증가시켜준다.
                    threeLine.push(arr[i][1]);
                    count++;
                    continue;
                }

                // 만약에 다음에 들어올 줄의 p가 크다면 손을 떼지 않고 count만 증가
                if(threeLine.peek() < arr[i][1]) {
                    threeLine.push(arr[i][1]);
                    count++;
                } else {
                    // 만약에 다음에 들어올 줄의 p가 더 작거나 같다면 stack을 비워주면서 count 증가
                    while(!threeLine.isEmpty()) {
                        if(threeLine.peek() > arr[i][1]) {
                            threeLine.pop();
                            count++;
                        } else {
                            break;
                        }

                    }
                    // 만약에 현재 stack의 맨 위에 값이 같을 경우 count를 증가시켜주지 않음
                    if(!threeLine.isEmpty() && threeLine.peek() != arr[i][1]) {
                        // 그리고 값 넣어주기!
                        threeLine.push(arr[i][1]);
                        count++;
                    } else if(threeLine.isEmpty()) {
                        threeLine.push(arr[i][1]);
                        count++;
                    }
                }
            } else if(arr[i][0] == 4) {
                // 만약에 현재 줄에 값이 비어있을 경우
                if(fourLine.isEmpty()) {
                    // 값을 넣어주고 count를 증가시켜준다.
                    fourLine.push(arr[i][1]);
                    count++;
                    continue;
                }

                // 만약에 다음에 들어올 줄의 p가 크다면 손을 떼지 않고 count만 증가
                if(fourLine.peek() < arr[i][1]) {
                    fourLine.push(arr[i][1]);
                    count++;
                } else {
                    // 만약에 다음에 들어올 줄의 p가 더 작거나 같다면 stack을 비워주면서 count 증가
                    while(!fourLine.isEmpty()) {
                        if(fourLine.peek() > arr[i][1]) {
                            fourLine.pop();
                            count++;
                        } else {
                            break;
                        }

                    }
                    // 만약에 현재 stack의 맨 위에 값이 같을 경우 count를 증가시켜주지 않음
                    if(!fourLine.isEmpty() && fourLine.peek() != arr[i][1]) {
                        // 그리고 값 넣어주기!
                        fourLine.push(arr[i][1]);
                        count++;
                    } else if(fourLine.isEmpty()) {
                        fourLine.push(arr[i][1]);
                        count++;
                    }
                }
            } else if(arr[i][0] == 5) {
                // 만약에 현재 줄에 값이 비어있을 경우
                if(fiveLine.isEmpty()) {
                    // 값을 넣어주고 count를 증가시켜준다.
                    fiveLine.push(arr[i][1]);
                    count++;
                    continue;
                }

                // 만약에 다음에 들어올 줄의 p가 크다면 손을 떼지 않고 count만 증가
                if(fiveLine.peek() < arr[i][1]) {
                    fiveLine.push(arr[i][1]);
                    count++;
                } else {
                    // 만약에 다음에 들어올 줄의 p가 더 작거나 같다면 stack을 비워주면서 count 증가
                    while(!fiveLine.isEmpty()) {
                        if(fiveLine.peek() > arr[i][1]) {
                            fiveLine.pop();
                            count++;
                        } else {
                            break;
                        }

                    }
                    // 만약에 현재 stack의 맨 위에 값이 같을 경우 count를 증가시켜주지 않음
                    if(!fiveLine.isEmpty() && fiveLine.peek() != arr[i][1]) {
                        // 그리고 값 넣어주기!
                        fiveLine.push(arr[i][1]);
                        count++;
                    } else if(fiveLine.isEmpty()) {
                        fiveLine.push(arr[i][1]);
                        count++;
                    }
                }
            } else if(arr[i][0] == 6) {
                // 만약에 현재 줄에 값이 비어있을 경우
                if(sixLine.isEmpty()) {
                    // 값을 넣어주고 count를 증가시켜준다.
                    sixLine.push(arr[i][1]);
                    count++;
                    continue;
                }

                // 만약에 다음에 들어올 줄의 p가 크다면 손을 떼지 않고 count만 증가
                if(sixLine.peek() < arr[i][1]) {
                    sixLine.push(arr[i][1]);
                    count++;
                } else {
                    // 만약에 다음에 들어올 줄의 p가 더 작거나 같다면 stack을 비워주면서 count 증가
                    while(!sixLine.isEmpty()) {
                        if(sixLine.peek() > arr[i][1]) {
                            sixLine.pop();
                            count++;
                        } else {
                            break;
                        }

                    }
                    // 만약에 현재 stack의 맨 위에 값이 같을 경우 count를 증가시켜주지 않음
                    if(!sixLine.isEmpty() && sixLine.peek() != arr[i][1]) {
                        // 그리고 값 넣어주기!
                        sixLine.push(arr[i][1]);
                        count++;
                    } else if(sixLine.isEmpty()) {
                        sixLine.push(arr[i][1]);
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
    }
}

//        1 5   -> 1회
//        2 3   -> 1회
//        2 5   -> 1회
//        2 7   -> 1회
//        2 4   -> 3회
//        1 5   -> 행동없음
//        1 3   -> 2회
