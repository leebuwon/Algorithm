package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P16235 {
    static int n;
    static int m;
    static int k;
    static int[][] map;
    static Deque<Integer>[][] trees;
    static int[][] treeFood;
    static int[][] dieTree;
    static int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};
    static int[] dx = {1, -1, 0, 0, 1, -1, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        treeFood = new int[n][n];
        trees = new Deque[n][n];
        dieTree = new int[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                trees[i][j] = new ArrayDeque<>();
                map[i][j] = Integer.parseInt(st.nextToken());
                treeFood[i][j] = 5;
            }
        }


        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());

            trees[x][y].add(z);
        }

        // treePosition은 나무의 위치임
        int year = 0;
        while (year < k) {
            year++;


            // 나무 정렬
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!trees[i][j].isEmpty()) {
                        List<Integer> list = new ArrayList<>(trees[i][j]);
                        Collections.sort(list);
                        trees[i][j] = new ArrayDeque<>(list);
                    }
                }
            }

            // 양분은 처음에 전부다 5임

            // 봄
            // 나무가 자신의 나이만큼 양분을 먹고, 나이가 1증가함. 각각의 나무는 나무가 있는 1*1 크기의 칸에 양분을 먹음, 하나의 칸에 나무가 어린게 있다면 그 친구부터 양분을 먹음
            // 양분이 부족하면 나이만큼 양분을 먹을 수 없는 나무는 죽음
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(trees[i][j].isEmpty()) {
                        continue;
                    }

                    int size = trees[i][j].size();
                    int sum = 0;

                    for(int k = 0; k < size; k++) {
                        int age = trees[i][j].pollFirst();

                        if(treeFood[i][j] >= age) {
                            treeFood[i][j] -= age;
                            trees[i][j].addLast(age + 1);
                        } else {
                            sum += age / 2;
                        }
                    }

                    dieTree[i][j] = sum;
                }
            }


            // 여름
            // 봄에 죽은 나무가 양분으로 변함, 각각 죽은 나무마다 나이를 2로 나누고 있던 칸에 양분으로 추가
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++) {
                    if(dieTree[i][j] != 0) {
                        treeFood[i][j] += dieTree[i][j];
                        dieTree[i][j] = 0;
                    }
                }
            }

            // 가을
            // 나무가 번식, 번식하는 나무는 나이가 5배수여야 하고 인접한 칸에 나무가 1인 나무들이 생김 (인접한 8칸)
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(trees[i][j].isEmpty()) {
                        continue;
                    }

                    for (Integer arr : trees[i][j]) {
                        if(arr % 5 == 0) {
                            plantTree(i, j);
                        }
                    }
                }
            }

            // 겨울
            // 양분을 추가함, n * n에 표시된 양분이 추가된다.
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    treeFood[i][j] += map[i][j];
                }
            }
        }

        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                count += trees[i][j].size();
            }
        }

        System.out.println(count);
    }

    private static void plantTree(int y, int x) {
        for(int i = 0; i < 8; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny < 0 || nx < 0 || ny >= n || nx >= n) {
                continue;
            }

            trees[ny][nx].add(1);
        }
    }
}
