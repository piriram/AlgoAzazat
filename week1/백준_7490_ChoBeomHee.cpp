#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

string opbox = "";

char op[3] = { '+', '-', ' ' };
int opSize;
int N;
int cnt = 1;

vector<string> answer;

bool check(string str) {
	for (int i = 0; i < str.size(); i++) {
		if (str[i] == ' ')
			str.erase(str.begin() + i);
	}
	char op = '-1';
	int tmp = 0;
	int result = 0;
	for (int i = 0; i < str.size(); i++) {
		if (str[i] == '+') { // 연산자이면
			op = '+';
		}
		else if (str[i] == '-') {
			op = '-';
		}
		else { // 연산자가 아님
			tmp = (str[i] - '0');
			int t = i + 1;
			for (int j = t; j < str.size(); j++) {
				if (str[j] != '+' && str[j] != '-') {
					tmp = tmp * 10 + (str[j] - '0');
					i++;
				}
				else {
					break;
				}
			}

			if (op == '+')
				result += tmp;
			else if (op == '-')
				result -= tmp;
			else
				result += tmp;

		}
	}
	return result == 0;
}

void dfs() {
	if (opbox.size() == opSize) {
		int opindex = 0;
		string checkstring = "";
		//cout << cnt << "   ";
		for (int i = 0; i < N; i++) {
			checkstring.push_back(i + 1 + '0');
			if (i != N - 1)
				checkstring.push_back(opbox[i]);
		}
		if (check(checkstring))
			answer.push_back(checkstring);
		return;
	}

	for (int i = 0; i < 3; i++) {
		opbox.push_back(op[i]);
		dfs();
		opbox.pop_back();
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	int M;
	cin >> M;

	for (int i = 0; i < M; i++) {
		cin >> N;
		opSize = N - 1;
		dfs();

		sort(answer.begin(), answer.end());

		for (string a : answer) cout << a << '\n';
		cout << '\n';
		opbox.clear();
		answer.clear();
	}
}
