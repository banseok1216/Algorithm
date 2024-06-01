#하나의 큐 골라 pop -> 추출된 원소 다른 큐에? -> 최소 횟수 -> pop 관 insert 모두 동일
#1,2,3,4 pop 맨 앞의 원소 1 추출 -? insert라 -> 방안 bfs? 그리디 가능 한가? -> 완전 탐색해야함
from collections import deque
def solution(queue1, queue2):
    a_queue = queue1 + queue2
    b_queue = queue2 + queue1
    answer = -1
    a_sum = sum(queue1)
    b_sum = sum(queue2)
    a_point = 0
    b_point = 0
    count = 0
    while True:
        if a_point >= len(queue1) and a_point % len(queue1) >= b_point:
            break
        if b_point >= len(queue1) and b_point % len(queue1) >= a_point:
            break
        if a_point == len(a_queue):
            break
        if b_point == len(a_queue):
            break
        if a_sum > b_sum:
            a_sum -= a_queue[a_point]
            b_sum += a_queue[a_point]
            queue2.append(a_sum)
            a_point +=1
            count+=1
        elif a_sum < b_sum:
            b_sum -= b_queue[b_point]
            a_sum += b_queue[b_point]
            b_point +=1
            count+=1
        else:
            answer = count
            break
    return answer