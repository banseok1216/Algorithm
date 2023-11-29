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
        int m = Integer.parseInt(br.readLine());
        v=new int[m][m];
        for(int i=0; i<m; i++){
            String[] str1 = br.readLine().split(" ");
            for(int j=0; j<str1.length; j++){
                v[i][j] = Integer.parseInt(str1[j]);
            }
        }
        partition(0,0,m);
        System.out.println(q);
        System.out.println(p);
    }
    private static void partition(int m, int n, int k){
        if(check(m,n,k)){
            if(v[m][n] == 1){
                p++;
            }
            else{
                q++;
            }
        }
        else{
            partition(m,n,k/2);
            partition(m+k/2,n,k/2);
            partition(m,n+k/2,k/2);
            partition(m+k/2,n+k/2, k/2);
        }
    }

    private static boolean check(int m, int n, int k){
        int color = v[m][n];
        for(int i=m; i<m+k; i++){
            for(int j=n; j<n+k; j++){
                if(v[i][j] != color){
                    return false;
                }
            }
        }
        return true;
    }
}