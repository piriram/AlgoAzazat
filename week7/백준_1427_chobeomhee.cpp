#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int newlist[1000000];

void merge(int array[], int left, int mid, int right) {
	int i, j, k, l;
	i = left;
	j = mid + 1;
	k = left;

	while (i <= mid && j <= right) {
		if (array[i] <= array[j])
			newlist[k++] = array[i++];
		else
			newlist[k++] = array[j++];
	}

	if (i > mid)
		for (l = j; l <= right; l++)
			newlist[k++] = array[l];
	else
		for (l = i; l <= mid; l++)
			newlist[k++] = array[l];
	for (l = left; l <= right; l++) {
		array[l] = newlist[l];
	}

}

void mergesort(int array[], int left, int right) {
	int mid;
	if (left < right) {
		mid = (right + left) / 2;
		mergesort(array, left, mid);
		mergesort(array, mid + 1, right);
		merge(array, left, mid, right);
	}
}

int convert(char a) {
	int num;

	num = a - '0';

	return num;
}

int main()
{
	char* number;
	int* num;

	number = (char*)malloc(sizeof(char) * 10000000);
	num = (int*)malloc(sizeof(char) * 10000000);
	scanf("%s", number);

	for (int i = 0; i < strlen(number); i++) {
		num[i] = convert(number[i]);
	}
	mergesort(num, 0, strlen(number) - 1);

	for (int i = strlen(number) - 1; i > -1; i--)
		printf("%d", num[i]);

	return 0;
}

