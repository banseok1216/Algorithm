import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.util.*;
import java.lang.*;


class Node implements Comparable<Node>{
    int Rx,Ry,Bx,By,r,x,y;
    public Node(int y,int r){
        this.r = r;
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
    static boolean abc;
    static int max = 0;
    static int min = Integer.MAX_VALUE;
    static boolean[][] visited;
    static String[] result;
    static int[][] v;
    static long check=0;
    static String K = "YES";
    static int R = Integer.MAX_VALUE;
    static int p = 0;
    static int q = 0;
    static int m;
    static int n;
    static int[] list2;
    static int[] list3;
    static int[][] list4;
    static Stack<long[]> stack = new Stack<>();
    static Stack<String> stack1 = new Stack<>();
    static Queue<ArrayList<String>> queue1 = new LinkedList<ArrayList<String>>();
    static Queue<Node> queue = new LinkedList<>();
    static PriorityQueue<Node> queue3 = new PriorityQueue<Node>();
    static HashSet<Integer> ok = new HashSet<>();
    static ArrayList<ArrayList<Node>> graph;
    static ArrayList<int[]> list = new ArrayList<>();
    static ArrayList<String> strings = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Scanner sc = new Scanner(System.in);
        String[] str1 = br.readLine().split(" ");
        int x1 = Integer.parseInt(str1[0]);
        int y1 = Integer.parseInt(str1[1]);
        int x2 = Integer.parseInt(str1[2]);
        int y2 = Integer.parseInt(str1[3]);
        v= new int[x2-x1+1][y2-y1+1];
        int max = 0;
        for(int i=x1; i<=x2; i++){
            for(int j=y1; j<=y2; j++){
                v[i-x1][j-y1] = calculate(i, j);
                max = Math.max(max, v[i-x1][j-y1]);
            }
        }
        int big=0;
        for(int i=0; i<=x2-x1; i++){
            for(int j=0; j<=y2-y1; j++){
                big = Math.max(big,v[i][j]);
            }
        }
        StringBuilder formatter = new StringBuilder("%");
        formatter.append(String.valueOf(max).length());
        formatter.append("d ");

        for(int i=0; i<=x2-x1; i++) {
            for (int j = 0; j <= y2 - y1; j++) {
                System.out.printf(formatter.toString(), v[i][j]);
            }
            System.out.println();
        }
    }
    static int calculate(int row, int column) {
        int border = Math.max(Math.abs(row), Math.abs(column));
        int min = (int) Math.pow(2 * border - 1, 2) + 1;

        if (row == border) {
            return min + 7 * border - 1 + column;
        }

        if (column == -border) {
            return min + 5 * border - 1 + row;
        }

        if (row == -border) {
            return min + 3 * border - 1 - column;
        }

        return min + border - 1 - row;
    }
}