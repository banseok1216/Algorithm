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
        int [] arr = new int[4000001];
        ArrayList<Integer> v1 = new ArrayList<>();
        for(int i=2;i<=m;i++) arr[i] = i;
        for(int i=2;i<=m;i++) {
            if(arr[i] != 0) {
                v1.add(i);
                for(int j=1;i*j<=m;j++) arr[i*j]=0;
            }
        }
        Collections.sort(v1);
        if(m==1){
            System.out.println(0);
        }
        else {
            int point1 = 0;
            int point2 = 1;
            int max = v1.get(point1);
            int count = 0;
            while (true) {
                if (max < m && point2 < v1.size()) {
                    max += v1.get(point2);
                    point2++;
                } else if (max > m) {
                    max -= v1.get(point1);
                    point1++;
                } else if (max == m) {
                    count++;
                    max -= v1.get(point1);
                    point1++;
                } else {
                    break;
                }
            }
            System.out.println(count);
        }
    }
}