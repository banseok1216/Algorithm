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
    static long m,n,max;
    static int[][] arr, v;
    static boolean[] isPrime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str1 = br.readLine().split(" ");
        long count=0;
        m = Long.parseLong(str1[0]);
        n = Long.parseLong(str1[1]);
        isPrime = new boolean[(int) (n-m+1)];
        for (int i = 0; i < isPrime.length; i++) {
            isPrime[i] = true;
        }
        for (long i = 2; i <= Math.sqrt(n); i++) {
            if(m % (i * i) == 0){
                for (long j = m / (i * i); j * i * i <= n && j * i * i >= m ; j += 1) {
                    int r = (int) ((j * i * i) - m);
                    isPrime[r] = false;
                }
            }
            else{
                for (long j = m / (i * i)+1; j * i * i <= n && j * i * i >= m ; j += 1) {
                    int r = (int) ((j * i * i) - m);
                    isPrime[r] = false;
                }
            }
        }
        for(long i=0; i<n-m+1; i++){
            if (isPrime[(int) i]) {
                count++;
            }
        }
        System.out.println(count);
    }
}