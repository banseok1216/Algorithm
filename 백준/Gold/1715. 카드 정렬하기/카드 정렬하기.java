import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.util.*;
import java.lang.*;


class Node {
    int i,w;
    public Node(int i,int w){
        this.i = i;
        this.w = w;
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
    static ArrayList<Node> person;
    static ArrayList<Node> chicken;
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
    static ArrayList<String> list = new ArrayList<>();
    static ArrayList<String> strings = new ArrayList<>();
    static String[] stringlist;
    static int[] second;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int m = Integer.parseInt(br.readLine());
        for(int i=0; i<m; i++) {
            int n = Integer.parseInt(br.readLine());
            priorityQueue.offer(n);
        }
        count=0;
        while(!priorityQueue.isEmpty()){
            int k = priorityQueue.poll();
            if(priorityQueue.isEmpty()){
                break;
            }
            else {
                int h = priorityQueue.poll();
                int result = k + h;
                priorityQueue.offer(result);
                count += result;
            }
        }
        System.out.println(count);
    }
}