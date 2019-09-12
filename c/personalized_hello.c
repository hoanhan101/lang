/* ask user for the name and greet them */

#include <stdio.h>

int main() {
   printf("What is your name?\n");

   // allocate a string with type char of size 20.
   char str[20];

   // read from std, allow all characters including whitespace.
   scanf("%[a-zA-Z ]s", str);

   printf("Hello %s\n", str);

   return 0;
}
