l = list(input().split("."))
flag = True
answer = ""
for s in l:
    count = len(s)
    if count % 2 == 1:
        flag = False
        break
    while count >= 4 and count != 0:
        count -= 4
        answer += "AAAA"
    while count >= 2 and count != 0:
        count -=2
        answer += "BB"
    answer += "."
if flag:
    print(answer[:-1])
else:
    print(-1)
