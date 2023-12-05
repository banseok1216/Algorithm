import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.util.*;
import java.lang.*;


class Node implements Comparable<Node>{
    int Rx,Ry,Bx,By,r,x,y;
    public Node(int Rx,int Ry,int Bx,int By,int r,int x, int y){
        this.r = r;
        this.Rx = Rx;
        this.Ry = Ry;
        this.Bx = Bx;
        this.By = By;
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(Node o) {
        return this.r-o.r;
    }
}
class Node1 {
    int x,y,r;
    public Node1(int x, int y,int r){
        this.x = x;
        this.y = y;
        this.r = r;
    }
}
public class Main {
    static StringBuilder stringBuilder = new StringBuilder();
    static int[] treeArray_1;
    static int[] treeArray_2;
    static int[] abc;
    static int max = 0;
    static long min = Long.MAX_VALUE;
    static boolean[][] visited;
    static String[] result;
    static int[][] v;
    static int check;
    static String K = "YES";
    static int R = Integer.MIN_VALUE;
    static int p = 0;
    static int q = 0;
    static int m;
    static int n;
    static ArrayList<Node> person;
    static ArrayList<Node> chicken;
    static ArrayList<int[]> list1 = new ArrayList<>();
    static Deque<Integer> deque1 = new ArrayDeque<Integer>();
    static Deque<Integer> deque2 = new ArrayDeque<Integer>();
    static String[] list2;
    static int[] list3;
    static int[][] list4;
    static Stack<String> stack = new Stack<>();
    static Stack<String> stack1 = new Stack<>();
    static Queue<ArrayList<String>> queue1 = new LinkedList<ArrayList<String>>();
    static PriorityQueue<Node> queue2 = new PriorityQueue<Node>();
    static PriorityQueue<Node> queue3 = new PriorityQueue<Node>();
    static HashSet<Integer> ok = new HashSet<>();
    static ArrayList<ArrayList<Node>> graph;
    static ArrayList<ArrayList<Node1>> list = new ArrayList<>();
    static ArrayList<String> strings = new ArrayList<>();
    static String[] stringlist;
    static int[] second;
    static long count=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Scanner sc = new Scanner(System.in);
        m = Integer.parseInt(br.readLine());
        String[] str1 = br.readLine().split(" ");
        int[] list = new int[m];
        Integer[] list2= new Integer[m];
        for (int i = 0; i < m; i++) {
            list2[i] = Integer.parseInt(str1[i]);
            list[i] = Integer.parseInt(str1[i]);
        }
        Arrays.sort(list);
        Arrays.sort(list2, Collections.reverseOrder());
        int k = 0;
        int l = 0;
        int[] list3 = new int[2];
        while(k+l != m-1){
            if(min>Math.abs(list[k]+list2[l])){
                min = Math.abs(Math.abs(list[k]+list2[l]));
                list3[0] = list[k];
                list3[1] = list2[l];
            }
            if(list[k]+list2[l] >= 0){
                l++;
            }
            else{
                k++;
            }
        }
        Arrays.sort(list3);
        System.out.println(list3[0] +" "+list3[1]);

    }
}