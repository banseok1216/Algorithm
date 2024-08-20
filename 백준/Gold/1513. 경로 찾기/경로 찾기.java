import java.io.*;
import java.util.*;

public class Main {
    static class Pos {
        int r, c;
        Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int N, M, C;
    static Pos[] arcades;
    static int[][][][] DP;
    static boolean[][] isArcades;
    static final int MOD = 1000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arcades = new Pos[C + 1];
        isArcades = new boolean[N + 1][M + 1];
        DP = new int[N + 1][M + 1][C + 1][C + 1];
        DP[1][0][0][0] = 1;

        for (int i = 1; i <= C; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arcades[i] = new Pos(r, c);
            isArcades[r][c] = true;
        }

        init();

        for (int i = 1; i <= C; i++) {
            for (int j = i; j <= C; j++) {
                setArcadesValue(i, j);
            }
        }

        for (int i = 0; i <= C; i++) {
            int sum = 0;
            for (int j = i; j <= C; j++) {
                sum = (sum + DP[N][M][i][j]) % MOD;
            }
            bw.write(String.valueOf(sum));
            bw.write(" ");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void init() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (isArcades[i][j]) {
                    continue;
                }
                DP[i][j][0][0] = (DP[i - 1][j][0][0] + DP[i][j - 1][0][0]) % MOD;
            }
        }
    }

    static void setArcadesValue(int h, int c) {
        Pos cur = arcades[c];

        for (int i = h - 1; i < c; i++) {
            DP[cur.r][cur.c][h][c] += (DP[cur.r - 1][cur.c][h - 1][i] + DP[cur.r][cur.c - 1][h - 1][i]) % MOD;
        }

        for (int i = cur.r; i <= N; i++) {
            for (int j = cur.c; j <= M; j++) {
                if (isArcades[i][j]) {
                    continue;
                }
                DP[i][j][h][c] = (DP[i - 1][j][h][c] + DP[i][j - 1][h][c]) % MOD;
            }
        }
    }
}
