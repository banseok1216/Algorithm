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
    static String[] result;
    static int[][] v;
    static boolean[] check;
    static String K = "YES";
    static int R = Integer.MAX_VALUE;
    static int p = 0;
    static int q = 0;
    static LinkedList<Integer> list1 = new LinkedList<>();
    static Deque<Integer> deque1 = new ArrayDeque<Integer>();
    static Deque<Integer> deque2 = new ArrayDeque<Integer>();
    static int[] list2;
    static Stack<String> stack = new Stack<>();
    static Stack<String> stack1 = new Stack<>();
    static Queue<ArrayList<String>> queue1 = new LinkedList<ArrayList<String>>();
    static Queue<Integer> queue2 = new LinkedList<Integer>();
    static HashSet<Integer> ok = new HashSet<>();
    static ArrayList<ArrayList<Node>> graph;
    static ArrayList<int[]> list = new ArrayList<int[]>();
    static int[] first;
    static int[] second;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Scanner sc = new Scanner(System.in);
        int m = Integer.parseInt(br.readLine());
        for(int i=0; i<m; i++){
            visited = new boolean[20001];
            result = new String[20001];
            String[] str1 = br.readLine().split(" ");
            bfs(Integer.parseInt(str1[0]),Integer.parseInt(str1[1]));
            stringBuilder.append(result[Integer.parseInt(str1[1])]).append("\n");
        }
        System.out.println(stringBuilder);
    }
    private static void bfs(int start,int end){
        queue2 = new LinkedList<>();
        queue2.offer(start);
        result[start] = "";
        while(!queue2.isEmpty() && !visited[end]){
            int m = queue2.poll();
            int D = (m*2)%10000;
            int S = (m-1+10000)%10000;
            int L = (m % 1000) * 10 + m / 1000; // 1234 -> 2341 : 1234를 1000으로 나눈 나머지(234)에 10을 곱함=2340, 1234를 1000으로 나누면 1, 2340+1=2341
            int R = (m % 10) * 1000 + m / 10;
            if (!visited[D] &&  (result[D]==null || result[D].length() > result[m].length()+1)) {
                queue2.offer(D);
                visited[D] = true;
                result[D] = result[m] + "D";
            }
            if (!visited[S]&&  (result[S]==null || result[S].length() > result[m].length()+1)) {
                queue2.offer(S);
                visited[S] = true;
                result[S] = result[m] + "S";
            }
            if (!visited[L]&&  (result[L]==null || result[L].length() > result[m].length()+1)) {
                queue2.offer(L);
                visited[L] = true;
                result[L] = result[m] + "L";
            }
            if (!visited[R]&&  (result[R]==null || result[R].length() > result[m].length()+1)) {
                queue2.offer(R);
                visited[R] = true;
                result[R] = result[m] + "R";
            }
        }
    }
}