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
    public int compareTo(Node o) {
        return o.w - this.w;
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
    static Queue<Integer> queue2 = new LinkedList<Integer>();
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
        String end = br.readLine();
        int m = Integer.parseInt(end);
        int n = Integer.parseInt(br.readLine());
        if(n!=0) {
            result = br.readLine().split(" ");
            list2 = new int[10];
            R= 10 -result.length;
            for(int i=0; i<result.length; i++){
                list2[Integer.parseInt(result[i])] = -1;
            }

            list3 = new int[10];
            for(int i=0; i<list3.length;i++){
                list3[i] = -1;
            }
            min = Math.abs(m - 100);
            dfs(0,end);
            System.out.println(min);
        }
        if(n==0){
            list2 = new int[10];
            R= 10;
            list3 = new int[10];
            for(int i=0; i<list3.length;i++){
                list3[i] = -1;
            }
            min = Math.abs(m - 100);
            dfs(0,end);
            System.out.println(min);
        }
    }
    private static void dfs(int index, String end){
        if(index == end.length()+2){
            return;
        }
        count =0;
        if(index >= end.length()-1){
            String s ="";
            for(int i=0; i<list3.length; i++){
                if(list3[i] !=-1) {
                    s += String.valueOf(list3[i]);
                    count++;
                }
            }
            if(!s.equals("")) {
                min = (int) Math.min(Math.abs(Integer.parseInt(end) - Integer.parseInt(s)) + count, min);
            }
        }

        for(int i=0; i<10; i++){
            if(list2[i] != -1) {
                list3[index] = i;
                dfs(index+1,end);
                list3[index] = -1;
            }
        }
    }
}