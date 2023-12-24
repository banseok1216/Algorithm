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
    static int[] parent;
    static boolean[] visited;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Scanner sc = new Scanner(System.in);
        String[] str1 = br.readLine().split(" ");
        int M = Integer.parseInt(str1[0]);
        int N = Integer.parseInt(str1[1]);
        ArrayList<Integer> list = new ArrayList<>();
        String[] str2 = br.readLine().split(" ");
        for(int i=0; i<M;i++){
            list.add(Integer.parseInt(str2[i]));
        }
        list.add(0);
        int points1 = 0;
        int points2 = 1;
        long max;
        max = list.get(points1)+list.get(points2);
        int count=2;
        int answer=Integer.MAX_VALUE;
        if(list.get(points1) >=N){
            System.out.println(1);
        }
        else {
            while (points1 <= points2) {
                if (points2 >= M) {
                    break;
                } else if (max >= N) {
                    answer = Math.min(answer, count);
                    max -= list.get(points1);
                    points1++;
                    count--;
                } else if (max < N) {
                    points2++;
                    max += list.get(points2);
                    count++;
                }
            }
            if (answer == Integer.MAX_VALUE) {
                System.out.println(0);
            } else {
                System.out.println(answer);
            }
        }
    }
}