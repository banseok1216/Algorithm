import java.util.Comparator;

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
    static int[] treeArray_1;
    static int[] treeArray_2;
    static int[] abc;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[][][] visited;
    static int[] v;
    static boolean[] check;
    static String K = "YES";
    static int R = 0;
    static int p = 0;
    static int q = 0;
    static LinkedList<int []> Queue = new LinkedList<int[]>();
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
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Scanner sc = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        String[] str1 = br.readLine().split(" ");
        int V = Integer.parseInt(str1[0]);
        int E = Integer.parseInt(str1[1]);
        int start = Integer.parseInt(br.readLine());
        check = new boolean[V+1];
        v = new int[V+1];
        for(int i=0; i<v.length; i++){
            v[i] = Integer.MAX_VALUE;
        }
        for(int i=0; i<V+1; i++) {
            graph.add(new ArrayList<Node>());
        }
        for(int i=0; i<E; i++){
            String[] str2 = br.readLine().split(" ");
            graph.get(Integer.parseInt(str2[0])).add(new Node(Integer.parseInt(str2[1]),Integer.parseInt(str2[2])));
        }
        bfs(start);
        for(int i=1; i<v.length; i++){
            if(v[i] == Integer.MAX_VALUE){
                stringBuilder.append("INF").append("\n");
            }
            else {
                stringBuilder.append(v[i]).append("\n");
            }
        }
        System.out.println(stringBuilder);
    }
    public static void bfs(int start){
        PriorityQueue<Node> Queue = new PriorityQueue<Node>();
        v[start] =0;
        Queue.offer(new Node(start,0));
        while(!Queue.isEmpty()){
            Node O = Queue.poll();
            int starti = O.i;
            if(!check[starti]){
             check[starti] = true;
             for(int i=0; i<graph.get(starti).size(); i++){
                 if(v[graph.get(starti).get(i).i] > v[starti] + graph.get(starti).get(i).w){
                     v[graph.get(starti).get(i).i] = v[starti] + graph.get(starti).get(i).w;
                     Queue.offer(new Node(graph.get(starti).get(i).i,v[starti]+graph.get(starti).get(i).w));
                 }
             }
            }
        }
    }
}