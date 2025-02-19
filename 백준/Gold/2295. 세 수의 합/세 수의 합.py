N = int(input())
data = sorted(set(int(input()) for _ in range(N)))  # 중복 제거 후 정렬
s = set(data)

ans = 0

# 두 개의 수를 고정하고, 세 번째 숫자를 찾음
for i in range(len(data)):
    for j in range(i, len(data)):  # i부터 시작하여 중복 방지
        for k in range(j, len(data)):  # j부터 시작하여 중복 방지
            total = data[i] + data[j] + data[k]
            if total in s:
                ans = max(ans, total)

print(ans)
