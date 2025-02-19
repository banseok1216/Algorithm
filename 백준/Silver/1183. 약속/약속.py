# 마법사 약속시간 A1 ---
# 도착시간 B1 ===
# 기다리는 시간 최소하 T 시간 는춰
# 그리디

N = int(input())
l = []
for _ in range(N):
    A, B = map(int, input().split(" "))
    s = A-B
    l.append(s)
l.sort()
if N % 2 == 0:
    print(abs(l[N//2-1] -l[N//2])+1)
else:
    print(1)