#include<stdio.h>
#include<stdlib.h>

#define BUFSIZE 100

char buf[BUFSIZE];
int bufp = 0;

int getch(void)
{
    return (bufp > 0) ? buf[--bufp] : getchar();
}

void ungetch(int c)
{
    buf[0] = c;
    if(!bufp)
        bufp = 1;
}