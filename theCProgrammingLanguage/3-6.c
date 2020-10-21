#include <stdlib.h>

void reverse(char s[])
{
    int i,j,c;

    for(i=0,j=strlen(s)-1;i<j;i++,j--)
        c=s[i],s[i]=s[j],s[j]=c;
}

/* itob:  convert n in decimal to characters in base b in s*/
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