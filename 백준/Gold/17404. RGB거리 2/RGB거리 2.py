# RGB 거리에는 집이 N 개 있다 선분으로 나타낼 수 있다. 1번 집 부터 N 번집이 순서대로
# 빨간 초록 파랑 하나의 색으로 칭 함

N = int(input())
b = []
inf = 100000000000000
for _ in range(N):
    b.append(list(map(int, input().split(" "))))
answer = []
for j in range(3):
    dp = [[inf, inf, inf] for _ in range(N)]
    for i in range(N):
        if i == 0:
            dp[i][j] = b[i][j]
        else:
            dp[i][0] = b[i][0] + min(dp[i-1][1], dp[i-1][2])
            dp[i][1] = b[i][1] + min(dp[i-1][0], dp[i-1][2])
            dp[i][2] = b[i][2] + min(dp[i-1][0], dp[i-1][1])
    for i in range(3):
        if i != j:
            answer.append(dp[N-1][i])
print(min(answer))
