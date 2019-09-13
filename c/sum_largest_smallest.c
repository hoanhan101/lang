/* ask user for 3 integers and print the sum, average, smallest and largest */

#include <stdio.h>

// max3 return a maximum integer of 3 input integers.
int max3(int arr[3]); 

// min3 return a minimum integer of 3 input integers.
int min3(int arr[3]); 

int main() {
   int in1, in2, in3, sum, avg, smallest, largest;

   printf("Enter the first integer:\n");
   printf(">> ");
   scanf("%d", &in1);

   printf("Enter the second integer:\n");
   printf(">> ");
   scanf("%d", &in2);

   printf("Enter the third integer:\n");
   printf(">> ");
   scanf("%d", &in3);

   sum = in1 + in2 + in3;
   avg = sum / 3;

   int arr[3] = {in1, in2, in3};
   largest = max3(arr);
   smallest = min3(arr);

   printf("The sum is %d\n", sum);
   printf("The average is %d\n", avg);
   printf("The largest is %d\n", largest);
   printf("The smallest is %d\n", smallest);


   return 0;
}

int max3(int arr[3]) {
    int m = arr[0];
    for (int i=1; i<3; i++) {
        if (arr[i] > m) {
            m = arr[i];
        }
    }

    return m;
}

int min3(int arr[3]) {
    int m = arr[0];
    for (int i=1; i<3; i++) {
        if (arr[i] < m) {
            m = arr[i];
        }
    }

    return m;
}
