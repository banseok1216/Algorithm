import math
def is_prime(num):
    if num<2:
        return False
    for i in range(2,int(math.sqrt(num))+1):
        if num % i ==0:
            return False
    return True
    
def solution(n, k):
    count = ""
    answer = 0
    while n != 0:
        count= str(n%k)  + count
        n//=k
    list1 = list(count.split("0"))
    for i in range(len(list1)):
        if list1[i] != "" and is_prime(int(list1[i])):
            answer +=1
    return answer