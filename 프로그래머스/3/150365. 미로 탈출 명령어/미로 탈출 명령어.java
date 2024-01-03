import java.util.*;

class Solution {
    static int[][] v;
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        boolean[][][] chk = new boolean[n][m][k+1];
        int[] list1 = {0,0,-1,1};
        int[] list2 = {-1,1,0,0};
        chk[x-1][y-1][0] = true;
        String answer = "";
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(x-1,y-1,""));
        boolean first = false;
        String check = "";
        while(!q.isEmpty()){
            Node node = q.poll();
            if(node.x==r-1 && node.y==c-1 && (k-node.r.length())%2 ==0){
                check = node.r;
            }
            if(node.r.length() == k){
                if(node.x==r-1 && node.y==c-1){
                        answer = node.r;
                        break;
                }
            }
            else{
                if(!answer.equals("") && check.compareTo(node.r) <= 0){
                    continue;
                }
            for(int i=0; i<4; i++){
                int nx = list1[i] + node.x;
                int ny = list2[i] + node.y;
                if(nx>=0 && ny>=0 && nx<n && ny<m ){ 
                    if(chk[nx][ny][node.r.length()+1]) continue;
                    chk[nx][ny][node.r.length()+1] = true;
                    if(i==0){
                        q.add(new Node(nx,ny,node.r+"l"));
                    }
                    if(i==1){
                        q.add(new Node(nx,ny,node.r+"r"));
                    }
                    if(i==2){
                        q.add(new Node(nx,ny,node.r+"u"));
                    }
                    if(i==3){
                        q.add(new Node(nx,ny,node.r+"d"));
                    }
                }
            }
            }
        }
        if(answer.equals("")){
            answer = "impossible";
        }
        return answer;
    }
}
class Node implements Comparable<Node> {
    int x,y;
    String r;

    public Node(int x,int y,String r) {
        this.x = x;
        this.y =y;
        this.r = r;
    }
    @Override
    public int compareTo(Node o) {
        return this.r.compareTo(o.r);
    }

}