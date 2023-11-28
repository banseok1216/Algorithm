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
    static boolean[] visited;
    static int[][] v;
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
        int V = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());
        for(int i=0; i<V+1; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<E; i++){
            String[] str1 = br.readLine().split(" ");

            graph.get(Integer.parseInt(str1[0])).add(new Node(Integer.parseInt(str1[1]), Integer.parseInt(str1[2])));
        }
        v = new int [V+1][2];
        visited = new boolean[V+1];
        for(int i=0; i<V+1; i++){
            v[i][0] = Integer.MAX_VALUE/5;
        }
        String[] str2 = br.readLine().split(" ");
        int start = Integer.parseInt(str2[0]);
        int end = Integer.parseInt(str2[1]);
        v[start][0] = 0;
        bfs(start,end);
        stringBuilder.append(min).append("\n");
        int result =end;
        stack.add(end);
        while(result != start) {
            result = v[result][1];
            stack.add(result);
        }
        stringBuilder.append(stack.size()).append("\n");
        while (!stack.isEmpty()){
            int m = stack.pop();
            stringBuilder.append(m).append(" ");
        }
        System.out.println(stringBuilder);
    }
    public static void bfs(int start,int end){
        PriorityQueue<Node> Queue = new PriorityQueue<Node>();
        Queue.offer(new Node(start,0));
        while(!Queue.isEmpty()){
            Node o = Queue.poll();
            int NUM = o.i;
            if(NUM == end){
                min = Math.min(min, o.w);
            }
            if(!visited[NUM]) {
                visited[NUM] = true;
                for (int i = 0; i < graph.get(NUM).size(); i++) {
                    if ( v[graph.get(NUM).get(i).i][0]>graph.get(NUM).get(i).w+v[NUM][0]){
                        v[graph.get(NUM).get(i).i][0] = graph.get(NUM).get(i).w+v[NUM][0];
                        v[graph.get(NUM).get(i).i][1] = NUM;
                        Queue.offer(new Node(graph.get(NUM).get(i).i, graph.get(NUM).get(i).w+v[NUM][0]));
                    }
                }
            }
        }
    }
}