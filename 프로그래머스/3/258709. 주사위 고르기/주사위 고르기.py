#A,B n개의 주사위를 가지고 승부 
#1~n의 번호를 가지고 있음
#n/2씩 가져간다
#n개의 리스트에서 중복순열을 통해 -> 
from itertools import combinations, product
import bisect

def solution(dice):
    L = len(dice)//2
    ansCount = 0
    ansList = []
    for a_dice in combinations(dice,L):
        b_dice = [i for i in dice if i not in a_dice]
        a_sum_list = []
        b_sum_list = []
        for items in product(range(6), repeat=L):
            a_sum = 0
            b_sum = 0
            for i in range(len(items)):
                a_sum += a_dice[i][items[i]]
                b_sum += b_dice[i][items[i]]
            a_sum_list.append(a_sum)
            b_sum_list.append(b_sum)
        a_sum_list.sort()
        b_sum_list.sort()
        a_sum = 0
        for target in b_sum_list:
            a_sum += bisect.bisect_left(a_sum_list,target)
        if a_sum > ansCount:
            ansCount = a_sum
            ansList = b_dice
        b_sum = 0
        for target in a_sum_list:
            b_sum+= bisect.bisect_left(b_sum_list,target)
        if b_sum > ansCount:
            ansCount = b_sum
            ansList = a_dice
    answer = []
    for i in range(len(dice)):
        for j in range(len(ansList)):
            if dice[i]  == ansList[j]:
                answer.append(i+1)
    return answer