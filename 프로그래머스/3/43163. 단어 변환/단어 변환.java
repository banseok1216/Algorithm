class Solution {
    static String[] copy;
    static int ans=10000000;
    public int solution(String begin, String target, String[] words) {
        copy = words;
        dfs(begin, target, new boolean[words.length],0);
        int answer = 0;
        if(ans==10000000){
            answer = 0;
        }
        else{
            answer = ans;
        }
        return answer;
    }
    public void dfs(String begin, String target, boolean[] check,int count){
        if(target.equals(begin)){
            ans = Math.min(ans,count);
        }
        for(int i=0; i<check.length; i++){
            if(!check[i]){
                if(checkChange(begin,copy[i])){
                    check[i] = true;
                    dfs(copy[i], target, check,count+1);
                    check[i] = false;
                }
            }
        }
    }
    public boolean checkChange(String a, String b){
        int count =0;
        for(int i=0; i<a.length(); i++){
            if(a.charAt(i) != b.charAt(i)){
                count++;
            }
        }
        if(count==1){
            return true;
        }
        return false;
    }
}