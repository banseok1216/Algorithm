N = int(input())
a = []
for _ in range(N):
    a.append(input())

for j in range(len(a[0])+1):
    k = set()
    for s in a:
        k.add(s[len(s)-j:])
    if len(k) == N:
        print(j)
        break
