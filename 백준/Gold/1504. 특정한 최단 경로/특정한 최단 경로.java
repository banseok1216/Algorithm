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
        R = Integer.parseInt(str1[0]);
        int E = Integer.parseInt(str1[1]);
        for(int i=0; i<R+1; i++){
            graph.add(new ArrayList<Node>());
        }
        for(int i=0; i<E; i++){
            String[] str2 = br.readLine().split(" ");
            graph.get(Integer.parseInt(str2[0])).add(new Node(Integer.parseInt(str2[1]), Integer.parseInt(str2[2])));
            graph.get(Integer.parseInt(str2[1])).add(new Node(Integer.parseInt(str2[0]), Integer.parseInt(str2[2])));
        }
        String[] str3 = br.readLine().split(" ");
        int v1 = Integer.parseInt(str3[0]);
        int v2 = Integer.parseInt(str3[1]);

        int res1 = 0;
        res1 += bfs(1, v1);
        res1 += bfs(v1, v2);
        res1 += bfs(v2, R);

        // 1 -> v2 -> v1 -> N으로 가는 경우
        int res2 = 0;
        res2 += bfs(1, v2);
        res2 += bfs(v2, v1);
        res2 += bfs(v1, R);

        int ans = (res1 >= Integer.MAX_VALUE/4 && res2 >= Integer.MAX_VALUE/4) ? -1 : Math.min(res1, res2);
        System.out.println(ans);
    }
    public static int bfs(int start,int end){
        PriorityQueue<Node> Queue = new PriorityQueue<Node>();
        Queue.offer(new Node(start,0));
        v = new int[R+1];
        check = new boolean[R+1];
        for(int i=0; i<v.length; i++){
            v[i] = Integer.MAX_VALUE/4;
        }
        v[start] = 0;
        while(!Queue.isEmpty()){
            Node o = Queue.poll();
            int startnum  = o.i;
            if (!check[startnum]) {
                check[startnum] = true;
                for (int i = 0; i < graph.get(startnum).size(); i++) {
                    if (v[graph.get(startnum).get(i).i] > v[startnum] + graph.get(startnum).get(i).w) {
                        v[graph.get(startnum).get(i).i] = v[startnum] + graph.get(startnum).get(i).w;
                        Queue.offer(new Node(graph.get(startnum).get(i).i, v[startnum] + graph.get(startnum).get(i).w));
                    }
                }
            }
        }
        return v[end];
    }
}