T = int(input()) #테스트 케이스의 개수
for _ in range(T):
    N = int(input()) # 날의 수
    prices = list(map(int, input().split())) #줄의 개수

    max_price = prices[-1] #리스트의 마지막 요소를 참조
    profit = 0

    for i in range(N-2, -1, -1):
        if prices[i] > max_price:
            max_price = prices[i]
        else:
            profit += max_price - prices[i]
    
    print(profit)
