N = int(input())
lst =[]
for i in range(N):
    lst.append(int(input()))
lst.sort()
ans = min(lst)*N
check = sum(lst[0:N])
for i in range(len(lst)):
    ans = max(ans,lst[i]*(N-i))
print(ans)