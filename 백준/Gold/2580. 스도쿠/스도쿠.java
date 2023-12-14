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
    static ArrayList<int[]> list = new ArrayList<>();
    static ArrayList<String> strings = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Scanner sc = new Scanner(System.in);
        list = new ArrayList<>();
        list4 = new int[9][9];
        v=new int[9][9];
        for(int i=0; i<9; i++){
            String[] str1 = br.readLine().split(" ");
            for(int j=0; j<9; j++){
                v[i][j] = Integer.parseInt(str1[j]);
                if(Integer.parseInt(str1[j]) == 0){
                    list.add(new int[]{i,j});
                }
            }
        }
        abc= false;
        dfs(0);
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                stringBuilder.append(list4[i][j]).append(" ");
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
    }
    private static void dfs(int index){
        if(index == list.size()){
            for(int i=0; i<9; i++){
                for(int j=0; j<9; j++){
                    list4[i][j] = v[i][j];
                }
            }
            abc = true;
            return;
        }
        if(!abc) {
            for (int i = 1; i <= 9; i++) {
                if (pruning(index, i)) {
                    v[list.get(index)[0]][list.get(index)[1]] = i;
                    dfs(index + 1);
                    v[list.get(index)[0]][list.get(index)[1]] = 0;
                }
            }
        }
    }
    private static boolean pruning(int index,int number) {
            boolean check = true;
            for(int j=0; j<9; j++){
                if(number==v[list.get(index)[0]][j]){
                    check= false;
                }
                if(number==v[j][list.get(index)[1]]){
                    check= false;
                }
            }
            for(int j=0;j<3; j++){
                for(int k=0; k<3; k++){
                    int x = list.get(index)[0]/3;
                    int y = list.get(index)[1]/3;
                    if(v[x*3+j][y*3+k] == number){
                        check=false;
                    }
                }
            }
            if(check){
                return true;
            }
            return false;
    }
}