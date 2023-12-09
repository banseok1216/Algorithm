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
    static boolean[][] visited;
    static String[] result;
    static String[][] v;
    static int check;
    static String K = "YES";
    static int R = Integer.MAX_VALUE;
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
        String[] str = br.readLine().split(" ");
        m = Integer.parseInt(str[0]);
        n = Integer.parseInt(str[1]);
        v = new String[m][n];
        int startRx = 0;
        int startRy = 0;
        int startBx = 0;
        int startBy = 0;

        for (int i = 0; i < m; i++) {
            String[] str1 = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                v[i][j] = str1[j];
                if (str1[j].equals("R")) {
                    startRx = i;
                    startRy = j;
                    v[i][j] = ".";
                }
                if (str1[j].equals("B")) {
                    startBx = i;
                    startBy = j;
                    v[i][j] = ".";
                }
            }

        }
        bfs(startRx, startRy, startBx, startBy);
        if (min > 10) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    }

    private static void bfs(int startRx, int startRy, int startBx, int startBy) {
        list2 = new int[]{1, -1, 0, 0};
        list3 = new int[]{0, 0, -1, 1};
        queue2.offer(new Node(startRx, startRy, startBx, startBy, 0, 0, 0));
        while (!queue2.isEmpty()) {
            Node o = queue2.poll();
            if(o.r > 10){
                break;
            }
            if (v[o.Rx][o.Ry].equals("O")) {
                if(dfs(o)){
                    continue;
                }
                else{
                    min = Math.min(min, o.r);
                    break;
                }
            }
            else {
                int redx = o.Rx + o.x;
                int redy = o.Ry + o.y;
                int bluex = o.Bx + o.x;
                int bluey = o.By + o.y;
                if (o.r == 0 || v[redx][redy].equals("#") && v[bluex][bluey].equals("#") ||
                        (v[redx][redy].equals("#") && !v[bluex][bluey].equals("#") && (bluex == o.Rx && bluey == o.Ry))
                        || (!v[redx][redy].equals("#") && v[bluex][bluey].equals("#") && (redx == o.Bx && redy == o.By))) {
                    for(int i=0; i<4; i++) {
                        if((list2[i] != o.x || list3[i] != o.y) && (list2[i] != -o.x || list3[i] != -o.y)) {
                            redx = o.Rx + list2[i];
                            redy = o.Ry + list3[i];
                            bluex = o.Bx + list2[i];
                            bluey = o.By + list3[i];
                            if ((v[redx][redy].equals("#") && v[bluex][bluey].equals("#") ||
                                    (v[redx][redy].equals("#") && !v[bluex][bluey].equals("#") && (bluex == o.Rx && bluey == o.Ry))
                                    || (!v[redx][redy].equals("#") && v[bluex][bluey].equals("#") && (redx == o.Bx && redy == o.By)))) {
                                continue;
                            }
                            else{
                                if (!v[bluex][bluey].equals("O")) {
                                    queue2.offer(new Node(o.Rx, o.Ry, o.Bx, o.By, o.r + 1, list2[i], list3[i]));
                                }
                            }
                        }
                    }
                }
                else {
                    redx = o.Rx;
                    redy = o.Ry;
                    bluex = o.Bx;
                    bluey = o.By;
                    while (!(v[redx][redy].equals("#") && v[bluex][bluey].equals("#"))) {
                        if (v[redx][redy].equals("#") && !v[bluex][bluey].equals("#")) {
                            if (v[bluex][bluey].equals("O")) {
                                break;
                            }
                            if (bluex+o.x == redx && bluey+o.y == redy) {
                                break;
                            }
                            bluex += o.x;
                            bluey += o.y;
                        } else if (v[bluex][bluey].equals("#") && !v[redx][redy].equals("#")) {
                            if (v[bluex][bluey].equals("O")) {
                                break;
                            }
                            if (bluex == redx+o.x && bluey == redy+o.y) {
                                break;
                            } else if (v[redx][redy].equals("O")) {
                                break;
                            }
                            redx += o.x;
                            redy += o.y;
                        } else {
                            if (v[bluex][bluey].equals("O")) {
                                break;
                            }
                            if (bluex+o.x == redx+o.x && bluey+o.y == redy+o.y) {
                                break;
                            }else if (v[redx][redy].equals("O")) {
                                break;
                            }
                            bluex += o.x;
                            bluey += o.y;
                            redx += o.x;
                            redy += o.y;
                        }
                    }
                    if(!v[bluex][bluey].equals("O"))
                    {
                        if(v[redx][redy].equals("O")){
                            queue2.offer(new Node(redx, redy, bluex - o.x, bluey - o.y, o.r, o.x, o.y));
                        }
                        else {
                            queue2.offer(new Node(redx - o.x, redy - o.y, bluex - o.x, bluey - o.y, o.r, o.x, o.y));
                        }
                    }
                }
            }
        }
    }
    private static boolean dfs(Node o) {
        int bluex = o.Bx + o.x;
        int bluey = o.By + o.y;
        while (v[bluex][bluey].equals(".")) {
            bluex = bluex + o.x;
            bluey = bluey + o.y;
        }
        return v[bluex][bluey].equals("O");
    }
}