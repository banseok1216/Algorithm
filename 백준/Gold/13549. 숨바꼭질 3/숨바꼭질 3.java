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
    static ArrayList<Node> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Scanner sc = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        String[] str1 = br.readLine().split(" ");
        int start = Integer.parseInt(str1[0]);
        int end = Integer.parseInt(str1[1]);
        v = new int[200001];
        visited = new boolean[200001];
        for(int i=0; i<v.length; i++){
            v[i] = Integer.MAX_VALUE/5;
        }
        bfs(start,end);
        System.out.println(min);
    }
    public static int bfs(int start,int end){
        PriorityQueue<Node> Queue = new PriorityQueue<Node>();
        Queue.offer(new Node(start,0));
        v[start] =0;
        while(!Queue.isEmpty()){
            Node o = Queue.poll();
            if(o.i == end){
                min = Math.min(min, o.w);
            }
            else{
                if(!visited[o.i]) {
                    visited[o.i] = true;
                    if (o.i - 1 >= 0 && v[o.i - 1] > v[o.i] + 1) {
                        v[o.i - 1] = Math.min(v[o.i] + 1, v[o.i - 1]);
                        Queue.offer(new Node(o.i - 1, v[o.i] + 1));
                    }
                    if (o.i + 1 <= 200000 && v[o.i + 1] > v[o.i] + 1) {
                        v[o.i + 1] = Math.min(v[o.i] + 1, v[o.i + 1]);
                        Queue.offer(new Node(o.i + 1, v[o.i] + 1));
                    }
                    if (o.i * 2 <= 200000 && v[o.i * 2] > v[o.i]) {
                        v[o.i * 2] = Math.min(v[o.i * 2], v[o.i]);
                        Queue.offer(new Node(o.i * 2, v[o.i]));

                    }
                }
            }
        }
        return min;
    }
}