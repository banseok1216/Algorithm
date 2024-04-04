N = int(input())
lst = list(map(int, input().split(" ")))
M = int(input())
end = max(lst)
start = 0
ans = 0

while start <= end:
    mid = (start + end) // 2
    new_lst = [min(x, mid) for x in lst]  # Adjusting the list as per the problem requirements
    total = sum(new_lst)
    if total <= M:
        ans = mid
        start = mid + 1
    else:
        end = mid - 1

print(ans)
