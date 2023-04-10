def dfs(cnt, num):
    if len(num) == n + 1:
        result.append(num)
        return

    for i in range(10):

        if visited[i] == 1:  # 이미 방문 했으면 pass
            continue

        if cnt == 0 or (paren[cnt-1] == '<' and num[cnt - 1] < str(i)) or (
                paren[cnt-1] == '>' and num[cnt - 1] > str(i)):
            visited[i] = 1
            dfs(cnt + 1, num + str(i))
            visited[i] = 0  # 실패하고 되돌아오면 방문철회


n = int(input())
paren = list(map(str, input().split()))
visited = [0] * 10
result = []
dfs(0, "")
print(result[-1])
print(result[0])
