for i in range(int(input())):
  ans = 0
  day = int(input())
  price = list(map(int, input().split()))
  maxN = 0
  price.reverse()
  for k in price:
    if maxN > k :
      ans += (maxN - k)
    else:
      maxN = k
  print(ans)
