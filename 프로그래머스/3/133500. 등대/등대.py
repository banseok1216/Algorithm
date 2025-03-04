#등대와 등대 사이를 오가는 뱃길 n-1 몇개만 등대를 킬거 야 뱃길 양쪽 끝 등대중 적어도 하나는 켜져 있어야 함
#dp 문제
import sys
sys.setrecursionlimit(10**9)
def solution(n, lighthouse):
    b = [[] for _ in range(n+1)]
    for (s,e) in lighthouse:
        b[s].append(e)
        b[e].append(s)
    dp = [[0,0] for _ in range(n+1)]
    visited = [False] * (n+1)

    def dfs(x):
        visited[x] = True
        dp[x][0] = 0
        dp[x][1] = 1
        
        for i in b[x]:
            if not visited[i]:
                dfs(i)
                dp[x][0] += dp[i][1]
                dp[x][1] += min(dp[i][0],dp[i][1])
    dfs(1)
    answer = min(dp[1])
    return answer