A, B = map(int, input().split(" "))
N = int(input())
l = []
for _ in range(N):
    l.append(int(input()))
l.sort()
a = abs(A-B)
for i in l:
    a = min(a, abs(B-i) + 1)
print(a)
