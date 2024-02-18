import java.util.*;
//튜브에게서 적어도 세 칸 이상 떨어져서 서기를 원했다
//N~F=0과 같은 형태의 문자열로 구성되어 있다. 제한조건은 아래와 같다.
//data의 원소는 다섯 글자로 구성된 문자열이다. 각 원소의 조건은 다음과 같다.
class Solution {
    static int ans;
    static String[] copyData;
    static HashMap<String, Integer> map;
    //5,2=0 6,7>2
    public static int solution(int n, String[] data) {
        ans =0;
        map = new  HashMap<String, Integer>();
        map.put("A", 0);
        map.put("C", 1);
        map.put("F", 2);
        map.put("J", 3);
        map.put("M", 4);
        map.put("N", 5);
        map.put("R", 6);
        map.put("T", 7);

        copyData = data;
        dfs(0,n,new int[8],0);
        int answer = ans;
        return answer;
    }
    public static void dfs(int cur, int n, int[] line, int bit){
        if(cur == 8){
            boolean check=true;
            for(int i=0; i<n; i++){
                int first = map.get(String.valueOf(copyData[i].charAt(0)));
                int second = map.get(String.valueOf(copyData[i].charAt(2)));
                int check1=-1;
                int check2=-1;
                String bool = String.valueOf(copyData[i].charAt(3));
                Integer l = copyData[i].charAt(4)-'0';
                for(int j=0; j<line.length; j++){
                    if(line[j] == first){
                        check1 = j;
                    }
                    if(line[j] == second){
                        check2 = j;
                    }
                }
                if(bool.equals("=") && Math.abs(check1-check2) != l+1 ){
                    check = false;
                    break;
                }
                if(bool.equals(">") && Math.abs(check1-check2) <= l+1){
                    check = false;
                    break;
                }
                if(bool.equals("<") && Math.abs(check1-check2) >= l+1){
                    check = false;
                    break;
                }
            }
            if(check){
                ans++;
            }
            return;
        }
        for(int i=0; i<8; i++){
            if((bit & (1<<i)) == 0){
                line[cur] = i;
                dfs(cur+1, n,line,bit | (1<<i));
            }
        }
    }
}