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
    static long[][][] v;
    static int m;
    static long mod= 1000000000;
    static ArrayList<ArrayList<tree>> T;
    static ArrayList<int[]> list = new ArrayList<>();
    static ArrayList<Node> check = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Scanner sc = new Scanner(System.in);
        m = Integer.parseInt(br.readLine());
        v = new long[m+1][11][(1<<10)];
        for(int i=1; i<10; i++) {
            v[1][i][1<<i] =1;
        }
        for(int i=2; i<m+1; i++) {
            for(int j=0; j<10; j++) {
                for(int k=0; k<1024; k++) {
                    int bit = k | (1 << j);
                    if(j==0) {
                        v[i][j][bit] =  ((v[i][j][bit] + v[i-1][j+1][k]) % mod);
                    }
                    else if(j==9) {
                        v[i][j][bit] = ((v[i][j][bit] + v[i-1][j-1][k]) % mod);
                    }
                    else {
                        v[i][j][bit] =  ((v[i][j][bit] + v[i-1][j+1][k]+ v[i-1][j-1][k]) % mod);
                    }
                }
            }
        }
        long sum =0;
        for(int i=0; i<10; i++) {
            sum =  ((sum + v[m][i][1023]) % mod);
        }
        System.out.println(sum);
    }
}