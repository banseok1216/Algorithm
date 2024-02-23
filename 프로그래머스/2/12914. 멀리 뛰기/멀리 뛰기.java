class Solution {
    static long[] ans;
    public long solution(int n) {
        ans = new long[n+1];
        long answer = 0;
        answer = dfs(n);
        return answer%1234567;
    }
    public static long dfs(int n){
        if(n==0){
         return 1;   
        }
        if(n==-1){
            return 0;
        }
        if(ans[n] != 0){
            return ans[n];
        }
        else{
            ans[n] = (dfs(n-1)+dfs(n-2))%1234567;    
            return ans[n];
        }
    }
}