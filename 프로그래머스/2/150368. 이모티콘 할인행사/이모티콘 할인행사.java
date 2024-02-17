import java.util.*;

class Solution {
    static int[][] copy1User;
    static int[][] copyEmoticon;
    static int max = 0;
    static int maxTotal = 0;
    static ArrayList<int[]> ans = new ArrayList<>();
    static int dis[] = {10,20,30,40};
    static int userLen, emoLen;

    public static int[] solution(int[][] users, int[] emoticons) {
        copy1User = users;
        copyEmoticon = new int[emoticons.length][4];
        for (int i = 1; i < 5; i++) {
            for (int j = 0; j < emoticons.length; j++) {
                copyEmoticon[j][i - 1] = (emoticons[j] * (100 - i * 10) / 100);
            }
        }
        userLen= users.length;
        emoLen = emoticons.length;
        ans.add(new int[]{0,0});
        //모든 경우의 수를 리스트에 담는다.
        dfs(users,emoticons, new int[emoLen], 0 );
        Collections.sort(ans, (a, b) -> b[0] - a[0] == 0 ? b[1] - a[1] : b[0] - a[0]);
        return ans.get(0);
    }

    public static void dfs(int[][] u, int[] e, int[] disInfo, int level){
        if(level == emoLen){//종료 조건
            int buyCnt = 0 ;
            int buySum = 0;

            for(int i = 0 ;i < userLen ;i++){
                int sum = 0 ;
                for(int j =0 ; j< emoLen; j++){
                    if(disInfo[j] >= u[i][0])
                        sum+= e[j]/100*(100-disInfo[j]);
                }
                if(sum >= u[i][1]){
                    buyCnt++;
                }else{
                    buySum += sum;
                }
            }
            ans.add(new int[]{buyCnt,buySum});
            return;
        }else{
            for(int i = 0 ;i < 4 ;i++){
                disInfo[level] = dis[i];
                dfs(u,e,disInfo, level+1);
            }
        }
    }
}