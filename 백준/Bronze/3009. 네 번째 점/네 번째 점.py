dx = dict()
dy = dict()
for _ in range(3):
    a, b = map(int, input().split(" "))
    dict.setdefault(dx, a, 0)
    dict.setdefault(dy, b, 0)
    dx[a] += 1
    dy[b] += 1
ansX = 0
ansY = 0
for num in dx.keys():
    if dx[num] == 1:
        ansX = num
for num in dy.keys():
    if dy[num] == 1:
        ansY = num
print(str(ansX) + " " + str(ansY))