import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.util.*;
import java.lang.*;


class Node  {
    int x,y;
    long r;

    public Node(int x,int y,long r) {
        this.x = x;
        this.y =y;
        this.r = r;
    }
}
class Main {
    static int m,n,k;
    static int max;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static ArrayList<Integer> ans = new ArrayList<>();
    static long[][] v;
    static int[] v1,arr1,arr2;
    static String[] parent;
    static StringBuilder sb = new StringBuilder();
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str1 = br.readLine().split(" ");
        m = Integer.parseInt(str1[0]);
        n = Integer.parseInt(str1[1]);
        k = Integer.parseInt(str1[2]);
        for(int i=0; i<m+1; i++) list.add(new ArrayList<>());
        for(int i=0; i<n; i++){
            String[] str2 =br.readLine().split(" ");
            list.get(Integer.parseInt(str2[0])).add(Integer.parseInt(str2[1]));
            list.get(Integer.parseInt(str2[1])).add(Integer.parseInt(str2[0]));
        }
        for (List<Integer> adjacencyList : list) {
            adjacencyList.sort(Comparator.reverseOrder());
            }
        Queue<Integer> q = new LinkedList<>();
        q.add(k);
        arr1 = new int[m+1];
        check = new boolean[m+1];
        int count =0;
        while(!q.isEmpty()){
            int start = q.poll();
            if(arr1[start]==0) {
                count++;
                arr1[start]=count;
                for (int i = 0; i < list.get(start).size(); i++) {
                    q.add(list.get(start).get(i));
                }
            }
        }
        for(int i=1; i<arr1.length; i++){
            if(arr1[i] != 0) {
                sb.append(arr1[i]).append("\n");
            }
            else{
                sb.append(0).append("\n");
            }
        }
        System.out.println(sb);
    }
}