N = int(input())
l = []
for _ in range(N):
    l.append(int(input()))
ans = 0
for i in range(N - 2, -1, -1):
    if l[i + 1] <= l[i]:
        ans += (l[i] - l[i + 1] + 1)
        l[i] = l[i + 1] - 1
print(ans)