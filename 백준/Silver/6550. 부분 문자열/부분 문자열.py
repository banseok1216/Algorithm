# s와 t가 부분 문자열 판단

# t여러거 제거 이를 순서 바꾸조않고 함치면 s


import sys

while True:
    try:
        s, t = input().split(" ")
        c = 0
        for i in range(len(t)):
            if c == len(s):
                break
            if t[i] == s[c]:
                c += 1
        if c == len(s):
            print("Yes")
        else:
            print("No")
    except EOFError:
        break
