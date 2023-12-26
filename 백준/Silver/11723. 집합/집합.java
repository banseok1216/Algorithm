import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.util.*;
import java.lang.*;


class Node implements Comparable<Node>{
    int x,y;
    ArrayList<Integer> list;
    public Node(int x,int y,ArrayList<Integer> list){
        this.x = x;
        this.y = y;
        this.list =list;
    }

    @Override
    public int compareTo(Node o) {
        return this.y - o.y;
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
    static int max = Integer.MAX_VALUE;
    static int min = Integer.MAX_VALUE;
    static boolean[][] visited;
    static int[] list4;
    static int[] list3;
    static ArrayList<ArrayList<tree>> T;
    static ArrayList<int[]> list = new ArrayList<>();
    static ArrayList<Node> ans = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Scanner sc = new Scanner(System.in);
        int M = Integer.parseInt(br.readLine());
        int bitset = 0;
        for(int i=0; i<M;i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if(str.equals("add")){
                int n = Integer.parseInt(st.nextToken());
                bitset = bitset | (1<<n-1);
            }
            if(str.equals("remove")){
                int n = Integer.parseInt(st.nextToken());
                bitset = bitset & ~(1<<n-1);
            }
            if(str.equals("check")){
                int n = Integer.parseInt(st.nextToken());
                stringBuilder.append((bitset & (1 << (n-1))) != 0 ? "1\n" : "0\n");
            }
            if(str.equals("toggle")){
                int n = Integer.parseInt(st.nextToken());
                bitset = bitset ^(1 << (n - 1));
            }
            if(str.equals("all")){
                bitset |= (1<<27)-1;
            }
            if(str.equals("empty")){
                bitset &= 0;
            }

        }
        System.out.println(stringBuilder);
    }
}