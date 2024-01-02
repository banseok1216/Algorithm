import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int m;
    static long[] v,arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        m = Integer.parseInt(br.readLine());
        String[] str1 = br.readLine().split(" ");
        v=new long[m+1];
        arr=new long[m+1];
        arr[0] = 1;
        for(int i=1; i<=m; i++) {
            v[i]=Long.parseLong(str1[i-1]);
            arr[i] = (arr[i - 1] * 2) % 1000000007;
        }
        Arrays.sort(v);
        long result =0;
        for(int i = 1; i <= m; i++) {
            result += (arr[i - 1] - arr[m - i]) * v[i];
            result %= 1000000007;
        }
        System.out.println(result);
    }
}
