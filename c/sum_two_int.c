/* ask user for 2 integers and print the sum */

#include <stdio.h>

int main() {
   int in1, in2, sum;

   printf("Enter the first integer:\n");
   printf(">> ");
   scanf("%d", &in1);

   printf("Enter the second integer:\n");
   printf(">> ");
   scanf("%d", &in2);

   sum = in1 + in2;

   printf("The sum is %d\n", sum);

   return 0;
}
