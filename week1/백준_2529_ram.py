n = int(input())  
inequality = input().split()  # 부등호 문자열을 입력받아서 공백으로 구분하여 리스트에 저장
check = [False] * 10  # 0부터 9까지의 숫자 사용여부를 저장하는 리스트 생성
max, min = "", ""  # 최대값과 최소값을 저장할 변수 생성

def possible(i, j, k):  # i와 j를 비교하여 부등호에 따라 결과를 반환하는 함수
    if k == '<':
        return i < j
    if k == '>':
        return i > j
    return True

def DFS(depth, s):  # DFS 알고리즘을 이용한 모든 경우의 수 탐색 함수
    global max, min
    if depth == n + 1:  # 부등호 문자열 개수+1(depth)과 길이가 같은 문자열(s)이 만들어졌을 때,
        if not len(min):  # 최소값이 저장되어 있지 않으면,
            min = s  # s를 최소값으로 저장
        else:  # 최대값을 저장하기 위해서는 이미 최소값이 저장되어 있어야 함
            max = s  # s를 최대값으로 저장
        return
    for i in range(10):  # 0부터 9까지 모든 숫자에 대해서
        if not check[i]:  # 사용되지 않은 숫자일 경우
            if depth == 0 or possible(s[-1], str(i), inequality[depth - 1]):  # 첫 숫자일 경우는 부등호 비교할 필요 없음
                # 또는 이전에 만들어진 문자열의 마지막 숫자와 i를 비교하여 부등호를 만족하는 경우에만 다음 depth로 진행
                check[i] = True  # 숫자 i를 사용했음을 체크
                DFS(depth + 1, s + str(i))  # depth를 1 증가시키고 문자열 s에 i를 추가하여 DFS 호출
                check[i] = False  # DFS 호출 이후 다른 경우의 수를 고려하기 위해 사용한 숫자 i를 해제

DFS(0, "")  # DFS 함수 호출
print(max)  # 최대값 출력
print(min)  # 최소값 출력



