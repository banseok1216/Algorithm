A , B = map(int, input().split(" "))

minA = str(A)
minA = minA.replace("6","5")
minB = str(B)
minB = minB.replace("6","5")
maxA = str(A)
maxA =maxA.replace("5","6")
maxB = str(B)
maxB = maxB.replace("5", "6")

print(str(int(minA) + int(minB)) + " " + str(int(maxB) + int(maxA)) )