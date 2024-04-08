from itertools import combinations, product
import bisect

def solution(dice):
    dic = {}
    L = len(dice)
    ans =0
    maxAns=[]
    for A_index_combi in combinations(dice, L//2):
        B_index_combi = [i for i in dice if i not in A_index_combi]
        A, B = [], []
        for order_product in product(range(6), repeat=L//2):
            sumA =0
            sumB =0
            for j in range(L//2):
                    sumA+=A_index_combi[j][order_product[j]]
                    sumB+=B_index_combi[j][order_product[j]]
            A.append(sumA)
            B.append(sumB)
        A.sort()
        B.sort()
        maxSum =0
        for i in A:
            maxSum += bisect.bisect_left(B, i)
        if ans < maxSum:
            ans = maxSum
            maxAns = A_index_combi
        maxSum = 0
        for i in B:
            maxSum += bisect.bisect_left(A, i)
        if ans < maxSum:
            ans = maxSum
            maxAns = B_index_combi
    answer = []
    for index in range(len(dice)):
        for j in maxAns:
            if dice[index] == j:
                answer.append(index+1)
    return answer