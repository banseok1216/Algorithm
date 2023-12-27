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
            String[] str1 = br.readLine().split("");
            n = Integer.parseInt(br.readLine());
            String str2 = br.readLine();
            Deque<Integer> q = new LinkedList<>();
            String[] str3 = str2.substring(1, str2.length()-1).split("[\\[\\]\\,]");
            if(n!=0) {
                for (int j = 0; j < str3.length; j++) {
                    q.add(Integer.parseInt(str3[j]));
                }
            }
            int w =1;
            boolean avail = true;
            for(int j=0; j<str1.length; j++){
                if(str1[j].equals("R")){
                    w = -w;
                }
                if(str1[j].equals("D")){
                    if(q.isEmpty()){
                        avail =false;
                        stringBuilder.append("error").append("\n");
                        break;
                    }
                    if(w==1){
                        q.pollFirst();
                    }
                    else {
                        q.pollLast();
                    }
                }
            }
            if(avail){
                stringBuilder.append("[");
                while (!q.isEmpty()){
                   if(w==1){
                       stringBuilder.append(q.pollFirst());
                       if(q.size()!=0){
                           stringBuilder.append(",");
                       }
                   }
                   else{
                       stringBuilder.append(q.pollLast());
                       if(q.size()!=0){
                           stringBuilder.append(",");
                       }
                   }
               }
                stringBuilder.append("]").append("\n");
            }
        }
        System.out.println(stringBuilder);

    }
}