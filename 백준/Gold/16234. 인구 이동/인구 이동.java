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
        n = Integer.parseInt(arr[0]);
        int z = Integer.parseInt(arr[1]);
        int x = Integer.parseInt(arr[2]);
        list1 = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] arr1 = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                list1[i][j] = Integer.parseInt(arr1[j]);
            }
        }
        int[] list2 = new int[]{0, 0, -1, 1};
        int[] list3 = new int[]{-1, 1, 0, 0};
        int answer =0;
        while (true) {
            int[][] visit = new int[n][n];
            int[][] ncnt = new int[2501][2];
            int checkInt =0;
            int cnt =0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    cnt++;
                    if (visit[i][j] == 0) {
                        Queue<Node> q = new LinkedList<>();
                        q.add(new Node(i,j));
                        while (!q.isEmpty()) {
                            Node node = q.poll();
                            if(visit[node.x][node.y] != 0){
                                continue;
                            }
                            if(visit[node.x][node.y] == 0){
                                visit[node.x][node.y] = cnt;
                                ncnt[cnt][0]++;
                                ncnt[cnt][1] += list1[node.x][node.y];
                            }
                            for (int h = 0; h < 4; h++) {
                                int nx = list2[h] + node.x;
                                int ny = list3[h] + node.y;
                                if (nx >= 0 && nx < n && ny >= 0 && ny < n && visit[nx][ny] == 0 && Math.abs(list1[nx][ny] - list1[node.x][node.y]) >= z && Math.abs(list1[nx][ny] - list1[node.x][node.y]) <= x) {
                                    q.add(new Node(nx,ny));
                                    checkInt ++;
                                }
                            }
                        }
                    }

                }
            }
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    if (visit[i][j] != 0)
                    {
                        list1[i][j] = ncnt[visit[i][j]][1] / ncnt[visit[i][j]][0];
                    }
                }
            }
            if(checkInt == 0){
                break;
            }
            answer++;
        }
        System.out.println(answer);
    }

}
class Node{
    int x;
    int y;
    Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}