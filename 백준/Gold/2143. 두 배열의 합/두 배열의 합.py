# 한 배열 A[1] ~ [N]
N = int(input())
a = int(input())
a_list = list(map(int, input().split(' ')))
b = int(input())
b_list = list(map(int, input().split(' ')))

a_answer_set = {}
b_answer_set = {}
a_list_change = {}
b_list_change = {}
for i in range(a):
    temp = 0
    for j in range(i, a):
        temp += a_list[j]
        if temp not in a_answer_set:
            a_answer_set[temp] = 1
        else:
            a_answer_set[temp] += 1
for i in range(b):
    temp = 0
    for j in range(i, b):
        temp += b_list[j]
        if temp not in b_answer_set:
            b_answer_set[temp] = 1
        else:
            b_answer_set[temp] += 1
a_list = [[key, item] for key, item in a_answer_set.items()]
b_list = [[key, item] for key, item in b_answer_set.items()]
a_list.sort()
b_list.sort()
answer = 0
for a_num in a_list:
    top = len(b_list) - 1
    bottom = 0
    target = N - a_num[0]
    while bottom < top:
        mid = (top + bottom) // 2
        if b_list[mid][0] >= target:
            top = mid
        else:
            bottom = mid + 1
    if target == b_list[bottom][0]:
        answer += b_list[bottom][1] * a_num[1]
print(answer)
