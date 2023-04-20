import copy

def recurcive(array, n):
    # 연산자 리스트 생성을 위한 재귀 함수
    if len(array) == n:
        operators_list.append(copy.deepcopy(array))  # 깊은 복사로 연산자 리스트에 추가
        return

    # 공백 추가 후 재귀호출
    array.append(' ')
    recurcive(array, n)
    array.pop()

    # '+' 추가 후 재귀호출
    array.append('+')
    recurcive(array, n)
    array.pop()

    # '-' 추가 후 재귀호출
    array.append('-')
    recurcive(array, n)
    array.pop()

t = int(input())  # 테스트케이스 개수 입력
for _ in range(t):
    n = int(input())  # 수의 개수 입력
    operators_list = []  # 연산자 리스트 초기화
    recurcive([], n - 1)  # 연산자 리스트 생성
    integer = [i for i in range(1, n+1)]  # 수 리스트 생성

    # 연산자 리스트를 이용해 수와 연산자를 조합하여 0이 되는 경우 출력
    for operator in operators_list:
        string = ""
        for i in range(n-1):
            string += str(integer[i]) + operator[i]
        string += str(integer[-1])
        if eval(string.replace(" ", "")) == 0:  # 수식을 계산하여 결과가 0인 경우
            print(string)
    print()  # 출력 형식 맞추기 위해 빈 줄 추가
