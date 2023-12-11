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
public class Main {
    static StringBuilder stringBuilder = new StringBuilder();
    static int[][] treeArray_1;
    static int[][] treeArray_2;
    static int[] abc;
    static int max = 0;
    static int min = Integer.MAX_VALUE;
    static boolean[] visited;
    static String[] result;
    static int[][] v;
    static int check=1;
    static String K = "YES";
    static int R = Integer.MAX_VALUE;
    static int p = 0;
    static int q = 0;
    static int m;
    static int n;
    static int[] list2;
    static int[] list3;
    static int[][] list4;
    static Stack<String> stack = new Stack<>();
    static Stack<String> stack1 = new Stack<>();
    static Queue<ArrayList<String>> queue1 = new LinkedList<ArrayList<String>>();
    static Queue<Integer> queue = new LinkedList<>();
    static PriorityQueue<Node> queue3 = new PriorityQueue<Node>();
    static HashSet<Integer> ok = new HashSet<>();
    static ArrayList<ArrayList<Node>> graph;
    static ArrayList<Integer> list = new ArrayList<>();
    static ArrayList<String> strings = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Node> priorityQueue1 = new PriorityQueue<>();
        PriorityQueue<Integer> priorityQueue2 = new PriorityQueue<>();
        Queue<Node> priorityQueue3 = new LinkedList<>();
        m = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        for(int i=0; i<m; i++){
            list.add(Integer.parseInt(str[i]));
        }
        Collections.sort(list);
        max=1;
        for(int i=0; i<list.size(); i++) {
            if(check < list.get(i))
                break;
            check += list.get(i);
        }
        System.out.println(check);
    }
}