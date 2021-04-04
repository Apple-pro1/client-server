#pragma warning(disable: 4996)
#include<stdio.h>
#include<string.h>
#include<stdlib.h>

int main() {

  char *str = "To be, or not to be: that is the question"; 
  int count = 0; 
  int i; 

  while (*str != '\0')
  {
    if (*str == 't')
    {
      count++; 
    }
    str++; 
  }

  printf("%d", count); 

  return 0; 
}
