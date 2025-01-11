N = int(input())
answer = []
count = 0
for num in 300, 60, 10:
    answer.append(N // num)
    N %= num
if N !=0 :
    print(-1)
else:
    print(" ".join(map(str, answer)))
