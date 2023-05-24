#include<iostream>
#include<queue>
using namespace std;
int n, m;

queue<int> q;
int d[] = { 1,-1 };
bool visited[100001] = { false, };
int t[100001] = {0};
void bfs() {
    q.push((n));
    visited[n] = true;
    while (!q.empty()) {
        int x = q.front();
        q.pop();

        if (x == m) {
            cout << t[m] << '\n';
            return;
        }
        for (int i = 0; i < 2; i++) {
            int nx = x + d[i];
            if (nx > -1 && nx <= 100001 && visited[nx] == false) {
                q.push(nx);
                visited[nx] = true;
                t[nx] = t[x] + 1;
            }
        }
        int nx = 2 * x;
        if (nx <= 100001 && visited[2 * x] == false) {
            q.push(nx);
            visited[nx] = true;
            t[nx] = t[x] + 1;
        }
    }
}

int main() {
    cin >> n >> m;

    bfs();
}
