# 말 4개 화살표대로 파란색칸이면 무조건 파란색 화살표 아니면 빨간색 화살표 같은 칸에 말을 동시에 사용 할 수 X
# 점수 최댓값


b= [[] for _ in range(33)]
p = [0 for i in range(33)]

for i in range(1, 21):
    p[i] = 2 * i
p[21], p[22], p[23], p[24], p[25] = 13, 16, 19, 25, 26
p[26], p[27], p[28], p[29], p[30], p[31], p[32] = 27, 28, 22, 24, 30, 35, 0

for i in range(20):
    b[i].append([i+1,False])
b[5].append([21,True]),b[10].append([28,True]),b[15].append([27,True])
b[21].append([22,False]),b[22].append([23,False]),b[23].append([24,False]),b[24].append([30,False])
b[30].append([31,False]),b[31].append([20,False]),b[27].append([26,False]),b[26].append([25,False])
b[25].append([24,False]),b[28].append([29,False]),b[29].append([24,False]),b[20].append([32,False])
def simulate(c,now):
    global b
    sim = now
    while c >0:
        if sim == 32:
            return 32
        if (now == 5 or now == 10 or now == 15) and sim == now:
            sim = b[sim][1][0]
        else:
            sim = b[sim][0][0]
        c -=1
    return sim
answer = 0
def dfs(level, sum):
    global i_b
    global pos
    global p
    global answer
    if level == 10:
        answer = max(answer, sum)
        return
    dice = i_b[level]
    for i in range(4):
        if pos[i] == 32:
            continue
        now = pos[i]
        nxt = simulate(dice,now)
        if nxt != 32 and nxt in pos:
            continue
        pos[i] = nxt
        dfs(level+1, p[nxt] + sum)
        pos[i] = now

i_b = list(map(int, input().split(" ")))
pos = [0,0,0,0]
dfs(0,0)
print(answer)
