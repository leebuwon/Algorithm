package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14719 {
    static int h; // 높이
    static int w; // 넓이
    static int[] blockHeight;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        blockHeight = new int[w];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < w; i++) {
            blockHeight[i] = Integer.parseInt(st.nextToken());
        }

        int water = 0;

        int currentMaxHeightIdx = 0;
        int currentMaxHeight = blockHeight[0];
        int tempWater = 0;

        for(int i = 1; i < w; i++) {
            if(blockHeight[i] >= currentMaxHeight) {
                water += tempWater; // 임시보관했던 물 넣어주기
                tempWater = 0;

                currentMaxHeight = blockHeight[i];
                currentMaxHeightIdx = i;
            } else {
                tempWater += currentMaxHeight - blockHeight[i];
            }
        }

        // 오른쪽부터 다시 탐색하기 (가장 높은 층이 있던곳까지)
        int maxRight = blockHeight[w - 1];
        tempWater = 0;
        for (int i = w - 2; i >= currentMaxHeightIdx; i--) {
            if (blockHeight[i] >= maxRight) {
                water += tempWater;
                tempWater = 0;
                maxRight = blockHeight[i];
            } else {
                tempWater += maxRight - blockHeight[i];
            }
        }

        System.out.println(water);


    }
}
