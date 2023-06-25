import sys
input = sys.stdin.readline

def find(x):
  if x != parents[x]: 
    parents[x] = find(parents[x])
  return parents[x] # 이어져있는 간선의 목적지를 찾음
  # 재귀적으로 경로압축한다.

def union(x,y):
  x = find(x)
  y = find(y)
  if x < y:
    parents[y]=x # ??
  else:
    parents[x]=y
# 그래프의 모든 간선 정보가 주어졌을 때
# Union Find연산으로 서로소 집합을 찾는다.
# 루트노드를 재귀적으로 찾는다.

n = int(input()) # 도시의 수
m = int(input()) # 여행 도시의 개수

parents = [i for i in range(n)]
for i in range(n):
  link = list(map(int,input().split())) # 간선 연결 정보를 받는다.
  for j in range(n):
    if link[j] == 1: # i-j가 연결되어 있다면
      union(i,j) # 문제에서 주는 대로 간선을 연결

# 경로 찾기
parents = [-1] + parents # 맨앞에 인덱스 -1을 추가해 시작위치 바꿈
path = list(map(int,input().split()))
start = parents[path[0]]
for i in range(1,m):
  if parents[path[i]] != start:
    print("NO")
    break

else:
  print("YES")
      

