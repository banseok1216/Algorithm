import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.util.*;
import java.lang.*;


class Node implements Comparable<Node>{
    int size,x,y,r;
    public Node(int size,int x,int y,int r){
        this.size = size;
        this.r = r;
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
    static boolean[][] visited;
    static String[] result;
    static int[][] v;
    static int check;
    static String K = "YES";
    static int R = Integer.MAX_VALUE;
    static int p = 0;
    static int q = 0;
    static int m;
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
    static PriorityQueue<Integer> queue3 = new PriorityQueue<Integer>();
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
        m = Integer.parseInt(br.readLine());
        v = new int[m][m];
        int startx=0;
        int starty=0;
        for (int i = 0; i < m; i++) {
            String[] str1 = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                v[i][j] = Integer.parseInt(str1[j]);
                if(Integer.parseInt(str1[j]) ==9){
                    startx =i;
                    starty =j;
                }
            }
        }
        count =0;
        check = 0;
        bfs(2,startx,starty);
        System.out.println(check);

    }
    private static void bfs(int size,int startx, int starty){
        visited=new boolean[m][m];
        queue2 = new PriorityQueue<Node>();
        queue2.add(new Node(size,startx,starty,0));
        list2 = new int[]{-1,1,0,0};
        list3 = new int[]{0,0,-1,1};
        while(!queue2.isEmpty()){
            Node o = queue2.poll();
            if(v[o.x][o.y] < o.size && v[o.x][o.y]!=0){
                while(!queue2.isEmpty() && queue2.peek().r == o.r){
                    Node w  = queue2.poll();
                    if(v[w.x][w.y] < o.size&& v[w.x][w.y]!=0 ){
                        if(w.x < o.x ||  (o.x == w.x && o.y>w.y)){
                            o = w;
                        }
                    }
                }
                v[o.x][o.y] = 9;
                v[startx][starty] =0;
                count++;
                check += o.r;
                if(count== o.size){
                    count=0;
                    o.size++;
                    bfs((int) Math.max(o.size,count),o.x,o.y);
                }
                else {
                    bfs((int) Math.max(o.size, count), o.x, o.y);
                }
                break;
            }
            if(!visited[o.x][o.y]) {
                visited[o.x][o.y] = true;
                for (int i = 0; i < 4; i++) {
                    int nx = o.x + list2[i];
                    int ny = o.y + list3[i];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < m && v[nx][ny] <= o.size) {
                        queue2.offer(new Node(o.size, nx, ny, o.r + 1));
                    }
                }
            }
        }
    }
}