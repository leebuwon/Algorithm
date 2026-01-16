package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P20924 {
    static int n;
    static int r;
    static int[][] arr;
    static List<List<graph>> list = new ArrayList<>();
    static int gigaNode;
    static int column;
    static int branch;
    static int gigaParent = -1;
    static boolean[] visited;
    static class graph {
        int to;
        int value;

        public graph(int to, int value) {
            this.to = to;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        visited = new boolean[n + 1];

        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.get(a).add(new graph(b, c));
            list.get(b).add(new graph(a, c));
        }

        findGiga(r, 0, 0);
        visited[gigaNode] = true;
        for (graph graph  : list.get(gigaNode)) {
            dfs(graph.to, graph.value);
        }

        System.out.println(column + " " + branch);
    }

    private static void dfs(int to, int value) {
        visited[to] = true;
        boolean flag = true;

        for (graph next  : list.get(to)) {
            if(!visited[next.to]) {
                flag = false;
                dfs(next.to, value + next.value);
            }
        }

        if(flag && gigaParent != to) {
            branch = Math.max(branch, value);
        }
    }

    private static void findGiga(int node, int mainLine, int parent) {
        visited[node] = true;

        int childCount = 0;
        graph nextNode = null;

        for (graph next : list.get(node)) {
            if(!visited[next.to]) {
                childCount++;
                nextNode = next;
            }
        }

        if(childCount >= 2 || node != r && childCount == 0) {
            gigaNode = node;
            column = mainLine;
            gigaParent = parent;
            return;
        }

        if(list.size() != 2) {
            findGiga(nextNode.to, mainLine + nextNode.value, node);
        }
    }
}
