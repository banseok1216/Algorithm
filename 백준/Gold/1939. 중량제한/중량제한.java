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
    public Node1(int x,int r){
        this.x = x;
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
    static boolean[] visited;
    static String[] result;
    static int[] v;
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
        String[] str1 = br.readLine().split(" ");
        m = Integer.parseInt(str1[0]);
        n= Integer.parseInt(str1[1]);
        for(int i=0; i<m+1; i++){
            list.add(new ArrayList<>());
        }
        int left =0;
        int right =0;
        for (int i = 0; i < n; i++) {
            String[] str2 = br.readLine().split(" ");
            list.get(Integer.parseInt(str2[0])).add(new Node1(Integer.parseInt(str2[1]),Integer.parseInt(str2[2])));
            list.get(Integer.parseInt(str2[1])).add(new Node1(Integer.parseInt(str2[0]),Integer.parseInt(str2[2])));
            right = Math.max(right,Integer.parseInt(str2[2]) );
        }
        visited = new boolean[m+1];
        v=new int[m+1];
        for(int i=1; i<m+1; i++){
            v[i] = Integer.MAX_VALUE;
        }
        String[] str3 = br.readLine().split(" ");
        while (left <= right) {
            int mid = (left+right)/2;
            visited = new boolean[m+1];
            if (bfs(Integer.parseInt(str3[0]),Integer.parseInt(str3[1]),mid)) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        System.out.println(right);
    }
    private static boolean bfs(int start, int end,int mid){
        Queue<Node1> q=new LinkedList<>();
        q.offer(new Node1(start,0));
        visited[start] = true;
        while (!q.isEmpty()){
            Node1 node = q.poll();
            if(node.x == end){
                return true;
            }
            for (int i = 0; i < list.get(node.x).size(); i++) {
                if(!visited[list.get(node.x).get(i).x] && mid<=list.get(node.x).get(i).r) {
                    visited[list.get(node.x).get(i).x] = true;
                    q.offer(new Node1(list.get(node.x).get(i).x, node.r));
                }
            }
        }
        return false;
    }
}