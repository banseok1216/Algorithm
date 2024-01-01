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
        this.y = y;
        this.r = r;
    }
}
class Main {
    static long m,n,k;
    static long max;
    static ArrayList<ArrayList<Node>> list = new ArrayList<>();
    static ArrayList<Integer> ans = new ArrayList<>();
    static long[][] v;
    static int[] v1;
    static String[] parent,arr;
    static StringBuilder sb = new StringBuilder();
    static boolean[][] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        m= Integer.parseInt(br.readLine());
        arr = new String[(int) m];
        for(int i=0; i<m; i++){
            arr[i] = br.readLine();
        }

        k= Integer.parseInt(br.readLine());
        v = new long[1<<m][(int) (k+1)];
        v[0][0] = 1;
        long[] remd = new long[20];
        long[] lenRem = new long[51];
        for (int i = 0; i < m; i++) {
            remd[i] = getMod(i);
        }
        lenRem[0] = 1 % k;
        for (int i = 1; i <= 50; i++) {
            lenRem[i] = (lenRem[i - 1] * 10) % k;
        }
        for (int num = 0; num < (1 << m); num++) {
            for (int i = 0; i < m; i++) {
                if ((num & (1 << i)) == 0) {
                    int next = (num | (1 << i));
                    for (int j = 0; j < k; j++) {
                        int nextRem = (int) (((j * lenRem[arr[i].length()]) % k + remd[i]) % k);
                        v[next][nextRem] += v[num][j];
                    }
                }
            }
        }
        long answer = v[(1 << m) - 1][0];
        if(answer==0) {
            System.out.println("0/1");
        }else {
            //팩토리얼, 모든 경우의 수 계산
            long fac = 1;
            for(int i=2;i<=m;i++) {
                fac*=i;
            }
            long gcd = gcd(fac, answer);
            System.out.println(answer/gcd+"/"+fac/gcd);
        }
    }
    public static long gcd(long n, long m) {
        if(m==0) return n;
        return gcd(m, n%m);
    }
    public static int getMod(int idx) {
        int curr = 0;
        int length = arr[idx].length();
        for(int i=0;i<length;i++) {
            curr*=10; //10의 자리로 증가
            curr+=(arr[idx].charAt(i)-'0'); //1의 자리 더하기
            curr%=k; //K로 나눈 나머지 값
        }
        return curr;
    }
}