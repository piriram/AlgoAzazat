N = int(input())
nlist = []

for i in range(N):
  x, y = input().split()
  x = int(x)
  y = int(y)
  nlist.append([x, y])

nlist.sort()

for i in nlist:
  print (i[0], i[1])
