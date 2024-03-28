N = int(input())
hashmap = {}
for i in range(N):
    a = input()
    if not a in hashmap:
        hashmap[a] =0
    else:
        hashmap[a] += 1
count =-1
ans = ""
for key, value in hashmap.items():
    if ans == "":
        ans = key
        count = value
    elif value == count:
            if ans>key:
                ans = key
    elif value > count:
        ans = key
        count = value
print(ans)