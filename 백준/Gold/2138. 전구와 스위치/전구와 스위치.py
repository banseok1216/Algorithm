# 110 1번
# 011 1번
# 100 4번
# 101 2번
# 010 3번
# 001 4번
# 000 0번
# 111 1번
import copy

N = int(input())

s = list(map(int, input()))
t = list(map(int, input()))


def change(m):
    if m == 0:
        return 1
    if m == 1:
        return 0


# 첫번쨰거 클릭시
f1 = copy.deepcopy(s)
f1[0] = change(f1[0])
f1[1] = change(f1[1])
count = 1
answer = []
for i in range(1, N):
    if f1[i - 1] == t[i - 1]:
        pass
    else:
        if i == N-1:
            f1[i - 1] = change(f1[i - 1])
            f1[i] = change(f1[i])
            count += 1
        else :
            f1[i - 1] = change(f1[i - 1])
            f1[i] = change(f1[i])
            f1[i + 1] = change(f1[i + 1])
            count += 1
if f1[-1] == t[-1]:
    answer.append(count)
f1 = copy.deepcopy(s)
count = 0
for i in range(1, N):
    if f1[i - 1] == t[i - 1]:
        pass
    else:
        if i == N-1:
            f1[i - 1] = change(f1[i - 1])
            f1[i] = change(f1[i])
            count += 1
        else :
            f1[i - 1] = change(f1[i - 1])
            f1[i] = change(f1[i])
            f1[i + 1] = change(f1[i + 1])
            count += 1
if f1[-1] == t[-1]:
    answer.append(count)
if len(answer) == 0:
    print(-1)
else:
    print(min(answer))