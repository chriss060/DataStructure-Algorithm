n = int(input())
k = int(input())
s, e = 1, k
while s <= e:
    m = (s+e)//2
    count = 0
    for i in range(1, n+1):
        count += min(n, m//i)
    if count < k:
        s = m+1
    else:
        e = m-1

print(s)

