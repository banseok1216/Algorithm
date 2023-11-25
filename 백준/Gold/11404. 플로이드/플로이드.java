import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    static StringBuilder stringBuilder = new StringBuilder();
    static int[] treeArray_1;
    static int[] treeArray_2;
    static int[] abc;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[][][] visited;
    static int[][] v;
    static boolean checkBipartite;
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
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Scanner sc = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        v= new int[m+1][m+1];
        for(int i=0; i<n; i++){
            String str1[] = br.readLine().split(" ");
            if(v[Integer.parseInt(str1[0])][Integer.parseInt(str1[1])] != 0){
                v[Integer.parseInt(str1[0])][Integer.parseInt(str1[1])] = Math.min(v[Integer.parseInt(str1[0])][Integer.parseInt(str1[1])], Integer.parseInt(str1[2]));
            }
            else {
                v[Integer.parseInt(str1[0])][Integer.parseInt(str1[1])] = Integer.parseInt(str1[2]);
            }
        }
        for(int i=1; i<m+1; i++){
            for(int j=1; j<m+1; j++){
                if(i != j && v[i][j]==0 ){
                    v[i][j] = 10000000;
                }
            }
        }
        for (int k = 1; k < m+1; k++){
            for(int i=1; i<m+1; i++){
                for(int j=1;j<m+1; j++){
                    v[i][j] = Math.min(v[i][j], v[i][k] + v[k][j]);
                }
            }
        }
        for(int i=0 ;i<m; i++){
            for(int j=0; j<m; j++){
                if(v[i+1][j+1] >= 10000000){
                    stringBuilder.append(0).append(" ");
                }
                else {
                    stringBuilder.append(v[i + 1][j + 1]).append(" ");
                }
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
    }
}