#include <ctype.h>

/* getline:  read a line into s, return length  */
int getline(char *s, int lim)
{
	int c, i;

	for (i=0; i < lim-1 && (c=getchar())!=EOF && c!='\n'; ++i)
		*s++ = c;
	if (c == '\n') {
		*s++ = c;
	}
	*s = '\0';
	return i;
}


/* atoi:  convert s to integer; version 2 */
int atoi(char *s)
{
	int i, n, sign;

	for (i = 0; isspace(*s++); i++)  /* skip white space */
	;
	sign = (*s == '-') ? -1 : 1;
	if (*s == '+' || *s == '-')  /* skip sign */
		s++;
	for (n = 0; isdigit(*s); i++) {
		n = 10 * n + (*s - '0');
		s++;
	}
	return sign * n;
}

/* itoa:  convert n to characters in s */
void itoa(int n, char *s)
{
	int i, sign;
	if ((sign = n) < 0)  /* record sign */
		n = -n;			/* make n positive */
	i = 0;
	do {	/* generate digits in reverse order */
		*s++ = n % 10 + '0';  /* get next digit */
	} while ((n /= 10) > 0);	/* delete it */
	if (sign < 0)
		*s++ = '-';
	*s = '\0';
	reverse(s);
}

/* reverse:  reverse string s in place */
void reverse(char *s)
{
	int c, i, j;
	char *s2 = s;

	while(*s2)
		s2++;
	s2--;
	
	for (i = 0, j = strlen(*s)-1; i < j; i++, j--) {
		c = *s;
		*s = *s2;
		*s2 = c;
		s++;
		s2--;
	}
}