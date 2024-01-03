import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int m;
    static int[] v, arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        m = Integer.parseInt(br.readLine());
        String[] arr = new String[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = br.readLine();
        }
        int[][] list = new int[][]{{1, 2, 3}, {2, 1, 3}, {3, 1, 2}, {1, 3, 2}, {2, 3, 1}, {3, 2, 1}};
        boolean avail = false;
        for (int i = 0; i < list.length && !avail; i++) {
            int p;
            int q;
            int r;
            int[] list_i = list[i]; // 배열 참조 최적화
            boolean pq = false;
            boolean qr = false;
            for (int j = 0; j < m; j++) {
                char charAt_j_0 = arr[0].charAt(j);
                char charAt_j_1 = arr[1].charAt(j);
                char charAt_j_2 = arr[2].charAt(j);
                p =((charAt_j_0 == 'H') ? list_i[0] : (charAt_j_0 == 'J') ? list_i[1] : list_i[2]);
                q = ((charAt_j_1 == 'H') ? list_i[0] : (charAt_j_1 == 'J') ? list_i[1] : list_i[2]);
                r = ((charAt_j_2 == 'H') ? list_i[0] : (charAt_j_2 == 'J') ? list_i[1] : list_i[2]);
                if(p<q){
                    pq = true;
                }
                if(q<r){
                    qr = true;
                }

                if (pq && qr) {
                    avail = true;
                    break;
                }
                if(!pq && p>q){
                    break;
                }
                if(!qr && q>r){
                    break;
                }
            }
        }
        if (avail) {
            System.out.println("HJS! HJS! HJS!");
        } else {
            System.out.println("Hmm...");
        }
    }
}
