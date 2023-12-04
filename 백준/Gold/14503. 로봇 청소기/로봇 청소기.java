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
    static int[][] treeArray_1;
    static int[][] treeArray_2;
    static int[] abc;
    static int max = 0;
    static int min = Integer.MAX_VALUE;
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
        String[] str1 = br.readLine().split(" ");
        m = Integer.parseInt(str1[0]);
        n = Integer.parseInt(str1[1]);
        String[] str2 = br.readLine().split(" ");
        v=new int[m][n];
        for(int i=0; i<m; i++){
            String[] str3 = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                v[i][j] = Integer.parseInt(str3[j]);
            }
        }
        count=0;
        bfs(Integer.parseInt(str2[0]),Integer.parseInt(str2[1]),Integer.parseInt(str2[2]));
        for(int i=0 ; i<m; i++){
            for(int j=0; j<n; j++){
                if(visited[i][j]){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
    private static void bfs(int x, int y, int r){
        int[][] list1 = new int[][]{{0,1,0,-1},{-1,0,1,0},{0,-1,0,1},{1,0,-1,0}};
        int[][] list2 = new int[][]{{-1,0,1,0},{0,-1,0,1},{1,-0,-1,0},{0,1,0,-1}};
        Queue<Node1> q= new LinkedList<Node1>();
        visited = new boolean[m][n];
        q.offer(new Node1(x,y,r));
        while (!q.isEmpty()){
            Node1 node = q.poll();
                int nx;
                int ny;
                boolean go = false;
                visited[node.x][node.y] = true;
                r = node.r;
                for(int i=0 ;i<4; i++){
                    nx = list1[node.r][i] + node.x;
                    ny = list2[node.r][i] + node.y;
                    r = (r+3) %4;
                    if(nx>=0 && ny>=0 && nx<m && ny<n && !visited[nx][ny]&& v[nx][ny] != 1){
                        go = true;
                        q.offer(new Node1(nx,ny,r));
                        break;
                    }
                }
                if(!go) {
                    nx = list1[((node.r + 2)%4)][3] + node.x;
                    ny = list2[(node.r + 2)%4][3] + node.y;
                    if (v[nx][ny] != 1) {
                        q.offer(new Node1(nx, ny, node.r));
                    }
                }

                go = false;
            }
    }
}