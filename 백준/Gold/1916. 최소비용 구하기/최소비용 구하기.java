import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.util.*;
import java.lang.*;


class Node implements Comparable<Node>{
    int Rx,Ry,Bx,By,r,x,y;
    public Node(int y,int r){
        this.r = r;
        this.y = y;
    }

    @Override
    public int compareTo(Node o) {
        return this.r-o.r;
    }
}
public class Main {
    static StringBuilder stringBuilder = new StringBuilder();
    static int[][] treeArray_1;
    static int[][] treeArray_2;
    static boolean[] abc;
    static int max = 0;
    static int min = Integer.MAX_VALUE;
    static boolean[][] visited;
    static String[] result;
    static int[][] v;
    static int check=0;
    static String K = "YES";
    static int R = Integer.MAX_VALUE;
    static int p = 0;
    static int q = 0;
    static int m;
    static int n;
    static int[] list2;
    static int[] list3;
    static int[][] list4;
    static Stack<String> stack = new Stack<>();
    static Stack<String> stack1 = new Stack<>();
    static Queue<ArrayList<String>> queue1 = new LinkedList<ArrayList<String>>();
    static Queue<Node> queue = new LinkedList<>();
    static PriorityQueue<Node> queue3 = new PriorityQueue<Node>();
    static HashSet<Integer> ok = new HashSet<>();
    static ArrayList<ArrayList<Node>> graph;
    static ArrayList<Integer> list = new ArrayList<>();
    static ArrayList<String> strings = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Node> priorityQueue1 = new PriorityQueue<>();
        PriorityQueue<Integer> priorityQueue2 = new PriorityQueue<>();
        Queue<Node> priorityQueue3 = new LinkedList<>();
        m = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for(int i=0; i<=m; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<n; i++){
            String[] str1 = br.readLine().split(" ");
            graph.get(Integer.parseInt(str1[0])).add(new Node(Integer.parseInt(str1[1]),Integer.parseInt(str1[2])));
        }
        abc = new boolean[m+1];
        String[] str2 = br.readLine().split(" ");
        p=Integer.parseInt(str2[1]);
        bfs(Integer.parseInt(str2[0]));
        System.out.println(min);
    }
    private static void bfs(int x) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(x,0));
        while(!q.isEmpty()) {
            Node node = q.poll();
            if (node.y == p) {
                min = Math.min(node.r, min);
                break;
            }
            if (!abc[node.y]) {
                abc[node.y] = true;
                for (int i = 0; i < graph.get(node.y).size(); i++) {
                    if (graph.get(node.y).get(i).y == p) {
                        min = Math.min(graph.get(node.y).get(i).r + node.r, min);
                    }
                    q.add(new Node(graph.get(node.y).get(i).y, graph.get(node.y).get(i).r + node.r));
                }
            }
        }
    }
}