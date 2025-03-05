# 선플레이어가 홀수 후 플레이어가 짝수
# 매차례 플레이어 두범 선택, 연결하는 선분을 긋는데 이전에 그린 선분을 그울 수는 없지만
# 다른 선분과 교차하는 것은 가능


n, m = map(int, input().split(" "))
arr = [i for i in range(n)]


def find(x):
    if x == arr[x]:
        return x
    arr[x] = find(arr[x])
    return arr[x]


answer = 0


def union(a, b, n):
    global answer
    a = find(a)
    b = find(b)
    if a != b:
        arr[max(a, b)] = min(a, b)
    elif answer == 0:
        answer = n


for i in range(m):
    a, b = map(int, input().split(" "))
    union(a, b, i+1)
print(answer)
