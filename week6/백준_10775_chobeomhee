#include <bits/stdc++.h>
 
using namespace std;
typedef long long ll;
typedef pair<int, int> pi;
#define endl '\n'
#define fastio cin.tie(0)->sync_with_stdio(0)
#define X first
#define Y second
#define vi vector<int>
 
 
 
int p[100001];
 
 
int find(int a) {
  if (a == p[a]) return a;
  return p[a] = find(p[a]);
}
 
void uni(int a, int b) {
  a = find(a); b = find(b);
  
  if (a > b) {
    swap(a,b);
  }
 
  p[b] = a;
 
 
}
 
 
 
int main()
{
  fastio;
 
 
  int n, m, ans = 0;
  cin >> n >> m;
  for (int i = 0; i <= n; i++) p[i] = i;
 
  while (m--) {
    int a;
    cin >> a;
    
    a = find(a);
 
    if (a == 0) break;
 
    uni(a, a-1);
 
 
    ans++;    
 
  }
 
  cout << ans;
  
 
  
 
}
