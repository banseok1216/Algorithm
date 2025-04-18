import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); 
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken()); 
        ArrayList<ArrayList<Node>> graph = new ArrayList<>(); 
        ArrayList<ArrayList<Node>> reverse_graph = new ArrayList<>(); 

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Node>());
            reverse_graph.add(new ArrayList<Node>());
        }
        int[] indegree = new int[n + 1];
        int[] path = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, e));
            indegree[b]++;
            reverse_graph.get(b).add(new Node(a, e));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        while (!q.isEmpty()) {
            int now = q.poll();
            for (Node cur : graph.get(now)) {
                // 연결 성분 탐색
                indegree[cur.toNode]--;
                path[cur.toNode] = Math.max(path[cur.toNode], path[now] + cur.e);
                if (indegree[cur.toNode] == 0)
                    q.offer(cur.toNode);
            }
        }
        // 역위상정렬
        q.offer(end);
        int cnt = 0;
        boolean[] visited = new boolean[n + 1];
        visited[end] = true;
        while (!q.isEmpty()) {
            int now = q.poll();
            for (Node cur : reverse_graph.get(now)) {
                if (path[now] == path[cur.toNode] + cur.e) {
                    // 임계 경로이면
                    cnt++; // 도로 개수 카운팅
                    if (!visited[cur.toNode]) {
                        // 아직 미방문인 노드라면
                        q.offer(cur.toNode);
                        visited[cur.toNode] = true;
                    }
                }
            }
        }
        System.out.println(path[end]);
        System.out.println(cnt);
    }
    static class Node {
        int toNode;
        int e;

        public Node(int toNode, int e) {
            this.toNode = toNode;
            this.e = e;
        }
    }
}