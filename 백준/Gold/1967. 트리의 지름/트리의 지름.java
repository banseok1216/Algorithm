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
    int x,y;
    public Node1(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static StringBuilder stringBuilder = new StringBuilder();
    static int[][] treeArray_1;
    static int[][] treeArray_2;
    static int[] abc;
    static int max = 0;
    static int min = Integer.MAX_VALUE;
    static boolean[] visited;
    static String[] result;
    static String[][] v;
    static int check;
    static String K = "YES";
    static int R = Integer.MIN_VALUE;
    static int p = 0;
    static int q = 0;
    static int m;
    static int n;
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
        int m = Integer.parseInt(br.readLine());
        visited = new boolean[m+1];
        for(int i=0; i<m+1; i++){
            list.add(new ArrayList<>());
        }
        for(int i=0; i<m-1; i++){
            String[] str1 = br.readLine().split(" ");
            list.get(Integer.parseInt(str1[0])).add(new Node1(Integer.parseInt(str1[1]), Integer.parseInt(str1[2])));
            list.get(Integer.parseInt(str1[1])).add(new Node1(Integer.parseInt(str1[0]), Integer.parseInt(str1[2])));
        }
        for(int i=1; i<=m; i++){
            visited[i] = true;
            dfs(i);
            visited = new boolean[m+1];
            R = Math.max(R,max);
            max = Integer.MIN_VALUE;
        }
        System.out.println(R);
    }
    private static void dfs(int m){
        if(list.get(m).size() == 0){
            return;
        }
        for(int i=0; i<list.get(m).size();i++){
            visited[m] = true;
            if(!visited[list.get(m).get(i).x]){
                Node1  o = list.get(m).get(i);
                count += o.y;
                max = (int) Math.max(count,max);
                dfs(o.x);
                visited[m] = false;
                count -= o.y;
            }
        }
    }
}