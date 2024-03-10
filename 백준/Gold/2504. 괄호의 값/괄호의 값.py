import sys
from collections import deque

input = sys.stdin.readline


def check(s1, s2):
    if s1 == "(" and s2 == ")":
        return 2
    if s1 == "[" and s2 == "]":
        return 3
    return 0


Hashset = set()
Hashset.add("(")
Hashset.add("[")
Hashset.add(")")
Hashset.add("]")
board = list(map(str, input().strip()))
que = deque()
ans = 0
for i in range(len(board)):
    if len(que) == 0:
        que.append(board[i])
    else:
        if que[-1] in Hashset:
            sum = check(que[-1], board[i])
            if sum == 0:
                que.append(board[i])
            else:
                que.pop()
                while len(que) != 0 and que[-1] not in Hashset:
                    index = int(que.pop())
                    sum += index
                que.append(sum)
        else:
            if len(que) >= 2:
                sum = check(que[-2], board[i])
                if sum == 0:
                    que.append(board[i])
                else:
                    index = que.pop()
                    que.pop()
                    sum *= index
                    while len(que) != 0 and que[-1] not in Hashset:
                        index = int(que.pop())
                        sum += index
                    que.append(sum)
            else:
                que.append(board[i])
if (len(que) >= 2 or len(que) == 0):
    print(0)
elif que[-1] in Hashset:
    print(0)
else:
    print(que[-1])
