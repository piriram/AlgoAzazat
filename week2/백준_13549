#include<iostream>
#include<algorithm>
#include<deque>

#define MAX 100001

using namespace std;

int N, M;
bool visited[MAX] = { false, };
deque<pair<int, int>> Q;
int dis[MAX] = {0,};

void BFS() {
	Q.push_front(make_pair(N, 0));
    
	while (!Q.empty()) {
		int x = Q.front().first;
		int t = Q.front().second;
	    visited[x] = true;	
		Q.pop_front();

		if (x == M) {
			cout << t;
		}

		if (x * 2 < MAX && visited[x * 2] == false) {
			Q.push_front(make_pair(x * 2, t));
			visited[x * 2] = true;
		}
if (x - 1 > -1 && visited[x - 1] == false) {
			Q.push_back(make_pair(x - 1, t + 1));
			visited[x - 1] = true;
		}
		if (x + 1 < MAX && visited[x + 1] == false) {
			Q.push_back(make_pair(x + 1, t + 1));
			visited[x + 1] = true;
		}

		
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);	cout.tie(NULL);
	cin >> N >> M;

	BFS();
}
