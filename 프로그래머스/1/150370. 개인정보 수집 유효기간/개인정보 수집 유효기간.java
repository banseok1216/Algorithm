import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int date = getDate(today);
        HashMap<String,Integer> map = new HashMap<>();
        ArrayList<Integer> integerList = new ArrayList<>();
        for(int i=0; i<terms.length; i++){
            String[] arr = terms[i].split(" ");
            map.put(arr[0],Integer.parseInt(arr[1]));
        }
        for(int i=0; i<privacies.length; i++){
            String[] arr = privacies[i].split(" ");
            if (getDate(arr[0]) + (map.get(arr[1]) * 28) <= date) {
                integerList.add(i + 1);
            }
        }
        int[] answer = new int[integerList.size()];
        for(int i=0; i<integerList.size(); i++){
            answer[i] = integerList.get(i);
        }
        return answer;
    }
    private int getDate(String today) {
        String[] date = today.split("\\.");
        int year = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int day = Integer.parseInt(date[2]);
        return (year * 12 * 28) + (month * 28) + day;
    }
}