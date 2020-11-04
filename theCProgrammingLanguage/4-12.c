#include <stdio.h>
#include <string.h>

/* reverse: reverse string s in place */
void reverse(char s[]) {
	int c, i, j;
	for (i = 0, j = strlen(s)-1; i < j; i++, j--) {
		c = s[i];
		s[i] = s[j];
		s[j] = c;
	}
}


/* itoa: convert n to characters in s */
/* modified to work with recursion */
void itoa(int n, char s[])
{
	int sign;
	static int i = 0;
	
	if(n == 0)
		return;
	if ((sign = n) < 0) /* record sign */
		n = -n;			/* make n positive */

	itoa(n / 10, s);
	s[i++] = n % 10 + '0';
	s[i] = '\0';
}

int main()
{
    char s[50];
    itoa(123, s);
    printf("%s", s);

    return 0;
}
