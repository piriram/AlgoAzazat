N = int(input())

nlist = list(map(int, input().split()))
maxN = int(input())

start, end = 0, max(nlist)

while start <= end:
  mid = (start + end) // 2
  sumN = 0
  for i in nlist:
    if i > mid:
      sumN += mid
    else:
      sumN += i
  if sumN > maxN:
    end = mid - 1
  else:
    start = mid + 1

print(end)
