import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.util.*;
import java.lang.*;


class Node implements Comparable<Node>{
    int x,y;
    public Node(int x,int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Node o) {
        return this.y - o.y;
    }
}
class tree{
    int x,y;
    public tree(int x,int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static StringBuilder stringBuilder = new StringBuilder();
    static boolean abc;
    static int max = Integer.MAX_VALUE;
    static int min = Integer.MAX_VALUE;
    static boolean[][] visited;
    static int[] list4;
    static int[] list3;
    static ArrayList<ArrayList<tree>> T;
    static ArrayList<int[]> list = new ArrayList<>();
    static ArrayList<Node> ans = new ArrayList<>();
    static final int INF = (int) 1e9;
    static int N, M, S, D;
    static int[] dist;
    static List<Integer>[] path;
    static List<Node>[] edgeList;
    static PriorityQueue<Node> pq;
    static boolean[][] check;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);
        edgeList = new ArrayList[501];
        path = new ArrayList[501];
        dist = new int[501];
        check = new boolean[501][501];
        pq = new PriorityQueue<>();
        for (int i = 0; i < 501; ++i) {
            edgeList[i] = new ArrayList<>();
            path[i] = new ArrayList<>();
        }

            while (true) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                N = Integer.parseInt(st.nextToken());
                M = Integer.parseInt(st.nextToken());
                if (N == 0 && M == 0) break;

                st = new StringTokenizer(br.readLine());
                S = Integer.parseInt(st.nextToken());
                D = Integer.parseInt(st.nextToken());

                for (int i = 0; i < M; ++i) {
                    st = new StringTokenizer(br.readLine());
                    int U = Integer.parseInt(st.nextToken());
                    int V = Integer.parseInt(st.nextToken());
                    int P = Integer.parseInt(st.nextToken());
                    edgeList[U].add(new Node(V, P));
                }

                dijkstra();
                removeEdge(D);
                dijkstra();

                stringBuilder.append((dist[D] == INF ? -1 : dist[D]) + "\n");

                for (int i = 0; i < N; ++i) {
                    edgeList[i].clear();
                    path[i].clear();
                    Arrays.fill(check[i], false);
                }
            }
            System.out.println(stringBuilder);
        }

        public static void dijkstra () {
            for (int i = 0; i < N; ++i) {
                dist[i] = INF;
            }

            dist[S] = 0;
            pq.offer(new Node(S, 0));
            while (!pq.isEmpty()) {
                Node e = pq.poll();

                if (dist[e.x] < e.y) continue;

                for (Node ne : edgeList[e.x]) {
                    if (check[e.x][ne.x]) continue;//제거된 간선

                    //같은 최단 경로라면 path에 저장
                    if (dist[ne.x] == e.y + ne.y) {
                        path[ne.x].add(e.x);
                    }
                    //새로운 최단 경로라면 기존의 path를 제거 후 저장
                    else if (dist[ne.x] > e.y + ne.y) {
                        dist[ne.x] = e.y + ne.y;
                        path[ne.x].clear();
                        path[ne.x].add(e.x);
                        pq.offer(new Node(ne.x, dist[ne.x]));
                    }
                }
            }
        }

        public static void removeEdge ( int v){
            for (int bv : path[v]) {
                if (check[bv][v]) continue;
                check[bv][v] = true;
                removeEdge(bv);
            }
        }
    }