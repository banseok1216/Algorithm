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
        int m = Integer.parseInt(br.readLine());
        ArrayList<Integer> T = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        String[] str1 = br.readLine().split(" ");
        for(int i=0; i<m; i++){
            T.add(Integer.parseInt(str1[i]));
        }
        list4 = new int[m];
        list3 = new int[m];
        list4[0] = T.get(0);
        list3[0] = 0;
        max = 1;
        for(int i=1; i<T.size(); i++){
            int max_copy = max;
            int min = 0;
            while(min<max_copy) {
                int mid = (max_copy + min) / 2;
                if (list4[max-1] < T.get(i)) {
                    min = max;
                    max++;
                    break;
                }
                if (list4[mid] >= T.get(i)) max_copy = mid;
                else min = mid + 1;
            }
            list3[i] = min;
            list4[min] = T.get(i);
        }
        stringBuilder.append(max).append("\n");
        int ans = list3.length-1;
        int index = max-1;
        ArrayList<Integer> list = new ArrayList<>();
        while(true) {
            if(index==-1){
                break;
            }
            if (list3[ans] == index) {
                list.add(T.get(ans));
                index--;
            }
            ans--;
        }
        Collections.sort(list);
        for(int i=0; i<list.size();i++){
            stringBuilder.append(list.get(i)).append(" ");
        }
        System.out.println(stringBuilder);
    }
}