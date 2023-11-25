import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    static StringBuilder stringBuilder = new StringBuilder();
    static int[] treeArray_1;
    static int[] treeArray_2;
    static int[] abc;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[][][] visited;
    static int[][] v;
    static boolean checkBipartite;
    static String K = "YES";
    static int R = 0;
    static int p = 0;
    static int q = 0;
    static LinkedList<int []> Queue = new LinkedList<int[]>();
    static LinkedList<Integer> list = new LinkedList<>();
    static LinkedList<Integer> list1 = new LinkedList<>();
    static Deque<Integer> deque1 = new ArrayDeque<Integer>();
    static Deque<Integer> deque2 = new ArrayDeque<Integer>();
    static int[] list2;
    static Stack<Integer> stack = new Stack<>();
    static Stack<String> stack1 = new Stack<>();
    static Queue<Integer> queue1 = new LinkedList<Integer>();
    static Queue<Integer> queuey = new LinkedList<Integer>();
    static HashSet<Integer> ok = new HashSet<>();
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Scanner sc = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        String str1[] = br.readLine().split(" ");
        p = Integer.parseInt(str1[0]);
        q = Integer.parseInt(str1[1]);
        v  = new int[p][q];
        visited = new int[p][q][2];
        for(int i=0; i<p; i++){
            String[] str2 = br.readLine().split("");
            for(int j=0; j<q; j++){
                visited[i][j][0] = min;
                visited[i][j][1] = min;
                v[i][j] = Integer.parseInt(str2[j]);
            }
        }
        bfs();
        if(Math.min(visited[p-1][q-1][0],visited[p-1][q-1][1]) == Integer.MAX_VALUE){
            System.out.println(-1);
        }
        else {
            System.out.println(Math.min(visited[p - 1][q - 1][0], visited[p - 1][q - 1][1]));
        }
    }
    private static void bfs(){
        visited[0][0][0] =1;
        visited[0][0][1] =1;
        Queue.add(new int[]{0,0,0});
        int[] x = {-1,1,0,0};
        int[] y = {0,0,1,-1};
        while (!Queue.isEmpty()){
            int[] list;
            list = Queue.poll();
            for(int i=0; i<4; i++){
                if(list[0]+x[i]>=0 && list[1]+y[i]>=0 && list[0]+x[i]<=p-1 & list[1] + y[i] <=q-1){
                    if(v[list[0]+x[i]][list[1]+y[i]] == 0 && visited[list[0]+x[i]][list[1]+y[i]][list[2]] > visited[list[0]][list[1]][list[2]]+1){
                        visited[list[0]+x[i]][list[1]+y[i]][list[2]] = visited[list[0]][list[1]][list[2]]+1;
                        Queue.add(new int[]{list[0]+x[i],list[1]+y[i],list[2]});
                    }
                    //벽
                    if(v[list[0]+x[i]][list[1]+y[i]] == 1 && list[2] ==0){
                        visited[list[0]+x[i]][list[1]+y[i]][list[2]+1] = visited[list[0]][list[1]][list[2]]+1;
                        Queue.add(new int[]{list[0]+x[i],list[1]+y[i],list[2]+1});
                    }
                }
            }
        }
    }
}