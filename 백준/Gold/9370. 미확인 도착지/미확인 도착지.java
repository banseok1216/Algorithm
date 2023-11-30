import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.util.*;
import java.lang.*;

class Node implements Comparable<Node>{
    int i,w;
    public Node(int i,int w){
        this.i = i;
        this.w = w;
    }
    @Override
    public int compareTo(Node o1)
    {
        return w - o1.w;
    }
}
public class Main {
    static StringBuilder stringBuilder = new StringBuilder();
    static int[][] treeArray_1;
    static int[][] treeArray_2;
    static int[] abc;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static boolean[] visited;
    static int[] v;
    static boolean[] check;
    static String K = "YES";
    static int R = Integer.MAX_VALUE;
    static long p = 0;
    static long q = 0;
    static LinkedList<int[]> Queue = new LinkedList<int[]>();
    static LinkedList<Integer> list = new LinkedList<>();
    static LinkedList<Integer> list1 = new LinkedList<>();
    static Deque<Integer> deque1 = new ArrayDeque<Integer>();
    static Deque<Integer> deque2 = new ArrayDeque<Integer>();
    static int[] list2;
    static Stack<Integer> stack = new Stack<>();
    static Stack<String> stack1 = new Stack<>();
    static Queue<Integer> queue1 = new LinkedList<Integer>();
    static Queue<Integer> queuey = new LinkedList<Integer>();
    static HashSet<Integer> ok = new HashSet<>();
    static ArrayList<ArrayList<Node>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Scanner sc = new Scanner(System.in);
        int M = Integer.parseInt(br.readLine());
        for(int l =0; l<M; l++){
        String[] str1 = br.readLine().split(" ");
        String[] str2 = br.readLine().split(" ");
        R = Integer.parseInt(str1[0]);
        int m = Integer.parseInt(str1[1]);
        int t = Integer.parseInt(str1[2]);
        int[] list = new int[t];
        int s = Integer.parseInt(str2[0]);
        int g = Integer.parseInt(str2[1]);
        int h = Integer.parseInt(str2[2]);
        graph = new ArrayList<>();
        for (int i = 0; i < R + 1; i++) {
            graph.add(new ArrayList<>());
        }
        ArrayList<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String[] str3 = br.readLine().split(" ");
            graph.get(Integer.parseInt(str3[0])).add(new Node(Integer.parseInt(str3[1]), Integer.parseInt(str3[2])));
            graph.get(Integer.parseInt(str3[1])).add(new Node(Integer.parseInt(str3[0]), Integer.parseInt(str3[2])));
        }
        for (int i = 0; i < t; i++) {
            int j = Integer.parseInt(br.readLine());
            min = bfs(s,j);
            if (min == bfs(s, h) + bfs(h, g) + bfs(g, j) || min == bfs(s, g) + bfs(g, h) + bfs(h, j)) {
                list1.add(j);
            }
        }
        list1.sort(Integer::compareTo);
        for(int i=0; i<list1.size(); i++){
            stringBuilder.append(list1.get(i)).append(" ");
        }
        stringBuilder.append("\n");
    }
        System.out.println(stringBuilder);
    }
    private static int bfs(int start, int end){
        v=new int[R+1];
        for(int i=0; i< v.length; i++){
            v[i] = Integer.MAX_VALUE;
        }
        visited = new boolean[R + 1];
        PriorityQueue<Node> priorityQueue= new PriorityQueue<>();
        priorityQueue.offer(new Node(start,0));
        v[start] =0;
        while (!priorityQueue.isEmpty()){
            Node o =priorityQueue.poll();
            if(!visited[o.i]){
                visited[o.i] = true;
                for(int i=0; i<graph.get(o.i).size(); i++){
                    if(v[graph.get(o.i).get(i).i] > v[o.i] + graph.get(o.i).get(i).w){
                        v[graph.get(o.i).get(i).i] = v[o.i] + graph.get(o.i).get(i).w;
                        priorityQueue.offer(new Node(graph.get(o.i).get(i).i, v[o.i] + graph.get(o.i).get(i).w));
                    }
                }
            }
        }
        return v[end];
    }
}