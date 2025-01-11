# N X M 크기

a, b = map(int, input().split(" "))
answer = 1
if a < 2:
    pass
elif a == 2:
    answer = min(4, (b - 1) // 2 + 1)
else:
    if b < 6:
        answer = min(4, b)
    else:
        answer = b - 2
print(answer)