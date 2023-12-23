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
    static String[][] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Scanner sc = new Scanner(System.in);
        int m = Integer.parseInt(br.readLine());
        String[] str1 = br.readLine().split(" ");
        int[] v1 = new int[m];
        for(int i=0; i<m; i++){
            v1[i]=Integer.parseInt(str1[i]);
        }
        Arrays.sort(v1);
        int point1 = 0;
        int point2 = v1.length-1;
        int[] ans = new int[3];
        ans[0] = Math.abs(v1[point1]+v1[point2]); ans[1] = v1[point1]; ans[2] = v1[point2];
        while(point1<point2){
            int point = v1[point1]+v1[point2];
            if(ans[0]>Math.abs(point)){ ans[0] = Math.abs(point) ;ans[1] = v1[point1]; ans[2] = v1[point2];}
            if(point>0){
                point2--;
            }
            else{
                point1++;
            }
        }
        System.out.println(ans[1] +" " + ans[2]);
    }
}