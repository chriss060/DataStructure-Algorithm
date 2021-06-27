# 1655 :가운데를 말해요
# 사용 알고리즘 : 이분 탐색
from bisect import bisect_left

n = int(input())  # 수빈이가 외치는 정수의 개수 : n
lst = []  # 입력받은 숫자를 저장할 리스트 선언

# 첫 번째 숫자 입력받기
num = int(input())
lst.append(num)
# 입력받은 숫자 수
count = 1

# 두 번째 숫자부터 차례대로 입력받기
for _ in range(n - 1):
    num = int(input())
    # 숫자가 삽입 될 인덱스 찾기
    index = bisect_left(lst, num)
    # 숫자 삽입, array 길이 1 증가
    lst.insert(index, num)
    count += 1

    if count % 2 == 0:  # 짝수개
        print(min(lst[(count // 2) - 1], lst[count // 2]))
    else:
        print(lst[count // 2])