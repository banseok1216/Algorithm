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
        this.y =y;
        this.r = r;
    }
}
class Main {
    static int m,n,k;
    static int max;
    static ArrayList<ArrayList<Node>> list = new ArrayList<>();
    static ArrayList<Integer> ans = new ArrayList<>();
    static long[][] v;
    static long[] v1,arr1,arr2;
    static String[] parent;
    static StringBuilder sb = new StringBuilder();
    static boolean[][] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str1 = br.readLine().split(" ");
        m = Integer.parseInt(str1[0]);
        n = Integer.parseInt(str1[1]);
        String[] str2 = br.readLine().split(" ");
        v1 = new long[str2.length];
        for(int i=0; i<m; i++){
            v1[i]=Integer.parseInt(str2[i]);
        }
        Arrays.sort(v1);
        int mid = m/2;
        arr1 = new long[(1<<(m/2))];
        arr2 = new long[(1<<(m-m/2))];
        for(int i=0; i<(1<<mid); i++){
            for(int j=0; j<mid; j++){
                if((i&(1<<j)) != 0){
                    arr1[i]+=v1[j];
                }
            }
        }
        for(int i=0; i<(1<<m-m/2); i++){
            for(int j=0; j<m-m/2; j++){
                if((i&(1<<j)) != 0){
                    arr2[i]+=v1[mid+j];
                }
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        long count=0;
        int point1=0;
        int point2 =(1<<m-m/2)-1;
        while(point1< arr1.length && point2 >= 0){
            if(arr1[point1]+ arr2[point2] <= n){
                long aCnt = 0, bCnt = point2+1;
                while(point1<arr1.length && arr1[point1]+ arr2[point2] <= n ){
                    point1++;
                    aCnt++;
                }
                count+= aCnt*bCnt;
            }
            else if(arr1[point1]+ arr2[point2] > n){
                point2--;
            }
        }
        System.out.println(count);
    }
}