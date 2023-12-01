import java.util.*;
class Solution {
    static boolean[][] visited;
    static int[] count;
    static int m;
    static int n;
    static int max = 0;

    public int solution(int[][] land) {
        m = land.length;
        n = land[0].length;
        visited = new boolean[m][n];
        count = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && land[i][j] == 1) {
                    bfs(i, j, land);
                }
            }
        }
        for (int i = 0; i < count.length; i++) {
            max = Math.max(count[i], max);
        }
        int answer = max;
        System.out.println(answer);
        return answer;
    }
        public static void bfs(int p, int j, int[][] land) {
            Queue<int[]> queue = new LinkedList<int[]>();
            queue.offer(new int[]{p, j});
            int[] list1 = new int[]{1, -1, 0, 0};
            int[] list2 = new int[]{0, 0, -1, 1};
            int count1 = 0;
            boolean[] check = new boolean[n];
            while (!queue.isEmpty()) {
                int[] list;
                list = queue.poll();
                int x = list[0];
                int y = list[1];
                if (!visited[x][y]) {
                    visited[x][y] = true;
                    check[list[1]] = true;
                    count1++;
                    for (int i = 0; i < 4; i++) {
                        if (x + list1[i] < m && x + list1[i] >= 0 && y + list2[i] >= 0 && y + list2[i] < n) {
                            if (land[x + list1[i]][y + list2[i]] == 1) {
                                queue.offer(new int[]{x + list1[i], y + list2[i]});
                            }
                        }
                    }
                }
            }
            for (int i = 0; i < check.length; i++) {
                if (check[i]) {
                    count[i] += count1;
                }
            }
        }
    }