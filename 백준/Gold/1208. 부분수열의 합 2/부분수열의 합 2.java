import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.util.*;
import java.lang.*;


class Node implements Comparable<Node>{
    int Rx,Ry,Bx,By,r,x,y;
    public Node(int y,int r){
        this.r = r;
        this.y = y;
    }

    @Override
    public int compareTo(Node o) {
        return this.r-o.r;
    }
}
public class Main {
    static StringBuilder stringBuilder = new StringBuilder();
    static String[][] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Scanner sc = new Scanner(System.in);
        String[] str1 = br.readLine().split(" ");
        int M = Integer.parseInt(str1[0]);
        int N = Integer.parseInt(str1[1]);
        String[] str2 = br.readLine().split(" ");
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<M; i++){
            list.add(Integer.parseInt(str2[i]));
        }
        Collections.sort(list);
        int mid = M/2;
        ArrayList<Integer> A = new ArrayList<>();
        long count = 0;
        for (int i = 0; i < (1 << mid); i++) {
            int sum = 0;
            for (int j = 0; j < mid; j++) {
                if ((i & (1<<j)) == (1<<j))
                    sum += list.get(j);
            }
            A.add(sum);
        }
        ArrayList<Integer> B = new ArrayList<>();
        for (int i = 0; i < (1 << M-mid); i++) {
            int sum = 0;
            for (int j = 0; j < M-mid; j++) {
                if ((i & (1<<j)) == (1<<j))
                    sum += list.get(j+mid);
            }
            B.add(sum);
        }
        Collections.sort(A);
        Collections.sort(B);
        int point1 = 0;
        int point2 = B.size()-1;
        while(point1< A.size() && point2 >= 0){
            if(A.get(point1) + B.get(point2) == N){
                int a = A.get(point1);
                int b = B.get(point2);
                long aCnt = 0, bCnt = 0;
                while(point1!=A.size() && A.get(point1)  == a ){
                    point1++;
                    aCnt++;
                }
                while(point2 !=-1 && B.get(point2) == b ){
                    point2--;
                    bCnt++;
                }
                count+= aCnt*bCnt;
            }
            else if(A.get(point1) + B.get(point2) < N){
                point1++;
            }
            else if(A.get(point1) + B.get(point2) > N){
                point2--;
            }
        }
        if(N==0){
            count--;
        }
        System.out.println(count);
    }
}