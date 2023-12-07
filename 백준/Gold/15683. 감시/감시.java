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
    static int max = 0;
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
        m = Integer.parseInt(str1[0]);
        n = Integer.parseInt(str1[1]);
        v= new int[m][n];
        graph=new ArrayList<>();
        for(int i=0; i<m; i++){
            String[] str2 = br.readLine().split(" ");
            for(int j=0; j<n;j++){
                if(Integer.parseInt(str2[j]) == 6 ||Integer.parseInt(str2[j]) == 0){
                    v[i][j] = Integer.parseInt(str2[j]);
                }
                else{
                    graph.add(new Node1(i,j,Integer.parseInt(str2[j])));
                    v[i][j] = Integer.parseInt(str2[j]);
                }
            }
        }
        dfs(0,v);
        System.out.println(min);
    }
    private static void dfs(int k,int[][] board){
        if(k==graph.size()){
            count=0;
            for(int i=0;i<m;i++){
                for (int j=0; j<n; j++){
                    if(board[i][j]==0){
                        count++;
                    }
                }
            }
            min = Math.min(count,min);
            return;
        }
            if(graph.get(k).r == 1){
                dfs(k+1,checking(graph.get(k),0,board));
                dfs(k+1,checking(graph.get(k),1,board));
                dfs(k+1,checking(graph.get(k),2,board));
                dfs(k+1,checking(graph.get(k),3,board));
            }
            if(graph.get(k).r == 2){
                dfs(k+1,checking(graph.get(k),0,board));
                dfs(k+1,checking(graph.get(k),1,board));
            }
            if(graph.get(k).r == 3){
                dfs(k+1,checking(graph.get(k),0,board));
                dfs(k+1,checking(graph.get(k),1,board));
                dfs(k+1,checking(graph.get(k),2,board));
                dfs(k+1,checking(graph.get(k),3,board));
            }
            if(graph.get(k).r == 4){
                dfs(k+1,checking(graph.get(k),0,board));
                dfs(k+1,checking(graph.get(k),1,board));
                dfs(k+1,checking(graph.get(k),2,board));
                dfs(k+1,checking(graph.get(k),3,board));
            }
            if(graph.get(k).r == 5){
                dfs(k+1,checking(graph.get(k),0,board));
            }
        }
    private static int[][] checking(Node1 node,int i,int[][] newboard){
        int[][] board = new int[m][n];
        copy(newboard, board);
        int x = node.x;
        int y = node.y;
        int[] list1 = new int[]{0,1,0,-1};
        int[] list2 = new int[]{1,0,-1,0};
        if(node.r==1){
            while(x>=0 && x<m && y<n && y>=0&& v[x][y] != 6){
                board[x][y] = -1;
                x= x+list1[i];
                y= y+list2[i];
            }
        }
        if (node.r == 2) {
            for(int c =i; c<=i+2; c=c+2){
                int t = c%4;
                x = node.x;
                y = node.y;
                while(x>=0 && x<m && y<n && y>=0&& v[x][y] != 6){
                    board[x][y] = -1;
                    x= x+list1[t];
                    y= y+list2[t];
                }
            }
        }
        if (node.r == 3) {
            for(int c =i; c<i+2; c++) {
                int t = c%4;
                x = node.x;
                y = node.y;
                while (x >= 0 && x < m && y < n && y >= 0&& v[x][y] != 6) {
                    board[x][y] = -1;
                    x = x + list1[t];
                    y = y + list2[t];
                }
            }
        }
        if (node.r == 4) {
            for(int c =i; c<i+3; c++) {
                int t = c%4;
                x = node.x;
                y = node.y;
                while (x >= 0 && x < m && y < n && y >= 0&& v[x][y] != 6) {
                    board[x][y] = -1;
                    x = x + list1[t];
                    y = y + list2[t];
                }
            }
        }
        if(node.r ==5){
            for(int c =0; c<4; c++){
                x = node.x;
                y = node.y;
                while (x >= 0 && x < m && y < n && y >= 0 && v[x][y] != 6) {
                    board[x][y] = -1;
                    x = x + list1[c];
                    y = y + list2[c];
                }
            }
        }
        return board;
    }
    private static int[][] copy(int[][] board, int[][] newboard){
        for (int i =0; i<board.length; i++){
            for (int j=0; j<board[0].length; j++){
                newboard[i][j] = board[i][j];
            }
        }
        return newboard;
    }
}