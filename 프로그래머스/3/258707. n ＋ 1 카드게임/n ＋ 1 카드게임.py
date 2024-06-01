#1~n개 사이의 카드 n/3장을 뽑아 -
#각 라운드 마다 카드를 두장 뽑는다-> 동전 소모 혹인 버리기
# 카드에 적힌 수의 합이 N+1 이되어야 다음 라운드 진행
# -> 1) 매턴 일단 받고 부족하면 찾아서 더하기 
from collections import deque
from itertools import combinations
        
def solution(coin, cards):
    globalCards = cards
    n = len(cards)
    checkList = [False for i in range(n+1)]
    deck = set(cards[:len(cards)//3])
    queue = deque(cards[len(cards)//3:])
    answer = 1
    isPossible = False
    entry = []
    while(len(queue) != 0):
        isPossible = False
        a = queue.popleft()
        b = queue.popleft()
        entry.append(a)
        entry.append(b)
        for index in combinations(deck,2):
            if(sum(index) == n+1):
                deck.remove(index[0])
                deck.remove(index[1])
                isPossible = True
                answer +=1
                break
        if isPossible:
            continue
        if coin>=1:
            for i in entry:
                if n+1-i in deck:
                    coin -=1
                    deck.remove(n+1-i)
                    entry.remove(i)
                    isPossible = True
                    answer +=1
                    break
        if isPossible:
            continue
        if coin >= 2:
            for index in combinations(entry,2):
                if(sum(index) == n+1):
                    entry.remove(index[0])
                    entry.remove(index[1])
                    isPossible = True
                    coin -=2
                    answer +=1
                    break
        if isPossible:
            continue  
        else:
            break
    return answer