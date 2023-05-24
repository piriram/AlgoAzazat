#include<iostream>
#include<algorithm>
#include<cmath>
#include<vector>
#include<map>
#include<queue>

#define MAX 51

using namespace std;

queue<pair<int, int>> Q;
int x, y;
bool visited[100001] = {false,};
int cnt = 0;
int answer = 0;
int Time = -2;
void BFS() {
	Q.push(make_pair(x, 0));
	while (!Q.empty()) {
		int X = Q.front().first;
		int T = Q.front().second;
		
		visited[X] = true;

		Q.pop();

		if (X == y && Time == -2) {
			Time = T;
			cnt++;
		}
		else if (X == y && Time == T) {
			cnt++;
		}

		if (X + 1 < 100001 && visited[X + 1] == false) {
			Q.push(make_pair(X + 1, T + 1));
			//visited[X + 1] = true;
		}

		if (X - 1 > -1&& visited[X - 1] == false) {
			Q.push(make_pair(X - 1, T + 1));
			//visited[X - 1] = true;
		}

		if (2 * X < 100001 && visited[2 * X] == false) {
			Q.push(make_pair(2 * X, T + 1));
			//visited[2 * X] = true;
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> x >> y;

	BFS();
	cout << Time << '\n';
	cout << cnt << '\n';
}
