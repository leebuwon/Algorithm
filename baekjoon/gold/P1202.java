package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// GPT 참고
public class P1202 {
    static int n;
    static int k;
    static Jewel[] jewel;
    static int[] bag;
    static class Jewel {
        int weight;
        int value;

        public Jewel(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        jewel = new Jewel[n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            jewel[i] = new Jewel(weight, value);
        }

        bag = new int[k];
        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            bag[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(jewel, (a, b) -> {
            if(a.weight == b.weight) {
                return b.value - a.value;
            }

            return a.weight - b.weight;
        });

        Arrays.sort(bag);

        // 가방 하나에 최대 한개의 보석을 넣을 수 있음!
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        int idx = 0;
        long sum = 0;

        for (int i = 0; i < k; i++) {
            int nowBag = bag[i];

            while (idx < n && jewel[idx].weight <= nowBag) {
                pq.add(jewel[idx].value);
                idx++;
            }

            if (!pq.isEmpty()) {
                sum += pq.poll();
            }
        }

//
//        int sum = 0;
//        for(int i = 0; i < k; i++) {
//            int nowBag = bag[i];
//
//            if(pq.isEmpty()) {
//                break;
//            }
//
//            int max = Integer.MIN_VALUE;
//
//            PriorityQueue<Jewel> temp = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));
//            while (!pq.isEmpty()) {
//                Jewel now = pq.poll();
//
//                if(now.weight <= nowBag) {
//                    if(max < now.value) {
//                        max = now.value;
//                        temp.add(now);
//                    } else {
//                        temp.add(now);
//                    }
//                } else {
//                    pq.add(now);
//                    break;
//                }
//            }
//
//            if(max == Integer.MIN_VALUE) {
//                max = 0;
//            }
//            sum += max;
//
//            for (Jewel jewel : temp) {
//                if(jewel.value == max) {
//                    max = 0;
//                    continue;
//                }
//
//                pq.add(jewel);
//            }
//        }


        System.out.println(sum == Integer.MIN_VALUE ? 0 : sum);
    }
}
