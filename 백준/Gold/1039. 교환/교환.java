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
    public Node1(int x,int y,int r){
        this.x = x;
        this.r = r;
        this.y = y;
    }
}
public class Main {
    static StringBuilder stringBuilder = new StringBuilder();
    static int[] abc;
    static int max = -1;
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
    static ArrayList<int[]> list1 = new ArrayList<>();
    static Deque<Integer> deque1 = new ArrayDeque<Integer>();
    static Deque<Integer> deque2 = new ArrayDeque<Integer>();
    static String[] list2;
    static int[] list3;
    static int[][] list4;
    static Stack<Integer> stack = new Stack<>();
    static Queue<Integer> queue1 = new LinkedList<>();
    static Queue<Integer> queue2 = new LinkedList<>();
    static HashSet<Integer> ok = new HashSet<>();
    static ArrayList<Node1> graph;
    static ArrayList<int[]> list = new ArrayList<>();
    static ArrayList<String> strings = new ArrayList<>();
    static String[] stringlist;
    static int[] second;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Scanner sc = new Scanner(System.in);
        String[] str1 = br.readLine().split(" ");
        p=str1[0].length();
        int m=Integer.parseInt(str1[0]);
        int n= Integer.parseInt(str1[1]);
        visited = new boolean[1000001][n+1];
        bfs(m,n);
        System.out.println(max);

    }
    private static void bfs(int start, int index){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start,0});
        while(!q.isEmpty()){
            int[] n = q.poll();
            if(n[1] == index&& max<n[0]){
                max = Math.max(n[0],max);
            }
            if(n[1]<index) {
                String str = String.valueOf(n[0]);
                for (int i = 0; i < str.length(); i++) {
                    for (int j = i + 1; j < str.length(); j++) {
                        int l = str.charAt(i) - '0';
                        int k = str.charAt(j) - '0';
                        int m = n[0];
                        m=m-(int)(Math.pow(10,(str.length()-i-1)) * l);
                        m=m+(int)(Math.pow(10,(str.length()-i-1)) * k);
                        m=m-(int)(Math.pow(10,(str.length()-j-1)) * k);
                        m=m+(int)(Math.pow(10,(str.length()-j-1)) * l);
                        if(!visited[m][n[1]+1] && m>=Math.pow(10,str.length()-1)) {
                            q.offer(new int[]{m, n[1] + 1});
                            visited[m][n[1] + 1] = true;
                        }
                    }
                }
            }
        }
    }
}