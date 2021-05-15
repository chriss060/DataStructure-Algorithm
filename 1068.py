git remote add origin https://github.com/hye-on/study.git
git branch -M main
git push -u origin main
import sys
input = sys.stdin.readline
def dfs(num, arr):
    arr[num] = -2
    for i in range(len(arr)):
        if num==arr[i]:
            dfs(i,arr)
print("N값을 입력하세요\n")
n = int(input())
print("노드 리스트 입력하세요\n")
arr = list(map(int,input().split()))
print("삭제하고 싶은 노드를 입력하세요\n")
k = int(input())
count = 0

dfs(k,arr)

for i in range(len(arr)):
    if arr[i] != -2 and i not in arr:
        count += 1

print(count)
