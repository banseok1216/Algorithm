import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int m;
    static int[][] list1;
    static int max = -1;
    static int[] nodeArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Scanner sc = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] board = new int[n + 2][n + 2];
        for (int i = 0; i < m; i++) {
            String[] arr = br.readLine().split(" ");
            board[Integer.parseInt(arr[0])][Integer.parseInt(arr[1])] = -1;
        }
        PriorityQueue<Node> q = new PriorityQueue<>();
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            String[] arr = br.readLine().split(" ");
            q.add(new Node(Integer.parseInt(arr[0]), arr[1]));
        }
        int nx = 1;
        int ny = 1;
        int last = 0;
        int[] list1 = new int[]{0, 1, 0, -1};
        int[] list2 = new int[]{-1, 0, 1, 0};
        int direction = 2;
        int count = 0;
        while (nx >= 1 & nx <= n && ny <= n && ny >= 1) {
            count++;
            nx += list1[direction];
            ny += list2[direction];
            if (board[nx][ny] == -1) {
                last++;
            }
            if(board[nx][ny] > 0  && board[nx][ny] >= count - last-1){
                break;
            }
            board[nx][ny] = count;
            if (!q.isEmpty()) {
                if (q.peek().time == count) {
                    if (q.peek().direction.equals("D")) {
                        direction = (direction + 3) % 4;
                    } else {
                        direction = (direction + 1) % 4;
                    }
                    q.poll();
                }
            }
        }
        System.out.println(count);
    }
}

class Node implements Comparable<Node> {
    int time;
    String direction;

    Node(int time, String direction) {
        this.time = time;
        this.direction = direction;
    }

    @Override
    public int compareTo(Node o) {
        return this.time - o.time;
    }
}