package cn.bw.leetcode.sample;

import java.util.*;

public class A310最小高度树sample {

    /***
     *
     */
    private int maxNode, maxDepth;
    private void dfs(int from, int depth, List<Integer>[] graph, boolean[] visited, int[] dist, int[] prev) {
        if (depth > maxDepth) {
            maxDepth = depth;
            maxNode = from;
        }
        for(int next: graph[from]) {
            if (visited[next]) continue;
            visited[next] = true;
            prev[next] = from;
            dist[next] = depth+1;
            dfs(next, depth+1, graph, visited, dist, prev);
        }
    }

    private List<Integer> roots = new ArrayList<>();

    public List<Integer> findMinHeightTrees1(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];
        for(int i=0; i<n; i++) graph[i] = new ArrayList<>();
        for(int i=0; i<edges.length; i++) {
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
        }

        boolean[] visited = new boolean[n];

        int[] dist1 = new int[n];
        int[] prev1 = new int[n];
        maxNode = 0;
        maxDepth = 0;
        visited[0] = true;
        dfs(0, 0, graph, visited, dist1, prev1);
        int node1 = maxNode;

        int[] dist2 = new int[n];
        int[] prev2 = new int[n];
        Arrays.fill(visited, false);
        maxNode = node1;
        maxDepth = 0;
        visited[node1] = true;
        dfs(node1, 0, graph, visited, dist2, prev2);
        int node2 = maxNode;

        int node = node2;
        for(int i=0; i<maxDepth/2; i++) node = prev2[node];
        if ((maxDepth & 1) == 0) {
            roots.add(node);
        } else {
            roots.add(node);
            roots.add(prev2[node]);
        }
        return roots;
    }


    /***
     * @思路：
     * 先遍历 求入度， 然后，从入度为1的开始 从外往里 走。
     * @param n
     * @param edges
     * @return
     */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        // 特判
        if (n <= 2) {
            for (int i = 0; i < n; i++) {
                res.add(i);
            }
            return res;
        }

        // 入度数组，每一次要把入度为 1 的结点剔除
        int[] inDegrees = new int[n];

        // 默认为 False，如果剔除，设置为 True
        boolean[] result = new boolean[n];

        // 因为是无向图，所以邻接表拿出一条边，两个结点都要存一下
        // 注意：右边就不要写具体的实现类了，等到实例化的时候再写具体的实现类
        Set<Integer>[] adjs = new Set[n];
        // 初始化
        for (int i = 0; i < n; i++) {
            adjs[i] = new HashSet<>();
        }

        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            adjs[start].add(end);
            adjs[end].add(start);
            inDegrees[start] += 1;
            inDegrees[end] += 1;
        }
        LinkedList<Integer> queue = new LinkedList<>();

        // 入度为 1 的结点入队
        for (int i = 0; i < n; i++) {
            if (inDegrees[i] == 1) {
                queue.addLast(i);
            }
        }

        // 注意边界条件 n == 2 和 n == 1 是如何分析出来的
        while (n > 2) {
            int size = queue.size();
            System.out.println(queue);
            // 一次减去这么多
            n -= size;
            for (int i = 0; i < size; i++) {
                int top = queue.removeFirst();
                result[top] = true;
                inDegrees[top] -= 1;
                // 把它和它的邻接结点的入度全部减 1
                Set<Integer> successors = adjs[top];
                for (Integer successor : successors) {
                    inDegrees[successor] -= 1;
                    if (inDegrees[successor] == 1) {
                        queue.addLast(successor);
                    }
                }
            }
        }
        n = result.length;
        for (int i = 0; i < n; i++) {
            if (!result[i]) {
                res.add(i);
            }
        }
        return res;
    }


    public static void main(String...args){

        int n = 6;
        int[][] edges = {{1,3},{0,3},{2,3},{4,3},{5,4}};

        A310最小高度树sample a = new A310最小高度树sample();
        List<Integer> roots = a.findMinHeightTrees(n, edges);

        System.out.println(roots);
        System.out.println("edn");

    }

}
