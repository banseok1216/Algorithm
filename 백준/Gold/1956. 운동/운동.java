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
        String[] str1 = br.readLine().split(" ");
        int v = Integer.parseInt(str1[0]);
        int e = Integer.parseInt(str1[1]);
        int[][] graph = new int[v][v]; 
        for (int i = 0; i < v; i++)
            Arrays.fill(graph[i], 5000000); 

        for (int i = 0; i < e; i++) {
            String[] str2 = br.readLine().split(" ");
            graph[Integer.parseInt(str2[0]) - 1][Integer.parseInt(str2[1]) - 1] = Integer.parseInt(str2[2]);
        }
        for (int k = 0; k < v; k++)
            for (int i = 0; i < v; i++)
                for (int j = 0; j < v; j++)
                    graph[i][j] = Math.min(graph[i][k] + graph[k][j], graph[i][j]);
        int shortest = 5000000;
        for (int i = 0; i < v; i++)
            for (int j = 0; j < v; j++)
                shortest = Math.min(graph[i][j] + graph[j][i], shortest);

        System.out.println((shortest < 5000000) ? shortest : -1);
    }
}