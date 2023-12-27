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
    static int[] list3;
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
        for(int i=0; i<m; i++){
            int count =2;
            String str1 = br.readLine();
            StringBuilder sb = new StringBuilder(str1);
            if (str1.equals(sb.reverse().toString())) {
                count=0;
            }
            int point1 =0;
            int point2 = str1.length()-1;
            while(point1<point2) {
                if(str1.charAt(point1) == str1.charAt(point2)) {
                    point1++;
                    point2--;
                }
                else{
                    StringBuilder delLeft = new StringBuilder(str1).deleteCharAt(point1);
                    StringBuilder delRight = new StringBuilder(str1).deleteCharAt(point2);
                    if (delLeft.toString().equals(delLeft.reverse().toString()) || delRight.toString().equals(delRight.reverse().toString())) {
                        count=1;
                    }
                    break;
                }
            }
            stringBuilder.append(count).append("\n");
        }
        System.out.println(stringBuilder);

    }
}