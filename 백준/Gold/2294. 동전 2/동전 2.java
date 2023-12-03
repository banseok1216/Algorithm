import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.util.*;
import java.lang.*;


class Node implements Comparable<Node>{
    int i,w,r;
    public Node(int i,int w,int r){
        this.r = r;
        this.i = i;
        this.w = w;
    }

    @Override
    public int compareTo(Node o) {
        return o.r-this.r;
    }
}
public class Main {
    static StringBuilder stringBuilder = new StringBuilder();
    static int[][] treeArray_1;
    static int[][] treeArray_2;
    static int[] abc;
    static int max = 0;
    static int min = Integer.MAX_VALUE;
    static boolean[][] visited;
    static String[] result;
    static int[][] v;
    static boolean[] check;
    static String K = "YES";
    static int R = Integer.MAX_VALUE;
    static int p = 0;
    static int q = 0;
    static ArrayList<Node> person;
    static ArrayList<Node> chicken;
    static LinkedList<Integer> list1 = new LinkedList<>();
    static Deque<Integer> deque1 = new ArrayDeque<Integer>();
    static Deque<Integer> deque2 = new ArrayDeque<Integer>();
    static int[] list2;
    static int[] list3;
    static int[][] list4;
    static Stack<String> stack = new Stack<>();
    static Stack<String> stack1 = new Stack<>();
    static Queue<ArrayList<String>> queue1 = new LinkedList<ArrayList<String>>();
    static Queue<Node> queue2 = new LinkedList<Node>();
    static HashSet<Integer> ok = new HashSet<>();
    static ArrayList<ArrayList<Node>> graph;
    static ArrayList<String> list = new ArrayList<>();
    static ArrayList<String> strings = new ArrayList<>();
    static String[] stringlist;
    static int[] second;
    static long count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Node> priorityQueue1 = new PriorityQueue<>();
        PriorityQueue<Integer> priorityQueue2 = new PriorityQueue<>();
        Queue<Node> priorityQueue3 = new LinkedList<>();
        String[] end = br.readLine().split(" ");
        int m = Integer.parseInt(end[0]);
        q = Integer.parseInt(end[1]);
        list3 = new int[100002];
        list2= new int[m];
        for(int i=0; i<list3.length; i++){
            list3[i] = Integer.MAX_VALUE/5;
        }
        for(int i=0; i<m; i++){
            int k = Integer.parseInt(br.readLine());
            list2[i] = k;
            queue2.offer(new Node(k,k,1));
        }
        bfs();
        if(list3[q]>= Integer.MAX_VALUE/5){
            System.out.println(-1);
        }
        else {
            System.out.println(list3[q]);
        }
    }
    private static void bfs(){
        while(!queue2.isEmpty()){
            Node o = queue2.poll();
            if(o.w == q){
                list3[o.w] = o.r;
                break;
            }
            if(list3[o.w]>o.r) {
                list3[o.w] = o.r;
                for (int i = 0; i < list2.length; i++) {
                    if (list2[i] + o.w<= 100001 && list3[list2[i] + o.w] > o.r + 1) {
                        queue2.offer(new Node(list2[i], list2[i] + o.w, o.r + 1));
                    }
                }
            }
        }
    }
}