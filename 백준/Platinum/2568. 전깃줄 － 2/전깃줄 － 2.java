import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.util.*;
import java.lang.*;


class Node implements Comparable<Node>{
    int r,x,y;
    public Node(int x,int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Node o) {
        return this.x-o.x;
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
    static int max = 0;
    static int min = Integer.MAX_VALUE;
    static boolean[][] visited;
    static Character[][] result;
    static int[][] v;
    static int check=0;
    static String K = "YES";
    static int R = Integer.MAX_VALUE;
    static int p = 0;
    static int q = 0;
    static int m;
    static int n;
    private int C;
    static int[] list2;
    static int[] list3;
    static int[] list4;
    static ArrayList<ArrayList<tree>> T;
    static ArrayList<int[]> list = new ArrayList<>();
    static ArrayList<Node> ans = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Scanner sc = new Scanner(System.in);
        int m = Integer.parseInt(br.readLine());
        ArrayList<Node> T = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<m; i++){
            String[] str1 = br.readLine().split(" ");
            T.add(new Node(Integer.parseInt(str1[0]),Integer.parseInt(str1[1])));
            set.add(Integer.parseInt(str1[0]));
        }
        Collections.sort(T);
        list4 = new int[m];
        int start = T.get(0).x;
        ans.add(new Node(0,start));
        list4[0] = T.get(0).y;
        max = 1;
        for(int i=1; i<T.size(); i++){
            int max_copy = max;
            int min = 0;
            while(min<max_copy) {
                int mid = (max_copy + min) / 2;
                if (list4[max-1] < T.get(i).y) {
                    min = max;
                    max++;
                    break;
                }
                if (list4[mid] >= T.get(i).y) max_copy = mid;
                else min = mid + 1;
            }
            int track = T.get(i).x;
            ans.add(new Node(min,track));
            list4[min] = T.get(i).y;
        }
        int v = max-1;
        for(int i=ans.size()-1; i>=0; i--){
            if(ans.get(i).x == v){
                set.remove(ans.get(i).y);
                v--;
            }
        }
        ArrayList<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        stringBuilder.append(m-max).append("\n");
        for(int i=0; i<list.size(); i++){
            stringBuilder.append(list.get(i)).append("\n");
        }
        System.out.println(stringBuilder);
    }
}