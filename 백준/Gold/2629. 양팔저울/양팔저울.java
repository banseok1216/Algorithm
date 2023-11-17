import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    static StringBuilder stringBuilder = new StringBuilder();
    static boolean[][] treeArray_1;
    static char[] treeArray_2;
    static int[] abc;
    static long max = Long.MIN_VALUE;
    static long min = Long.MAX_VALUE;
    static boolean[][] visited;
    static int[][] v;

    static int K = 0;
    static int R = 0;
    static int p = 0;
    static int q = 0;
    static Queue<Integer> Queue = new LinkedList<Integer>();
    static Deque<Integer> deque1 = new ArrayDeque<Integer>();
    static Deque<Integer> deque2 = new ArrayDeque<Integer>();
    static int[] list1;
    static int[] list2;
    static Stack<Integer> stack = new Stack<Integer>();
    static Queue<int[]> queue = new LinkedList<int[]>();
    static HashSet<Integer> ok = new HashSet<>();
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Scanner sc = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<Long> list3 = new ArrayList<>();
        K = Integer.parseInt(br.readLine());
        String[] str1 = br.readLine().split(" ");
        p = Integer.parseInt(br.readLine());
        String[] str2 = br.readLine().split(" ");
        visited = new boolean[K+1][40002];
        list1 = new int[K];
        list2 = new int[p];
        for (int i=0; i<K; i++){
            list1[i] = Integer.parseInt(str1[i]);
        }
        for(int i=0; i<p; i++){
            list2[i] = Integer.parseInt(str2[i]);
        }
        dfs(0,0);
        for(int i=0; i<p; i++){
            if(visited[K][list2[i]]){
                stringBuilder.append("Y ");
            }
            else {
                stringBuilder.append("N ");
            }
        }
        System.out.println(stringBuilder);
    }

    private static void dfs(int t, int weight ){
        weight = Math.abs(weight);
        if(weight > 40000){
            return;
        }
        else if(visited[t][weight] || t==K){
            visited[t][weight] = true;
            return;
        }
        else{
            visited[t][weight] = true;
            dfs(t+1, weight+list1[t]);
            dfs(t+1, weight);
            dfs(t+1, weight-list1[t]);
        }
    }
}