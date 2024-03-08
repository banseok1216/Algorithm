
import sys
from collections import deque
input = sys.stdin.readline

if __name__ == '__main__':
    front = True
    list1 = list(input().rstrip())
    list2 = list(input().rstrip())
    que = deque()
    for i in range(len(list2)):
        que.append(list2[i])
    while(len(que) != len(list1)):
        if(front):
            if (que[-1] == "B"):
                que.pop()
                front = False
            elif  (que[-1] == "A"):
                que.pop()
        else:
            if (que[0] == "B"):
                que.popleft()
                front = True
            elif  (que[0] == "A"):
                que.popleft()
    count =0
    ans = 1
    while(que):
        if (front):
            if list1[count] != que.popleft():
                ans = 0
                break
            count +=1
        else:
            if list1[count] != que.pop():
                ans = 0
                break
            count += 1
    print(ans)

