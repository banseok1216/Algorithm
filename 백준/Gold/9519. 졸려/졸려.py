# 마지막 글자가 첫번째 글자와 두번째 글자 사이로 이동
#  뒤에서 2번째 글자가 두번쨰 글자와 세번째 글자 사이로 이동
# 뒤에서 k번째 글자는 앞에서 k번쨰와 K +1 번째 글자 시아로 이동한다.
# "abcdef -> "afbecd"로 이동

from collections import deque

N = int(input())

s = input()
s_count = s
s_len = len(s)
count = 0
flag = False
for i in range(N):
    aq = ""
    bq = ""
    for j in range(len(s)):
        c = s[j]
        if j % 2 == 1:
            bq += c
        else:
            aq += c
    s = ""
    s += aq
    s += bq[::-1]
    count += 1
    if s == s_count:
        N %= count
        flag = True
        break
if flag:
    for i in range(N):
        aq = ""
        bq = ""
        for j in range(len(s)):
            c = s[j]
            if j % 2 == 1:
                bq += c
            else:
                aq += c
        s = ""
        s += aq
        s += bq[::-1]
print(s)
