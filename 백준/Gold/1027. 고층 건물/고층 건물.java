import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.util.*;
import java.lang.*;


class Node implements Comparable<Node>{
    int Rx,Ry,Bx,By,r,x,y;
    public Node(int y,int r){
        this.r = r;
        this.y = y;
    }

    @Override
    public int compareTo(Node o) {
        return this.r-o.r;
    }
}
public class Main {
    static StringBuilder stringBuilder = new StringBuilder();
    static int[][] treeArray_1;
    static int[][] treeArray_2;
    static boolean abc;
    static int max = 0;
    static int min = Integer.MAX_VALUE;
    static boolean[][] visited;
    static String[] result;
    static int[][] v;
    static long check=0;
    static String K = "YES";
    static int R = Integer.MAX_VALUE;
    static float p = 0;
    static int q = 0;
    static int m;
    static int n;
    static int[] list2;
    static int[] list3;
    static int[][] list4;
    static Stack<long[]> stack = new Stack<>();
    static Stack<String> stack1 = new Stack<>();
    static Queue<ArrayList<String>> queue1 = new LinkedList<ArrayList<String>>();
    static Queue<Node> queue = new LinkedList<>();
    static PriorityQueue<Node> queue3 = new PriorityQueue<Node>();
    static HashSet<Integer> ok = new HashSet<>();
    static ArrayList<ArrayList<Node>> graph;
    static ArrayList<int[]> list = new ArrayList<>();
    static ArrayList<String> strings = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Scanner sc = new Scanner(System.in);
        m = Integer.parseInt(br.readLine());
        Long[] list = new Long[m];
        String[] str1 = br.readLine().split(" ");
        for(int i=0; i<m; i++){
            list[i] = Long.parseLong(str1[i]);
        }
        for(int i=0; i<m; i++){
            int count=0;
            p=Long.MIN_VALUE;
            for(int j=i+1; j<m; j++){
                if((float)(list[j]-list[i])/Math.abs(i-j) > p){
                    p=(float)(list[j]-list[i])/Math.abs(i-j);
                    count++;
                }
            }
            p=Long.MAX_VALUE;
            for(int j=i-1; j>=0; j--){
                if((float)(list[i]-list[j])/Math.abs(i-j) < p){
                    p=(float)(list[i]-list[j])/Math.abs(i-j);
                    count++;
                }
            }
            max= Math.max(count,max);
        }
        System.out.println(max);
    }
}