n = int(input())
nums = []

for _ in range(n):
    nums.append(list(map(int,input().split())))

nums.sort(key = lambda x : x[1])
nums.sort(key = lambda x : x[0])

for i in range(n):
    print(*nums[i])
