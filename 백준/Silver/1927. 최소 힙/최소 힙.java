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
    static PriorityQueue<Integer> priorityQueueHighest = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Scanner sc = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        for(int i=0; i<m; i++){
            int n= Integer.parseInt(br.readLine());
            if(n==0){
                if(priorityQueueHighest.isEmpty()){
                    stringBuilder.append(0).append("\n");
                }
                else{
                    stringBuilder.append(priorityQueueHighest.poll()).append("\n");
                }
            }
            else{
                priorityQueueHighest.add(n);
            }
        }
        System.out.println(stringBuilder);
    }
}