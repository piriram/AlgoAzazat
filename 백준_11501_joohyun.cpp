#include <stdio.h>
int main(void)
{
	long long profit=0; //최대이익 
	long long p[1000000]; // test case 별 최대이익 

  int t;
	scanf("%d", &t);
	
	for(int l=0; l<t; l++){

    int n;
		scanf("%d", &n);
		
		int stock[1000000]; //주가 
		for(int i=0;i<n;i++){
			scanf("%d", &stock[i]);
		}
		
		long long max = 0;
		
		for(int j=n-1 ; j>=0 ; j--){ //뒤에서부터 max 가격 찾기 
			
			if(max<stock[j]){
				max = stock[j];
			}
			else{
				profit += (max - stock[j]);
			}
	
		}
		//printf("%lld\n", profit);
		p[l] = profit;
		profit = 0;

	} 
	
	for(int r=0; r<t; r++){
		printf("%lld\n", p[r]);
	}
	
	return 0;

}
