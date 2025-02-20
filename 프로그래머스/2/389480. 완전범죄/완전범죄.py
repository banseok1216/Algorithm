#A 도둑 과 B 도둑이 팀을 이룸 모든 물거 ㄴ훔쳐 i를 훔칠떄 info[i][0] 개의 A에 대한 흔적 흕거 누적 n개 경찰
def solution(info, n, m):
    size = len(info)
    inf = 1000000000000
    dp = [[inf for _ in range(m)] for _ in range(size+1)]
    answer = 0
    dp[0][0] = 0
    for i in range(1, size+1):
        a = info[i-1][0]
        b = info[i-1][1]
        
        for j in range(m):
            dp[i][j] = min(dp[i][j],dp[i-1][j]+a)
            if j+b<m:
                dp[i][j+b] = min(dp[i][j+b], dp[i-1][j])
    answer = min(dp[size])
    if answer >= n:
        answer = -1
    return answer