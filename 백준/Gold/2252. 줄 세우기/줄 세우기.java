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
        String[] str1 = br.readLine().split(" ");
        int M = Integer.parseInt(str1[0]);
        int N = Integer.parseInt(str1[1]);
        int[] count = new int[M+1];
        boolean[] visited = new boolean[M+1];
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0; i<M+1; i++) {
            list.add(new ArrayList<>());
        }
        for(int i=0; i<N; i++) {
            String[] str2 = br.readLine().split(" ");
            count[Integer.parseInt(str2[1])]++;
            list.get(Integer.parseInt(str2[0])).add(Integer.parseInt(str2[1]));
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<M+1; i++){
            if(count[i] ==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int l = q.poll();
            if(!visited[l]) {
                visited[l] = true;
                for (int i = 0; i < list.get(l).size(); i++) {
                    if(count[list.get(l).get(i)] >= 1) {
                        count[list.get(l).get(i)]--;
                    }
                    if (count[list.get(l).get(i)] == 0 && !visited[list.get(l).get(i)]) {
                        q.add(list.get(l).get(i));
                    }
                }
            }
            stringBuilder.append(l).append(" ");
        }
        System.out.println(stringBuilder);
    }
}