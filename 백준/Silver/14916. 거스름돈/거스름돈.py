n = int(input())

answer = n // 5
left = n % 5
if left % 2 == 0:
    answer += left // 2
    left %= 2
else:
    if answer > 0:
        answer -= 1
        left += 5
        answer += left // 2
        left %= 2
if left != 0:
    answer = -1
print(answer)
