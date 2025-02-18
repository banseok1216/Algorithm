N = int(input())
l = [[0,0] for _ in range(N)]
input_list = list(map(int, input().split(" ")))
for i in range(N):
    if i ==0:
        l[i][0] = 0
        l[i][1] =  input_list[i]
        continue
    if i == 1:
        l[i][0] = l[i-1][1]
        l[i][1] = input_list[i]
        continue
    l[i][0] = l[i-1][1]
    l[i][1] = min(l[i-1][0], l[i-1][1]) + input_list[i]

print(min(l[N-1]))