#충돌 위험 찾기
# 물류 센터 (r,c) 존재 n 개의 포인트
# 운송경로 존재 m개의 포인트 존재 첫 포인트 -> 할당 된 포인트로
def solution(points, routes):
    n = len(points)
    d = dict()
    for point in range(1,n+1):
        d[point] =  points[point-1]
    ans = dict()
    
    for route in routes:
        r = len(route)
        count = 0
        s, e = d[route[0]], d[route[1]]
        sX, sY = s[0], s[1]
        eX, eY = e[0], e[1]
        if (sX, sY, count) in ans:
            ans[(sX, sY, count)]  += 1
        else:
            ans[(sX, sY, count)]  = 0
        for i in range(r-1):
            s, e = d[route[i]], d[route[i+1]]
            sX, sY = s[0], s[1]
            eX, eY = e[0], e[1]
            if sX > eX:
                while sX != eX:
                    sX -= 1
                    count += 1
                    if (sX, sY, count) in ans:
                        ans[(sX, sY, count)]  += 1
                    else:
                        ans[(sX, sY, count)]  = 0
            if sX < eX:
                while sX != eX:
                    sX += 1
                    count += 1
                    if (sX, sY, count) in ans:
                        ans[(sX, sY, count)]  += 1
                    else:
                        ans[(sX, sY, count)]  = 0
            if sY > eY:
                while sY != eY:
                    sY -= 1
                    count += 1
                    if (sX, sY, count) in ans:
                        ans[(sX, sY, count)]  += 1
                    else:
                        ans[(sX, sY, count)]  = 0 
            if sY < eY:
                while sY != eY:
                    sY += 1
                    count += 1
                    if (sX, sY, count) in ans:
                        ans[(sX, sY, count)]  += 1
                    else:
                        ans[(sX, sY, count)]  = 0
    answer = 0
    for _, num in ans.items():
        if num != 0:
            answer += 1
    return answer