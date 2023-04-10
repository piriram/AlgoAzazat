// 부등호(DFS문제)

- 로직
- 0부터 9까지 각 자리에 넣어보기
- 좋은 문제
- 비슷한 문제가 많다
- 체크하는 boolean 배열 visited 생성
- 재귀를 실행하는 dfs 함수
- 인자로 String으로 넣는 것도 팁
- 숫자는 n+1 부등호 개수가 n개 이므로
- 결과를 담는 result 리스트
- 재귀를 돌릴 때 종료조건을 설정하는 것이 핵심
- cur.length() 맨처음ㅇ는 비교할 필요가 없다.
```java
visited[i]=true;
dfs(cur+i);
visited[i]=false//잠금해제
```


백트래킹이 별거인가 했는데 원래 내가 사용하던거엿다
