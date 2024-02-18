import java.util.*;
class Solution {
    static String[][] copy;
    static HashMap<String,String> map = new HashMap<String,String>();
    static ArrayList<String[]> list = new ArrayList();;
    public static int[] solution(int[] fees, String[] records) {
        copy = new String[records.length][3];
        for(int i=0; i<records.length; i++){
            copy[i] = records[i].split(" ");
            if(map.containsKey(copy[i][1])){
                String[] cal1 = map.get(copy[i][1]).split(":");
                String[] cal2 =  copy[i][0].split(":");
                int intotal = Integer.parseInt(cal1[0])*60 + Integer.parseInt(cal1[1]);
                int outtotal = Integer.parseInt(cal2[0])*60 + Integer.parseInt(cal2[1]);
                int difference = outtotal-intotal;
                list.add(new String[]{copy[i][1], String.valueOf(difference)});
                map.remove(copy[i][1]);
            }
            else{
                map.put(copy[i][1],copy[i][0]);
            }
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            String[] cal2 =  value.split(":");
            int intotal = Integer.parseInt(cal2[0])*60 + Integer.parseInt(cal2[1]);
            int outtotal = 23*60 + 59;
            int difference = outtotal-intotal;
            list.add(new String[]{key, String.valueOf(difference)});
        }
        Collections.sort(list, new Comparator<String[]>() { // 요금을 정렬하기 위한 Comparator 추가
            @Override
            public int compare(String[] o1, String[] o2) {
                return o1[0].compareTo(o2[0]); // 차량 번호를 기준으로 정렬
            }
        });
        String k= "";

        ArrayList<Integer> answer= new ArrayList<>();
        for(int i=0; i< list.size(); i++){
            if(k.equals(list.get(i)[0])){
                int c = Integer.parseInt(list.get(i)[1]) + answer.get(answer.size()-1);
                answer.set(answer.size()-1, c);
            }
            else{
                k=list.get(i)[0];
                answer.add(Integer.parseInt(list.get(i)[1]));
            }
        }
        int[] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = cal(fees,answer.get(i));
        }
        return result;
    }
    public static int cal(int[] fees,int difference){
        if(difference>fees[0]){
            int fee =0;
            if((difference- fees[0])%fees[2] == 0){
                fee = fees[1]+(difference- fees[0])/fees[2]*fees[3];
            }
            else{
                fee = fees[1]+((difference- fees[0])/fees[2]+1)*fees[3];
            }
            return fee;
        }
        else{
            return fees[1];
        }
    }
}