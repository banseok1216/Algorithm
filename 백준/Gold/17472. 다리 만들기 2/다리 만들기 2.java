import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.util.*;
import java.lang.*;

class Main {
    static int m, n, k;
    static int max;
    static ArrayList<Integer> tree = new ArrayList<>();
    static ArrayList<Integer> ans = new ArrayList<>();
    static int[][] v;
    static int[] v1, arr, arr2;
    static String[] strarr;
    static String[] sum;
    static StringBuilder sb = new StringBuilder();
    static boolean[][] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str1 = br.readLine().split(" ");
        int m = Integer.parseInt(str1[0]);
        int n = Integer.parseInt(str1[1]);
        Queue<Node> q = new LinkedList<Node>();
        check = new boolean[m][n];
        arr = new int[m*n];
        v=new int[m][n];
        for(int i=0; i<m*n; i++) arr[i] = i;
        for (int i = 0; i < m; i++) {
            String[] str2 = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                v[i][j] = Integer.parseInt(str2[j]);
                if (v[i][j] == 1) {
                    q.add(new Node(i, j,0,0,0));
                }
            }
        }
        int[] list1= new int[]{0,0,-1,1};
        int[] list2= new int[]{-1,1,0,0};
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.r));
        while (!q.isEmpty()) {
            Node node = q.poll();
            if(!check[node.x][node.y]){
                check[node.x][node.y]= true;
                for(int i=0; i<4; i++){
                    int nx= node.x+list1[i];
                    int ny = node.y + list2[i];
                    if(nx>=0 && ny>=0 && nx<m && ny<n&& node.c1 ==0 && node.c2 ==0 && !check[nx][ny]){
                        if(v[nx][ny] == 1){
                            q.add(new Node(nx,ny,0,0,0));
                            union((node.x)*n+node.y,(nx)*n+ny);
                        }
                        else{
                            pq.add(new Node(node.x,node.y,node.r,list1[i],list2[i]));
                        }
                    }
                }
            }
        }
        ArrayList<int[]> list = new ArrayList<int[]>();
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int nx = node.c1+node.x;
            int ny = node.c2+node.y;
            while(true){
                if(nx <0 || ny<0||nx >=m||ny >=n){
                    break;
                }
                if(find((nx)*n+ny) == find((node.x)*n+node.y)){
                    break;
                }
                if(v[nx][ny] == 1 && node.r<2) {
                    break;
                }
                if(v[nx][ny] == 1 && node.r>=2) {
                    list.add(new int[]{find((nx)*n+ny),find((node.x)*n+node.y),node.r});
                    break;
                }
                else{
                    nx += node.c1;
                    ny += node.c2;
                    node.r++;
                }
            }
        }
        list.sort(Comparator.comparingInt(arr -> arr[2]));
        int count =0;
        int ans=-1;
        for(int i=0; i<list.size(); i++){
            ans=find(list.get(0)[0]);
            if(find(list.get(i)[0]) != find(list.get(i)[1])){
                union(list.get(i)[0],list.get(i)[1]);
                count += list.get(i)[2];
            }
        }
        boolean avail = true;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(check[i][j]){
                    if(ans != find((i)*n+j)){
                        avail = false;
                    }
                }
            }
        }
        if(avail) System.out.println(count);
        else System.out.println(-1);
    }
    public static int find(int x){
        if(x==arr[x]){
            return x;
        }
        return arr[x] = find(arr[x]);
    }
    public static void union(int x, int y){
        x= find(x);
        y =find(y);
        if(x==y){
            return;
        }
        arr[x] = y;
    }
}
class Node{
    int x,y,r,c1,c2;
    public Node(int x, int y,int r,int c1,int c2){
        this.x = x;
        this.y = y;
        this.r = r;
        this.c1 = c1;
        this.c2 = c2;
    }
}
