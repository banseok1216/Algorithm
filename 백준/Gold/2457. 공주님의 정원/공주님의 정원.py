N = int(input())
days = {
    0: 0,
    1: 31,
    2: 59,
    3: 90,
    4: 120,
    5: 151,
    6: 181,
    7: 212,
    8: 243,
    9: 276,
    10: 307,
    11: 337
}
dist = []
for i in range(N):
    dist_input = list(map(int, input().split(" ")))
    dist.append([
        days[dist_input[0] - 1] + dist_input[1],
        days[dist_input[2] - 1] + dist_input[3]
    ])
dist.sort()
answer = 0
temp_answer = False
temp_end = 0
line = 60  # 피는 날
end = 338  # 지는 날
for i in range(N):
    if dist[i][0] > line:
        break
    temp_end = max(temp_end, dist[i][1])
    if i < N-1 and dist[i + 1][0] <= line:
        continue
    line = temp_end
    answer += 1
    if temp_end >= end:
        temp_answer = True
        break
if temp_answer:
    print(answer)
else:
    print(0)
