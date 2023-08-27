import sys
input = sys.stdin.readline

N, C = map(int, input().split())
coord = []
for i in range(N):
  coord.append(int(input()))
coord.sort()

start = 1 # 최소 거리
end = coord[-1] - coord[0] # 최대 거리
ans = 0

while start <= end:
  cur = coord[0]
  cnt = 1
  mid = (start+end) // 2

  for i in range(1, len(coord)):
    if coord[i] >= cur + mid:
      cur = coord[i]
      cnt += 1
  if cnt >= C:
    start = mid + 1
    ans = mid
  else:
    end = mid - 1
    
print(ans)
