# k 점 더많이 맞혔을 경우 더많이 맟힌 선수가 k점 가져감
# a==b 어피치가 k점 가져감 -> 나는 라이언
# a==b==0 아무도 점수 X
# 주의 사항 k점만 가져간다 여러번 X
# 최종점수가 같으면 어피치 우승자
#info 0이라면 10점 가장 큰 점수차 로 결과값 없다면  [-1] 리턴
# 어차피 이기려면 부조건 어퍼치보다 더 많이 먹어야함
from collections import deque
def solution(n, info):
    queue = deque()
    firstSum = 0
    for i in range(len(info)):
        if info[i] != 0:
            firstSum += (10-i)
    queue.append((0,0,n,[]))
    answer = [-1]
    countAns = []
    ansSum = firstSum
    while queue:
        index,countSum,left,entry = queue.popleft()
        if len(entry) == 11 and countSum > firstSum and countSum >= ansSum:
            if ansSum == countSum:
                countAns.append(entry[0:10] + [entry[10] + left])
            else:
                ansSum = countSum
                countAns = []
                countAns.append(entry[0:10] + [entry[10] + left])
        if index > len(info)-1:
            continue
        queue.append((index+1,countSum,left,entry+[0]))
        if info[index] >= left:
            continue
        if info[index] != 0:
            queue.append((index+1,countSum + 2*(10 - index),left-info[index]-1,entry+[info[index]+1]))
        else:
            queue.append((index+1,countSum + 10 - index,left-info[index]-1,entry+[info[index]+1]))
    countAns.sort(reverse= True,key=lambda x: x[::-1])
    if len(countAns) == 0:
            return [-1]     
    return countAns[0]