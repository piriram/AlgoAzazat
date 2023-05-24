#include<iostream>
#include<vector>
#include<algorithm>
#include <queue>
using namespace std;
queue<pair<int, int>> Q;
int currentnumber[100001] = {0,};
int n, m;

bool visited[100001] = { false, };

void bfs() {
	while (!Q.empty()) {
		int cnt = Q.front().first;
		int here = Q.front().second;
		Q.pop();
		if (here == m) {
			vector<int> result;
			cout << cnt << '\n';
			int index = here;
			for(int i = 0; i < cnt; i++) {
				int tmp = currentnumber[index];
				index = tmp;
				result.push_back(tmp);
			}
			for (int i = cnt - 1; i > -1; i--) {
				cout << result[i] << " ";
			}
			cout << m;
			exit(0);
		}

		int nextX;

		nextX = here + 1;
		if (nextX < 100001 && visited[nextX] == false) {
			Q.push(make_pair(cnt + 1, nextX));
			currentnumber[nextX] = here;
			visited[nextX] = true;
		}

		nextX = here - 1;
		if (nextX > -1 && visited[nextX] == false) {
			Q.push(make_pair(cnt + 1, nextX));
			currentnumber[nextX] = here;
			visited[nextX] = true;
		}

		nextX = here * 2;
		if (nextX < 100001 && visited[nextX] == false) {
			Q.push(make_pair(cnt + 1, nextX));
			currentnumber[nextX] = here;
			visited[nextX] = true;
		}
	}
}

int main() {
	cin >> n >> m;
	Q.push(make_pair(0, n));
	bfs();
}
