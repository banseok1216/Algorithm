import collections

l = list(input())
d = dict()
for c in l:
    if c in dict.keys(d):
        d[c] += 1
    else:
        d[c] = 1
count = 0
check = []
one = []
q = collections.deque()
for k in dict.keys(d):
    if d[k] % 2 == 0:
        check.append([k, d[k]])
        pass
    else:
        one.append(k)
        check.append([k, d[k] - 1])
        count += 1
check.sort(reverse=True)
if count == 1:
    q.append(one[0])
    for num, c in check:
        for _ in range(c // 2):
            q.append(num)
            q.appendleft(num)
    print("".join(q))
elif count == 0:
    for num, c in check:
        for _ in range(c // 2):
            q.append(num)
            q.appendleft(num)
    print("".join(q))
else:
    print("I'm Sorry Hansoo")
