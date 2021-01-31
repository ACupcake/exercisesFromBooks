#include <stdlib.h>

void reverse(char s[])
{
    int i,j,c;

    for(i=0,j=strlen(s)-1;i<j;i++,j--)
        c=s[i],s[i]=s[j],s[j]=c;
}

/*
	itob:  convert n in decimal to base b
	and put it in the string s
*/
void itob(int n, char s[], int b) {
	int i = 0;
	int sign = 1;
	int j;

	if(n < 0)
		sign = -1;

	do {
		j = n % b;
		s[i++] = (j <= 9)?(j+'0'):(j+'a'-10);
	} while((n /= b) > 0)

	if(sign < 0)
		s[i++] = '-';
	s[i] = '\0';

	reverse(s);
}
