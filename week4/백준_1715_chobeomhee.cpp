#include<iostream>
#include<queue>
using namespace std;

priority_queue<int, vector<int>, greater<int>> q;

int main() {
	int N;
	cin >> N;

	for (int i = 0; i < N; i++) {
		int tmp;
		cin >> tmp;
		q.push(tmp);
	}

	int answer = 0;
	int cnt = 0;
	int sum = 0;
	int total = 0;
	while (!q.empty()) {
		cnt++;
		total++;
		int x = q.top();
		q.pop();
		sum += x;
		if (cnt == 2) {	
			answer += sum;
			q.push(sum);
			sum = 0;
			cnt = 0;
		}
	}
	cout << answer << '\n';
}
