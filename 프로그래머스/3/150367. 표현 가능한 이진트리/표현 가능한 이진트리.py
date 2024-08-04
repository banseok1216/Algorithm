import math

result = True

def findBit(number):
    bit = ""
    while number != 0:
        bit = str(number % 2) + bit
        number //= 2
    return bit

def makefull(bit):
    log2_value = int(math.log2(len(bit))) + 1
    bit = "0" * (int(math.pow(2, log2_value)) - 1 - len(bit)) + bit
    return bit

def dfs(bit, root, count, check):
    global result
    if bit[root-1] == "0":
        check = False
    if count == 0 or not result:
        return
    left = root - count
    right = root + count
    if bit[left-1] == "0" and check:
        dfs(bit, left, count // 2, False)
    if bit[right-1] == "0" and check:
        dfs(bit, right, count // 2, False)
    if bit[left-1] == "1" and check:
        dfs(bit, left, count // 2, True)
    if bit[right-1] == "1" and check:
        dfs(bit, right, count // 2, True)
    if bit[left-1] == "1" and not check:
        result = False
        return
    if bit[right-1] == "1" and not check:
        result = False
        return
    if bit[left-1] == "0" and not check:
        dfs(bit, left, count // 2, check)
    if bit[right-1] == "0" and not check:
        dfs(bit, right, count // 2, check)

def solution(numbers):
    global result
    answer = []
    for number in numbers:
        temp = makefull(findBit(number))
        root = len(temp) // 2 +1
        result = True
        dfs(temp, root, root // 2, True)
        if not result:
            answer.append(0)
        else:
            answer.append(1)
    return answer