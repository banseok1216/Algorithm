n = int(input())
A = list(map(int, input().split()))
A.insert(0, 0)
dp = [0] * (n + 1)
for x in range(1, len(A)):
    dp[A[x]] = x
num = 1
maxa = -1
if n == 1:
    print(0)
    exit()
for x in range(1, len(A) - 1):
    if dp[x] < dp[x + 1]:
        num += 1
        if num > maxa:
            maxa = num
    else:
        num = 1
print(n - maxa)
