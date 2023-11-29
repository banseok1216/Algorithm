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
    static int[][] treeArray_1;
    static int[][] treeArray_2;
    static int[] abc;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static boolean[] visited;
    static int[][] v;
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
        int m = Integer.parseInt(str1[0]);
        long n = Long.parseLong(str1[1]);
        v=new int[m][m];
        for(int i=0; i<m; i++){
            String[] str2= br.readLine().split(" ");
            for(int j=0; j<m; j++){
                v[i][j] = Integer.parseInt(str2[j]);
            }
        }
        treeArray_1 = new int[m][m];
        treeArray_1= partition(m,n);
        for (int i=0; i<m; i++){
            for(int j=0; j<m; j++){
                String a = String.valueOf(treeArray_1[i][j]%1000);
                stringBuilder.append(a).append(" ");
            }
            if(i!=m-1) {
                stringBuilder.append("\n");
            }
        }
        System.out.println(stringBuilder);
    }
    private static int[][] partition(int m,long n){
        if(n==1){
            for(int i=0; i<m; i++){
                for(int j=0; j<m; j++){
                        treeArray_1[i][j] = v[i][j]%1000;
                }
            }
            return treeArray_1;
        }
        else{
            treeArray_2 = new int[m][m];
            treeArray_1 = partition(m,n/2);
            for(int i=0; i<m; i++){
                for(int j=0; j<m; j++){
                    treeArray_2[i][j] = treeArray_1[i][j]%1000;
                }
            }
            treeArray_1=new int[m][m];
            if(n%2 == 0) {
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < m; j++) {
                        for (int k = 0; k < m; k++) {
                            long p = (long) treeArray_2[i][k] * treeArray_2[k][j];
                            treeArray_1[i][j] += (p%1000);
                        }
                    }
                }
            }
            else{
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < m; j++) {
                        for (int k = 0; k < m; k++) {
                            long p = (long) treeArray_2[i][k] * treeArray_2[k][j];
                            treeArray_1[i][j] += (p%1000);
                        }
                    }
                }
                treeArray_2 = new int[m][m];
                for(int i=0; i<m; i++){
                    for(int j=0; j<m; j++){
                        treeArray_2[i][j] = treeArray_1[i][j]%1000;
                    }
                }
                treeArray_1=new int[m][m];
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < m; j++) {
                        for (int k = 0; k < m; k++) {
                            long p = (long) treeArray_2[i][k] * v[k][j];
                            treeArray_1[i][j] += (p%1000);
                        }
                    }
                }
            }
            return treeArray_1;
        }
    }
}