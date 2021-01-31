#include <stdlib.h>

void reverse(char s[])
{
    int i,j,c;

    for(i=0,j=strlen(s)-1;i<j;i++,j--)
        c=s[i],s[i]=s[j],s[j]=c;
}

/*
	itoa:  convert n  to characters and add extra space
	if the number of digits in n is less than minimumSize.
*/
void itob(int n, char s, int minimumSize) {
	int i = 0;
	int sign = 1;

	if(n < 0)
		sign = -1;

	do {
		s[i++] = (n % b) + '0';
		minimumSize--;
	} while((n /= b) > 0)

	if(sign < 0)
		s[i++] = '-';

	if(minimumSize-- > 0)
		s[i++] = ' ';

	s[i] = '\0';

	reverse(s);
}
