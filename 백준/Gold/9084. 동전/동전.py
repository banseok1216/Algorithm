# 화폐 단위 1원, 5원, 10원, 100원, 500원
# 이동전들로 정수의 금액 만들기 여러가지 방법
# 금액을 만드는 모든 방법을 세는 프로그램

N = int(input())
for _ in range(N):
    k = int(input())
    l = list(map(int, input().split(" ")))
    n = int(input())
    dp = [[0 for _ in range(k)] for _ in range(n + 1)]
    for i in range(len(l)):
        num = l[i]
        for j in range(n + 1):
            if i == 0:
                if j % num == 0:
                    dp[j][i] = 1
            elif j - num >= 0:
                dp[j][i] += dp[j][i - 1]
                dp[j][i] += dp[j - num][i]
            else:
                dp[j][i] = dp[j][i-1]
    print(dp[n][k-1])
