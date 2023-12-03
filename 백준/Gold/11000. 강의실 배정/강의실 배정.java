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
    static PriorityQueue<Integer> queue2 = new PriorityQueue<Integer>();
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
        int m = Integer.parseInt(br.readLine());
        v = new int[m][2];
        for(int i=0; i<m; i++){
            String[] str1 = br.readLine().split(" ");
            v[i][0] = Integer.parseInt(str1[0]);
            v[i][1] = Integer.parseInt(str1[1]);
        }
        count = 0;
        Arrays.sort(v, Comparator.comparingInt((int[] arr) -> arr[0]).thenComparingInt(arr -> arr[1]));
        for(int i=0; i<v.length; i++){
            if(queue2.isEmpty()){
                queue2.offer(v[i][1]);
            }
            else {
                if (queue2.peek() <= v[i][0]) {
                    queue2.poll();
                    queue2.offer(v[i][1]);
                } else {
                    queue2.offer(v[i][1]);
                }
            }
        }
        count += queue2.size();
        System.out.println(count);
    }
    private static void bfs(){
    }
}