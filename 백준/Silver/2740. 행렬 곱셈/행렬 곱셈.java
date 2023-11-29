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
    static long[][] treeArray_1;
    static long[][] treeArray_2;
    static int[] abc;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static boolean[] visited;
    static long[][] v;
    static boolean[] check;
    static String K = "YES";
    static int R = 0;
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
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Scanner sc = new Scanner(System.in);
        String[] str1 = br.readLine().split(" ");
        long m = Integer.parseInt(str1[0]);
        long n = Integer.parseInt(str1[1]);
        treeArray_1 = new long[(int) m][(int) n];
        for (int i = 0; i < m; i++) {
            String[] str2 = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                treeArray_1[i][j] = Long.parseLong(str2[j]);
            }
        }
        str1 = br.readLine().split(" ");
        p = Integer.parseInt(str1[0]);
        q = Integer.parseInt(str1[1]);
        v = new long[(int) m][(int) q];
        treeArray_2 = new long[(int) p][(int) q];
        for (int i = 0; i < p; i++) {
            String[] str2 = br.readLine().split(" ");
            for (int j = 0; j < q; j++) {
                treeArray_2[i][j] = Long.parseLong(str2[j]);
            }
        }
        for(int i=0; i<m; i++){
            for(int k =0; k<q; k++ ) {
                for (int j = 0;j<p; j++) {
                    v[i][k] += treeArray_1[i][j] * treeArray_2[j][k];
                }
            }
        }
        for (int i=0; i<m; i++){
            for(int j=0; j<q; j++){
                stringBuilder.append(v[i][j]).append(" ");
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
    }
}