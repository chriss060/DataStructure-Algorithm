import sys
input = sys.stdin.readline
def dfs(num, arr): #전달받은 index 배열 값 삭제 :-2
    arr[num] = -2
    for i in range(len(arr)):
        if num==arr[i]:
            dfs(i,arr) #방금 삭제한 index의 부모노드이면 재귀함수

n = int(input()) #전체 노드 개수 n
arr = list(map(int,input.split()))

k = int(input()) #삭제하고 싶은 인덱스 k
count = 0 #리프 노드 개수 초기화

dfs(k,arr) #노드 삭제
#리프노드 수 count
for i in range(len(arr)):
    if arr[i] != -2 and i not in arr:
        count += 1
#리프노드 수 출력
print(count)
