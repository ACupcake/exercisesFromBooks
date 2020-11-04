#include <stdio.h>
/* itoa: convert n to characters in s */
/*
	Modified to work with recursion, it goes to
	the last digit (on left) of n and then start
	to put them in s. Since i is static, it does
	not lose the old value when the function return.
*/
void itoa(int n, char s[])
{
	int sign;
	static int i = 0;
	
	if(n == 0)
		return;
	
	itoa(n / 10, s);
	if(n/10 == 0 && n < 0)
	    s[i++] = '-';
	    
	if(n < 0)
	    n *= -1;
	s[i++] = n % 10 + '0'; /* go to the next value */
	s[i] = '\0';
}
