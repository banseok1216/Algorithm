import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.util.*;
import java.lang.*;


class Node implements Comparable<Node>{
    int x,y;
    int r,z;
    long v;
    public Node(int x,int y,int r,int z){
        this.x = x;
        this.y = y;
        this.r = r;
        this.z = z;
    }

    @Override
    public int compareTo(Node o) {
        return this.r - o.r;
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
    static int min = Integer.MAX_VALUE;
    static boolean[][][] visited;
    static int[] list3;
    static int[] list4;
    static String[][] v;
    static ArrayList<ArrayList<tree>> T;
    static ArrayList<int[]> list = new ArrayList<>();
    static ArrayList<Node> check = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Scanner sc = new Scanner(System.in);
        String[] str1 = br.readLine().split(" ");
        int M = Integer.parseInt(str1[0]);
        int N = Integer.parseInt(str1[1]);
        v= new String[M][N];
        visited = new boolean[M][N][64];
        PriorityQueue<Node> q = new PriorityQueue<>();
        for(int i=0;i<M; i++){
            String[] str2 = br.readLine().split("");
            for(int j=0; j<N; j++){
                if(str2[j].equals("0")){
                    q.add(new Node(i,j,0,0));
                }
                v[i][j] = str2[j];
            }
        }
        list3 = new int[]{0,0,-1,1};
        list4 = new int[]{-1,1,0,0};
        int ans=-1;
        while(!q.isEmpty()){
            Node node = q.poll();
            if(v[node.x][node.y].equals("1")){
                ans = node.r;
                break;
            }
                for(int i=0; i<4; i++){
                    int nx = list3[i] + node.x;
                    int ny = list4[i] + node.y;
                    if(nx>=0 && ny>=0 && nx<M && ny<N && (!visited[nx][ny][node.z] && !v[nx][ny].equals("#"))){
                        int bitset = node.z;
                        if (v[nx][ny].equals(".") || v[nx][ny].equals("1") ||v[nx][ny].equals("0") ) {
                            visited[nx][ny][bitset] = true;
                            q.add(new Node(nx, ny, node.r + 1, bitset));
                        }
                        else {
                            int m = v[nx][ny].charAt(0);
                            if (m >= 97 && m <= 122) {
                                bitset |= (1 << (m - 97));
                                visited[nx][ny][bitset] = true;
                                q.add(new Node(nx, ny, node.r + 1, bitset));
                            }
                            if (m >= 65 && m <= 90) {
                                if ((bitset & (1 << (m - 65))) != 0) {
                                    visited[nx][ny][node.z] = true;
                                    q.add(new Node(nx, ny, node.r + 1,bitset));
                                }
                            }
                        }
                    }
                }
        }
        System.out.println(ans);
    }
}