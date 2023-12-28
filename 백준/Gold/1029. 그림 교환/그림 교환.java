import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.util.*;
import java.lang.*;


class Node implements Comparable<Node>{
    int x;
    int r;
        public Node(int x,int r){
        this.x = x;
        this.r = r;
    }
    @Override
    public int compareTo(Node o) {
        return this.r - o.r;
    }
}

class Main {
    static int m,max;
    static int[][] arr, v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        m = Integer.parseInt(br.readLine());
        arr = new int[1 << m][m];
        v = new int[m][m];
        for (int i = 0; i < m; i++) {
            String[] str1 = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                v[i][j] = Integer.parseInt(str1[j]);
            }
        }
        dfs(0, 1, 1);
        System.out.println(max);
    }
    public static void dfs(int i , int state, int visitCnt) {
        if (max == m) return;
        max = Math.max(max, visitCnt);
        if (state == (1 << m)) return;
        for (int j = 0; j < m; ++j) {
            //현재 방문하지 않은 정점이며, 그림을 구매할 수 있다면
            if ((state & (1 << (j))) == 0 && v[i][j] >= arr[state][i] && i!=j) {
                if (arr[state | (1 << j)][j] != 0 && arr[state | (1 <<j )][j] <= v[i][j])
                    continue;
                arr[state | (1 << (j))][j] = v[i][j];
                dfs(j, state | (1 << j), visitCnt + 1);
            }
        }
    }

}