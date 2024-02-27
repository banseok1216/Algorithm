import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int m;
    static int max = -1;
    static int[] nodeArr;
    static int[] list1 = new int[]{0,0,-1,1};
    static int[] list2 = new int[]{-1,1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Scanner sc = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        String[] arr = br.readLine().split(" ");
        int n = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);
        String[][] board = new String[n][m];
        boolean[][] check = new boolean[n][m];
        PriorityQueue<Node> q = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            arr = br.readLine().split("");
            for(int j=0; j<m; j++){
                if(arr[j].equals("S")){
                    board[i][j] = ".";
                    q.add(new Node(i,j,0));
                }
                else {
                    board[i][j] = arr[j];
                }
            }
        }
        int count =1;
        int ans = -1;
        while(!q.isEmpty()){
            if(q.peek().time == count){
                update(board);
                count++;
            }
            Node node = q.poll();
            if(board[node.x][node.y].equals("D")){
                ans = count;
                break;
            }
            if(board[node.x][node.y].equals("*")){
                continue;
            }
            check[node.x][node.y] = true;
            for(int i=0; i<4; i++){
                int nx = node.x+list1[i];
                int ny = node.y+list2[i];
                if(nx>=0 && nx<n && ny>=0 && ny<m){
                    if(board[nx][ny].equals(".") || board[nx][ny].equals("D")){
                        if(!check[nx][ny]) {
                            check[nx][ny] = true;
                            q.add(new Node(nx, ny, node.time + 1));
                        }
                    }
                }
            }
        }
        if(ans == -1){
            System.out.println("KAKTUS");
        }
        else{
            System.out.println(ans-1);
        }
    }
    public static String[][] update(String[][] board){
        String[][] copy = new String[board.length][board[0].length];
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j].equals("*")){
                    for(int k=0; k<4; k++){
                        int nx=i+list1[k];
                        int ny=j +list2[k];
                        if(nx>=0 && nx<board.length && ny>=0 && ny<board[0].length) {
                            if (board[nx][ny].equals(".")) {
                                copy[nx][ny] = "*";
                            }
                        }
                    }
                }
            }
        }
        for(int i=0; i<board.length; i++){
            for (int j=0;j<board[0].length; j++){
                if(copy[i][j] != null && copy[i][j].equals("*")){
                    board[i][j] = "*";
                }
            }
        }
        return board;
    }
}

class Node implements Comparable<Node> {
    int x;
    int y;
    int time;

    Node(int x, int y,int time) {
        this.x =x;
        this.y = y;
        this.time = time;
    }

    @Override
    public int compareTo(Node o) {
        return this.time - o.time;
    }
}