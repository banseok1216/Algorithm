import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int m, serialNum;
    static List<Integer> trip = new ArrayList<>();
    static int[] tree, locInTrip, serial2no, no2serial;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str1 = br.readLine().split(" ");
        int m = Integer.parseInt(str1[0]);
        int n = Integer.parseInt(str1[1]);
        HashSet<Integer> set = new HashSet<>();
        String[] str2 = br.readLine().split(" ");
        for(int i=0; i<m; i++){
            set.add(Integer.parseInt(str2[i]));
        }
        String[] str3 = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            set.add(Integer.parseInt(str3[i]));
        }
        int k = m+n-set.size();
        System.out.println(m+n-k-k);
    }
}