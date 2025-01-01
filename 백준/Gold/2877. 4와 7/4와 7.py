import math

K = int(input())
m = 1
s = K
answer = "4"
while m * 2 < s:
    m *= 2
    s -= m
    answer += "4"
answer = list(answer)
count = len(answer)
while count != 0:
    if s % 2 == 0:
        answer[count - 1] = "7"
        s /= 2
    else:
        s += 1
        s /= 2
    count -= 1
print(''.join(answer))
