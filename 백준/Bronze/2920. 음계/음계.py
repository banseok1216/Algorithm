l = list(map(int, input().split(" ")))
answer = "mixed"
flag = False
for i in range(8):
    if l[i] != i + 1:
        flag = True
if not flag:
    answer = "ascending"
flag = False
for i in range(8):
    if l[i] != 8 - i:
        flag = True
if not flag:
    answer = "descending"
print(answer)