import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.util.*;
import java.lang.*;


class Node implements Comparable<Node>{
    int Rx,Ry,Bx,By,r,x,y;
    public Node(int x, int y,int r){
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
    static int check=0;
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
    static Queue<Node> queue = new LinkedList<>();
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
        v= new int[m][m];
        visited = new boolean[m][m];
        for(int i=0; i<m; i++){
            String[] str1 = br.readLine().split(" ");
            for(int j=0; j<m; j++){
                v[i][j] = Integer.parseInt(str1[j]);
            }
        }
        graph = new ArrayList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<m; j++){
                if(!visited[i][j]&& v[i][j] == 1){
                    bfs(i,j);
                }
            }
        }
        System.out.println(min);
    }
    private static void bfs(int x, int y){
        int[] list1 = new int[]{0,0,-1,1};
        int[] list2 = new int[]{-1,1,0,0};
        boolean[][] listk = new boolean[m][m];
        queue3 = new PriorityQueue<>();
        queue3.add(new Node(x,y,0));
        visited[x][y] = true;
        while(!queue3.isEmpty()){
            Node node = queue3.poll();
            if(min>node.r) {
                for (int i = 0; i < 4; i++) {
                    int nx = list1[i] + node.x;
                    int ny = list2[i] + node.y;
                    if (nx >= 0 && ny >= 0 && nx < m && ny < m && !visited[nx][ny] && !listk[nx][ny]) {
                        if (v[nx][ny] == 0) {
                               listk[nx][ny] = true;
                            Node list5 = new Node(nx, ny, node.r + 1);
                            queue3.add(list5);
                        } else {
                            if (node.r == 0) {
                                visited[nx][ny] = true;
                                listk[nx][ny] = true;
                                queue3.add(new Node(nx, ny, node.r));
                            } else {
                                min = Math.min(node.r, min);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
}