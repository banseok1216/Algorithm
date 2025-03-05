# 선영이 직업 요리사
# M 명 모아서 맛을 테스트
# 동일한 소시지 N개
# p, bpppb, 1,2*n + 3

a, b = map(int, input().split(" "))
pet = [0 for _ in range(51)]
total = [0 for _ in range(51)]
pet[0] = 1
total[0] = 1
for i in range(1, 51):
    pet[i] = pet[i - 1] * 2 + 1
    total[i] = total[i - 1] * 2 + 3
p = 0

def hamburg(a, b):
    global p
    if b == 0:
        return
    if a == 0:
        p += 1
        return
    if b < total[a - 1] + 2:
        hamburg(a - 1, b - 1)
    elif b == total[a - 1] + 2:
        p += (pet[a - 1] + 1)
    elif b > total[a - 1] + 2:
        p += (pet[a - 1] + 1)
        hamburg(a - 1, b - total[a - 1] - 2)


hamburg(a, b)
print(p)
