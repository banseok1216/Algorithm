N = int(input())
l = []
minX = 100000000000
maxX = -100000000000
minY = 100000000000
maxY = -100000000000
for _ in range(N):
    a, b = map(int, input().split(" "))
    minX = min(minX, a)
    maxX = max(maxX, a)
    minY = min(minY, b)
    maxY = max(maxY, b)
print(abs(maxX - minX) * abs(maxY - minY))