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
        dfs(users, new int[emoLen][2], 0 );
        Collections.sort(ans, (a, b) -> b[0] - a[0] == 0 ? b[1] - a[1] : b[0] - a[0]);
        return ans.get(0);
    }

    public static void dfs(int[][] u, int[][] disInfo, int level){
        if(level == emoLen){//종료 조건
            int buyCnt = 0 ;
            int buySum = 0;

            for(int i = 0 ;i < userLen ;i++){
                int sum = 0 ;
                for(int j=0; j<level;j++){
                    if(disInfo[j][0] >= u[i][0])
                        sum+= disInfo[j][1];
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
                for(int j=level; j<copyEmoticon.length; j++){
                    for(int i = 0 ;i < 4 ;i++){
                    disInfo[j][0] = (i+1)*10;
                    disInfo[j][1] = copyEmoticon[j][i];
                    dfs(u,disInfo, j+1);
                }
            }
        }
    }
}