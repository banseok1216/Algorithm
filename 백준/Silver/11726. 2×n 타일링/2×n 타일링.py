#1*2 = 1
#2*2 = 2
#2*3 = 3
#2*4 = 6
#2*5 =

dp = [0 for i in range(1000)]
n = int(input())
dp[0] = 1
dp[1] = 2
for i in range(2, 1000):
    dp[i] = (dp[i-1] + dp[i-2]) % 10007
print(dp[n-1])