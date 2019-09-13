/* calculate the mean, median and mode for an array of integers */ 

#include <stdio.h>

#define ARRAY_SIZE 19
// mean return the mean for an array of integers.
float mean(int arr[ARRAY_SIZE]); 

// median return the median for an array of integers.
int median(int arr[ARRAY_SIZE]); 

// mode return the mode for an array of integers.
int mode(int arr[ARRAY_SIZE]); 

// maxn returns the maximum for an array of integers.
int maxn(int arr[ARRAY_SIZE]);

int main() {
   float m1;
   int m2, m3;
   int arr[ARRAY_SIZE] = {3, 5, 6, 1, 2, 3, 6, 2, 3, 6, 6, 5, 3, 2, 4, 6, 1, 4, 2};

   m1 = mean(arr);
   m3 = mode(arr);

   printf("The mean is %f\n", m1);
   printf("The mode is %d\n", m3);

   return 0;
}

float mean(int arr[ARRAY_SIZE]) {
    int sum = 0;

    for (int i=0; i<ARRAY_SIZE; i++) {
        sum += arr[i];
    }

    float m = (float)sum/(float)ARRAY_SIZE;
    return m;
}

int mode(int arr[ARRAY_SIZE]) {
    // create a temporary array of integers where each index represents a value
    // and the value at that index represents the number of occurrence for that
    // value.
    int max_size = maxn(arr);
    int map[max_size+1];

    // iterate through the given array and increment their counts.
    for (int i=0; i<ARRAY_SIZE; i++) {
        map[arr[i]]++;
    }

    // iterate through the temporary array and return the index with the highest
    // count.
    int max_count = 0;
    int max_index = 0;
    for (int i=0; i<max_size; i++) {
        if (map[i] > max_count) {
            max_count = map[i];
            max_index = i;
        }
    }

    return max_index;
}


int maxn(int arr[ARRAY_SIZE]) {
    int m = arr[0];
    for (int i=1; i<ARRAY_SIZE; i++) {
        if (arr[i] > m) {
            m = arr[i];
        }
    }

    return m;
}
