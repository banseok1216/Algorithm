import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int m,serialNum;
    static List<Integer> trip = new ArrayList<>();
    static int[] tree, locInTrip,serial2no,no2serial;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        m = Integer.parseInt(br.readLine());
        for(int i=0; i<m+1; i++) list.add(new ArrayList<>());
        for(int i=0; i<m-1; i++){
            String[] arr = br.readLine().split(" ");
            int a = Integer.parseInt(arr[0]);
            int b= Integer.parseInt(arr[1]);
            list.get(a).add(b);
            list.get(b).add(a);
        }
        serialNum=1;
        locInTrip = new int[m+1];
        no2serial = new int[m+1];
        serial2no = new int[m+1];
        int h = (int)Math.ceil(Math.log(m)/Math.log(2)) +1;
        traversal(1,0);
        int len = trip.size();
        int size = len*h;
        tree = new int[size];
        init(0, len-1, 1);
        int m = Integer.parseInt(br.readLine());
        for(int i=0; i<m; i++) {
            String[] arr = br.readLine().split(" ");
            int a = Integer.parseInt(arr[0]);
            int b= Integer.parseInt(arr[1]);
            a = locInTrip[a];
            b = locInTrip[b];
            if(a>b) {
                int tmp = a;
                a = b;
                b = tmp;
            }
            int lca = query(0, len-1, a, b ,1);
            sb.append(serial2no[lca]+"\n");
            }
        System.out.println(sb);

    }
    static void traversal(int cur, int pa) {
        no2serial[cur] = serialNum;
        serial2no[serialNum] = cur;
        serialNum++;

        locInTrip[cur] = trip.size();
        trip.add(no2serial[cur]);

        for(int nxt : list.get(cur)) {
            if(nxt != pa) {
                traversal(nxt, cur);
                trip.add(no2serial[cur]);
            }
        }
    }
    static int init(int start, int end, int node) {
        if(start == end) {
            return tree[node] = trip.get(start);
        }
        int mid = (start+end)/2;
        return tree[node] = Math.min(init(start, mid, node*2), init(mid+1, end, node*2+1));
    }

    static int query(int start, int end, int left, int right, int node) {
        if(right < start || end < left) return Integer.MAX_VALUE;
        if(left <= start && end <= right) {
            return tree[node];
        }

        int mid = (start+end) /2;

        return Math.min(query(start, mid, left, right, node*2),
                query(mid+1, end, left, right, node*2+1));
    }
}
class Node{
    int left;
    int right;
    public Node(int left, int right){
        this.left = left;
        this.right = right;
    }
}