s = input()

a1 = [x for x in s.split("0") if x]
a2 = [x for x in s.split("1") if x]

print(min(len(a1), len(a2)))