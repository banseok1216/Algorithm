import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int m;
    static int[][] list1;
    static int max = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Scanner sc = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        int line = Integer.parseInt(br.readLine());
        String[] arr =br.readLine().split(" ");
        int[] list = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            list[i] = Integer.parseInt(arr[i]);
        }
        Arrays.sort(list);
        int count =0;
        for (int i = 0; i < arr.length; i++) {
            int tmp = 1;
            int left = 0;
            int right = arr.length - 1;
            while (left < right) {
                if (list[left] + list[right] < list[i]) left++;
                else if (list[left] + list[right] > list[i]) right--;
                else {
                    if (left == i) left++;
                    else if (right == i) right--;
                    else {
                        count += tmp;
                        break;
                    }
                }
            }
        }
        System.out.println(count);
    }

}
