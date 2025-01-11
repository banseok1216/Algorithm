l = []
for _ in range(3):
    l.append(int(input()))
answer = ""
if l[0] == l[1] == l[2]:
    answer = "Equilateral"
if l[0] != l[1] and l[0] != l[2] and l[1] != l[2]:
    answer = "Scalene"
if (l[0] == l[1] and l[0] != l[2] and l[1] != l[2]) or (l[0] != l[1] and l[0] == l[2] and l[1] != l[2]) or (l[0] != l[1] and l[0] != l[2] and l[1] == l[2]):
    answer = "Isosceles"
if sum(l) != 180:
    answer = "Error"
print(answer)