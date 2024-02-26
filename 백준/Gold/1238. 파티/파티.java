import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int m;
    static int[][] list1;
    static int max = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Scanner sc = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        String[] arr = br.readLine().split(" ");
        int n = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);
        int k = Integer.parseInt(arr[2]);
        ArrayList<ArrayList<Node>> list1 = new ArrayList<>();
        ArrayList<ArrayList<Node>> list2 = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            list1.add(new ArrayList<>());
            list2.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            String[] arr1 = br.readLine().split(" ");
            int first = Integer.parseInt(arr1[0]);
            int second = Integer.parseInt(arr1[1]);
            int total = Integer.parseInt(arr1[2]);
            list1.get(first).add(new Node(second, total));
            list2.get(second).add(new Node(first, total));
        }
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(k,0));
        int[] ans1 = new int[n+1];
        Arrays.fill(ans1, -1);
        while(!q.isEmpty()){
            Node node = q.poll();
            if(ans1[node.index] != -1){
                continue;
            }
            if(ans1[node.index] == -1){
                ans1[node.index] = node.total;
            }
            for(int i=0; i< list1.get(node.index).size(); i++){
                Node nxt = list1.get(node.index).get(i);
                if(ans1[nxt.index] == -1){
                    q.add(new Node(nxt.index,nxt.total+node.total));
                }
            }
        }
        q = new PriorityQueue<>();
        q.add(new Node(k,0));
        int[] ans2 = new int[n+1];
        Arrays.fill(ans2, -1);

        while(!q.isEmpty()){
            Node node = q.poll();
            if(ans2[node.index] != -1){
                continue;
            }
            if(ans2[node.index] == -1){
                ans2[node.index] = node.total;
            }

            for(int i=0; i< list2.get(node.index).size(); i++){
                Node nxt = list2.get(node.index).get(i);
                if(ans2[nxt.index] == -1){
                    q.add(new Node(nxt.index,nxt.total+node.total));
                }
            }
        }
        int max =0;
        for(int i=1; i<n+1; i++){
            max = Math.max(ans1[i]+ans2[i],max);
        }
        System.out.println(max);
    }
}

class Node implements Comparable<Node>{
    int index;
    int total;

    Node(int index,int total) {
        this.index = index;
        this.total = total;
    }
    @Override
    public int compareTo(Node o){
        return this.total - o.total;
    }
}