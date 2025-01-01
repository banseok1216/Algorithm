a = dict()

s = input()
for i in s:
    if i in a:
        a[i] += 1
    else:
        a[i] = 1
six = 0
nine = 0
max_num = 0
for num in a.keys():
    if num == "9":
        nine = a[num]
        continue
    if num == "6":
        six = a[num]
        continue
    max_num = max(max_num, a[num])
t = six + nine
if t % 2 == 1:
    t /= 2
    t += 1
else:
    t /= 2
print(max(max_num, int(t)))
