# n,k 값 입력받음
n, k = map(int, input().split())
# (무게, 가치) 튜플 사전 {0:(6,13), 1:(4,8), 2:(3,6), 3:(5,12)}
dic = {}
for i in range(n):
    w, v = map(int, input().split())
    dic[i]=(w,v)

# NxK 행렬 만들기
lst= [[0]*(k+1) for _ in range(n)]
#행렬의 첫번째 행 설정
firstTuple = dic[0]
firstW, firstV = firstTuple

#첫번째 칼럼 무게한도(k) 까지 초기화
for i in range(1, k+1) :
    if firstW<=i :
        lst[0][i]=firstV
    else:
        lst[0][i]=0
#
for r in range(1,n): # r: 아이템수, c:최대 수용 무게
    weight, value= dic[r]
    for c in range(1,k+1):
        if weight<= c: # 이번 항목을 포함한 경우의 최댓값
            lst[r][c]= max(lst[r-1][c],value+lst[r-1][c-weight])
        else: # 이번 항목으로 포함할 수 없으면 이전 항목을 포함한 것 까지 최댓값취하기
            lst[r][c]=lst[r-1][c]

# dp array의 마지막 엔트리 출력
print(lst[-1][-1])