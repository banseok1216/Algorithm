import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.util.*;
import java.lang.*;


class Node implements Comparable<Node>{
    int r,x,y;
    public Node(int x,int y,int r){
        this.x = x;
        this.r = r;
        this.y = y;
    }

    @Override
    public int compareTo(Node o) {
        return this.r-o.r;
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
    static int[][] v1;
    static int[][] v2;

    static boolean[][] visited;
    static int max =0;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Scanner sc = new Scanner(System.in);
        int m = Integer.parseInt(br.readLine());
        v1=new int[m][m];
        v2=new int[m][m];
        visited = new boolean[m][m];
        for(int i=0; i<m; i++ ){
            String[] str2 = br.readLine().split(" ");
            list.add(new ArrayList<>());
            for(int j=0; j<m; j++){
                if(i%2 == j%2 && Integer.parseInt(str2[j]) == 1) {
                    v1[i][j] = 1;
                }
                else{
                    v2[i][j] = Integer.parseInt(str2[j]);
                }
            }
        }

        dfs(m,0,0,v1);
        int check = max;
        max =0;
        visited = new boolean[m][m];
        dfs(m,0,0,v2);
        check+=max;
        System.out.println(check);
    }
    private static void dfs(int length,int count,int x,int[][] list1){
        max = Math.max(max,count);
        for(int i=x; i<length; i++){
            for(int j=0; j<length; j++){
                if(list1[i][j] == 1&&!visited[i][j] && pruning(i,j)){
                    visited[i][j] = true;
                    list.get(i).add(j);
                    dfs(length,count+1,i,list1);
                    int lastIndex = list.get(i).size() - 1;
                    list.get(i).remove(lastIndex);
                    visited[i][j] = false;
                }
            }
        }
    }
    private static boolean pruning(int x, int y){
        for(int i=0; i<list.size(); i++){
            for(int j=0; j<list.get(i).size(); j++){
                if(Math.abs(i-x) == Math.abs(list.get(i).get(j)-y)){
                    return false;
                }
            }
        }
        return true;
    }
}