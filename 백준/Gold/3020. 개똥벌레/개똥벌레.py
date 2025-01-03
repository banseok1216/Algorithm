import bisect
from bisect import bisect_left
import sys

# 동굴 길이 N 높이 H
input = sys.stdin.readline
N, H = map(int, input().split(" "))
check = [0 for _ in range(H)]
temp1 = []
temp2 = []
for i in range(N):
    target = int(input())
    if i % 2 == 0:
        temp1.append(-target)
    else:
        temp2.append(-target)
temp1.sort()
temp2.sort()
for i in range(1, H + 1):
    idx1 = bisect.bisect_right(temp1, -i)
    check[i - 1] += idx1
    idx2 = bisect.bisect_right(temp2, -i)
    check[H - i] += idx2

    # idx2 = bisect.bisect_right(temp2, i)
# target = []
answer = 100000000000000000000000
count = 0
for i in range(H):
    if answer > check[i]:
        answer = check[i]
        count = 1
    elif answer == check[i]:
        count += 1
print(str(answer) + " " + str(count))
