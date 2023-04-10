#include<iostream>
#include<vector>
#include<string>
#include<algorithm>
using namespace std;

int N;
vector<int> vec;
vector<char> operators;
vector<string> answer;

bool visited[10] = { false, };
void dfs(string str) {
	if (str.size() == N + 1) { // 완성본이면
		answer.push_back(str);
		return;
	}

	for (int i = 0; i < 10; i++) {
		if (visited[i]) continue;

		if (str.size() == 0) { // 처음!
			visited[i] = true;
			str.push_back(i + '0');
			dfs(str);
			str.pop_back();
			visited[i] = false;
		}
		else { // 처음이 아님 비교 연산 필요
			if (operators[str.size() - 1] == '>') {
				if (str[str.size() - 1] - '0' > i) {
					visited[i] = true;
					str.push_back(i + '0');
					dfs(str);
					str.pop_back();
					visited[i] = false;
				}
			}
			else {
				if (str[str.size() - 1] - '0' < i) {
					visited[i] = true;
					str.push_back(i + '0');
					dfs(str);
					str.pop_back();
					visited[i] = false;
				}
			}
		}
	}
}


int main() {
	cin >> N;

	for (int i = 0; i < N; i++) {
		char tmp;
		cin >> tmp;

		operators.push_back(tmp);
	}

	dfs("");

	sort(answer.begin(), answer.end());
	cout << answer[answer.size() - 1] << '\n';
	cout << answer[0] << '\n';
}