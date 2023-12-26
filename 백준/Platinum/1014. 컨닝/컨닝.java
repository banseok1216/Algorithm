import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.util.*;
import java.lang.*;


class Node implements Comparable<Node>{
    int x,y;
    int r,z;
    long v;
    public Node(int x,int y,int r,int z){
        this.x = x;
        this.y = y;
        this.r = r;
        this.z = z;
    }

    @Override
    public int compareTo(Node o) {
        return this.r - o.r;
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
    static int min = Integer.MAX_VALUE;
    static boolean[][][] visited;
    static int[] list3;
    static int[] list4;
    static int[][] v;
    static String[][] board;
    static int m;
    static int n;
    static long mod= 1000000000;
    static ArrayList<ArrayList<tree>> T;
    static ArrayList<int[]> list = new ArrayList<>();
    static ArrayList<Node> check = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Scanner sc = new Scanner(System.in);
        int B = Integer.parseInt(br.readLine());
        for(int x = 0; x<B; x++) {
            String[] str1 = br.readLine().split(" ");
            m = Integer.parseInt(str1[0]);
            n = Integer.parseInt(str1[1]);
            board = new String[m][n];
            v = new int[1 << m][n];
            for (int n = 0; n < (1 << m); ++n) {
                Arrays.fill(v[n], -1);
            }
            for (int i = 0; i < m; i++) {
                String[] str2 = br.readLine().split("");
                for (int j = 0; j < n; j++) {
                    board[i][j] = str2[j];
                }
            }
            System.out.println(dfs(0, 0));
        }
    }
    private static int dfs(int pre, int cur){
        if(cur == n) return 0;
        if(v[pre][cur] != -1) return v[pre][cur];
        int preused = pre;
        for(int i=0; i<m; i++){
            if((pre & (1<<i)) != 0){
                if(i==0){
                    preused |= (1 << (i + 1));
                }
                else if(i==m-1){
                    preused |= (1 << (i - 1));
                }
                else {
                    preused |= (1 << (i + 1));
                    preused |= (1 << (i - 1));
                }
            }
        }
        int result = dfs(0, cur + 1);
        for (int i = 1; i < (1 << m); ++i) { // 학생을 앉히는 경우
            if ((i & preused) > 0) continue; // 나올 수 없는 경우의 수 제외하기
            int count = 0; // 학생 수를 세기 위함 (비트 연산)
            boolean isAvail = true;
            for (int j = 0; j < m && isAvail; ++j) {
                if ((i & (1 << j)) > 0) { // 이 자리에 학생이 앉아있는 경우
                    count++;
                    if (board[j][cur].equals("x")) isAvail = false; // 이 자리가 장애물이 있으면 이 또한 나올 수 없는 경우의 수
                }
            }
            if (!isAvail) continue; // 장애물 체크
            result = Math.max(result, dfs(i, cur + 1) + count);
        }
        return v[pre][cur] = result;
    }
}