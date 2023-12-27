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
    static long min = Long.MAX_VALUE;
    static boolean[][][] visited;
    static long[] list3;
    static long[] list4;
    static int[][] v;
    static String[][] board;
    static int m;
    static int n;
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
        String[] str1 = br.readLine().split(" ");
        list3 = new long[m];
        for(int i=0; i<m; i++){
            list3[i] = Integer.parseInt(str1[i]);
        }
        Arrays.sort(list3);
        list4 = new long[3];
        for(int i=0; i<m; i++){
            pointer(i);
        }
        for(int i=0; i<3;i++){
            stringBuilder.append(list4[i]).append(" ");
        }
        System.out.println(stringBuilder);
    }
    private static void pointer(int index){
        int point1 = index+1;
        int point2 = list3.length-1;
        while(point1<point2){
            long sum = list3[point1] + list3[point2]+list3[index];
            if(min>Math.abs(sum)) {list4[0] = list3[index]; list4[1] = list3[point1];  list4[2] = list3[point2]; min = Math.abs(sum);}
            if(sum >0){
                point2--;
            }
            else{
                point1++;
            }
        }
    }
}