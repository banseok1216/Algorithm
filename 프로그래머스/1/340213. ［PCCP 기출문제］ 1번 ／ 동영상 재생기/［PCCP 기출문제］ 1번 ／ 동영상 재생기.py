# 동영상 재생기 만들고 있음 10초 전 10초 후로 이동 오프닝 건너 뚜기
# 10초전으로 이동 prev 명령어 입력 10초전으로 이동 10초미만 이라면 처음 위치로 이동 영상의 처음 위치 0분 0초
# 10초 후 이동 남은 시간 10 초 미망ㄴ 영상 마지막 위치
# 오프닝 구간이면 뛰어 넘기 가능 mm ss 형식으로 출력
def solution(video_len, pos, op_start, op_end, commands):
    vm , vs = map(int, video_len.split(":"))
    pm , ms = map(int, pos.split(":"))
    osm, oss = map(int, op_start.split(":"))
    oem, oes = map(int, op_end.split(":"))
    
    video_len = vm * 60 + vs
    pos = pm * 60 + ms
    op_start = osm * 60 + oss
    op_end = oem * 60 + oes
    
    print(pos)
    
    for s in commands:
        if op_start<= pos <= op_end:
            pos = op_end
            
        if s == "next":
            pos += 10
            if pos >= video_len:
                pos = video_len
        else:
            pos -= 10
            if pos <= 0:
                pos = 0
                
        if op_start<= pos <= op_end:
            pos = op_end 
    ansm = str(pos //60)
    anss = str(pos %60)
    while len(ansm) != 2:
        ansm = "0" + ansm
    while len(anss) != 2:
        anss = "0" + anss
    answer = ansm + ":" + anss
    return answer