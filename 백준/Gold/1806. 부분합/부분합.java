import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int INF = 987654321;
        int[] arr;
        int n, s, sum, start = 0, last = 0, mnm = INF;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        sum = arr[0];
        while (start <= last && last < n) {
            if (sum < s) {
                last++;
                if (last < n) sum += arr[last];
            } else {
                if (mnm > last - start + 1)
                    mnm = last - start + 1;
                if (start < n)
                    sum -= arr[start++];
            }
        }

        System.out.println(mnm != INF ? mnm : 0);
    }
}
