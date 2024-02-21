import java.util.*;
import java.util.*;
class Solution {
    static int[] parents;
    public int solution(int n, int[][] costs) {
        parents = new int[n+1];
        for(int i=0; i<parents.length; i++){
            parents[i] = i;
        }
             Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[2] != b[2]) {
                    return a[2] - b[2]; // 첫 번째 요소로 오름차순 정렬
                } else {
                    return a[1] - b[1]; // 두 번째 요소로 오름차순 정렬
                }
            }
            });
        int answer = 0;
        for(int i=0; i<costs.length; i++){
             if(find(costs[i][0]) != find(costs[i][1])){
                 System.out.println(find(costs[i][0]));
                System.out.println(find(costs[i][1]));
                 union(costs[i][0],costs[i][1]);
                 answer+=costs[i][2];
             }
        }
        return answer;
    }
    public void union(int a, int b){
        int A = find(a);
        int B = find(b);
        parents[A] = B;
    }
    public int find(int a){
        if(parents[a] == a){
            return parents[a];
        }
        return parents[a] = find(parents[a]);
    }
}