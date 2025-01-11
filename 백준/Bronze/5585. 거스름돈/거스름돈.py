N = int(input())

t = 1000 - N
answer = 0
for num in 500, 100, 50, 10, 5, 1:
   answer += t // num
   t = t % num
print(answer)