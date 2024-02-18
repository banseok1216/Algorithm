import java.util.*;

class Solution {
    static HashSet<Integer> set = new HashSet<Integer>();
    static boolean[] arr = new boolean[1000001];
    static String check = "";
    static Stack<Integer> q = new Stack<>();
    static int ans = 0;

    public static int solution(int n, int k) {
        bit(n, k);

        int answer = ans;
        return answer;
    }

    public static void bit(int bit, int k) {
        while (bit != 0) {
            if (bit % k == 0) {
                String s = "";
                if(q.isEmpty()){

                }
                else{
                    while (!q.isEmpty()) {
                        s += q.pop();
                    }
                    if (Function(Long.parseLong(s))) {
                        ans++;
                    }
                }
            }
            else {
                q.add(bit % k);
            }
            bit /= k;
        }
        String s = "";
        if(q.isEmpty()){

        }
        else{
            while (!q.isEmpty()) {
                s += q.pop();
            }
            if (Function(Long.parseLong(s))) {
                ans++;
            }
        }
    }

    public static boolean Function(long num)
    {
        if (num < 2)
            return false;

        for (int i = 2; i <= Math.sqrt(num); i++)
            if (num % i == 0)
                return false;

        return true;
    }
}