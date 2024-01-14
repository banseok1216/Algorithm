import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int m,serialNum;
    static List<Integer> trip = new ArrayList<>();
    static int[] tree, locInTrip,serial2no,no2serial;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        m = Integer.parseInt(br.readLine());
        PriorityQueue<Node> nodePriorityQueue = new PriorityQueue<>(Comparator
                .comparingInt((Node node) -> node.left)
                .thenComparingInt(node -> node.right));
        for(int i=0; i<m; i++){
            int n = Integer.parseInt(br.readLine());
            if(n<0){
                nodePriorityQueue.add(new Node(Math.abs(n),-1));
            }
            if(n>0){
                nodePriorityQueue.add(new Node(Math.abs(n),1));
            }
            if(n==0){
                if(nodePriorityQueue.isEmpty()){
                    sb.append(0).append("\n");
                }
                else {
                    Node node =nodePriorityQueue.poll();
                    sb.append(node.left*node.right).append("\n");
                }
            }
        }
        System.out.println(sb);

    }
}
class Node{
    int left;
    int right;
    public Node(int left, int right){
        this.left = left;
        this.right = right;
    }
}