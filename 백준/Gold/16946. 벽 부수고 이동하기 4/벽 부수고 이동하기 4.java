import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.util.*;
import java.lang.*;


class Node implements Comparable<Node>{
    int r,x,y;
    public Node(int x,int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Node o) {
        return this.x-o.x;
    }
}
class tree{
    int x,y;
    public tree(int x,int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static StringBuilder stringBuilder = new StringBuilder();
    static boolean abc;
    static int max = 0;
    static int min = Integer.MAX_VALUE;
    static boolean[][] visited;
    static int[][] result;
    static int[][] v;
    static int check=0;
    static String K = "YES";
    static int R = Integer.MAX_VALUE;
    static int p = 0;
    static int q = 0;
    static int m;
    static int n;
    private int C;
    static int[] list2;
    static int[] list3;
    static int[] list4;
    static ArrayList<ArrayList<tree>> T;
    static ArrayList<int[]> list = new ArrayList<>();
    static ArrayList<Node> ans = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Scanner sc = new Scanner(System.in);
        String[] str1 = br.readLine().split(" ");
        m = Integer.parseInt(str1[0]);
        n = Integer.parseInt(str1[1]);
        v = new int[m][n];
        result = new int[m][n];
        list4 = new int[1000004];
        for(int i=0; i<m; i++){
            String[] str2 = br.readLine().split("");
            for(int j=0; j<n; j++){
                v[i][j] = Integer.parseInt(str2[j]);
            }
        }
        list2 = new int[]{0,0,-1,1};
        list3 = new int[]{-1,1,0,0};
        p=1;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(v[i][j] == 0){
                    p++;
                    dfs(i,j);
                    list4[p] = check%10;
                }
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(v[i][j] == 1){
                    res(i,j);
                }
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                stringBuilder.append(result[i][j]);
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
    }
    private static void dfs(int x, int y){
        check=0;
        Queue<tree> q = new LinkedList<>();
        q.add(new tree(x,y));
        while(!q.isEmpty()){
            tree T = q.poll();
            if(v[T.x][T.y] ==0) {
                v[T.x][T.y] = p;
                check++;
                for (int i = 0; i < 4; i++) {
                    int nx = T.x + list2[i];
                    int ny = T.y + list3[i];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                        if (v[nx][ny] == 0) {
                            q.add(new tree(nx, ny));
                        }
                    }
                }
            }
        }
    }
    private static void res(int x, int y) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < 4; i++) {
            int nx = x + list2[i];
            int ny = y + list3[i];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                if(v[nx][ny] != 1){
                    if(!set.contains(v[nx][ny])) {
                        set.add(v[nx][ny]);
                        result[x][y] += list4[v[nx][ny]];
                    }
                }
            }
        }
        result[x][y] = (result[x][y]+1)%10;
    }
}