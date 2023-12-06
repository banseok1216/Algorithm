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
    static ArrayList<ArrayList<Integer>> graph;
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
        m = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());
        v=new int[1002][1002];
        for(int i=0; i<n; i++){
            String[] str1 = br.readLine().split(" ");
            list.add(new int[]{Integer.parseInt(str1[0]),Integer.parseInt(str1[1])});
        }
        int answer = dfs(0,0,1,1,m,m,0);
        System.out.println(answer);
        int index_one=0;
        int index_two=0;
        for(int index=1;index<=n;index++){
            int x_start;
            int y_start;
            if(index_one==0) {
                x_start = y_start = 1;
            }
            else {
                x_start = list.get(index_one - 1)[0];
                y_start = list.get(index_one - 1)[1];
            }
            int x_end = list.get(index - 1)[0], y_end = list.get(index - 1)[1];
            int one_remain = Math.abs(x_start-x_end)+Math.abs(y_start-y_end);
            if(v[index_one][index_two]-one_remain==v[index][index_two]){
                index_one=index;
                stringBuilder.append("1\n");
            }else{
                index_two=index;
                stringBuilder.append("2\n");
            }
        }
        System.out.println(stringBuilder);
    }
    private static int dfs(int v1, int v2,int x1, int y1, int x2,int y2 ,int index){
        if(index == n){
            return 0;
        }
        if (v[v1][v2] != 0) {
            return v[v1][v2];
        }
        int[] list1 = list.get(index);
        int movex = list1[0];
        int movey = list1[1];
        int distance1 = Math.abs(movex - x1) + Math.abs(movey - y1);
        int s = dfs(index+1,v2,movex, movey, x2, y2, index + 1) + distance1;
        movex = list1[0];
        movey = list1[1];
        int distance2 = Math.abs(movex - x2) + Math.abs(movey - y2);
        int y = dfs(v1,index+1,x1, y1, movex, movey, index + 1) +distance2;
        v[v1][v2] = Math.min(s, y);
        return v[v1][v2];
    }
}