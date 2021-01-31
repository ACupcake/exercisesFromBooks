#include<stdio.h>
#include<stdlib.h>

/*
    Any of them will work, but it's best to use
    a function that is already (well) written.
*/
void ungets(s) {
    int i = 0;
    while(s[i] != '\0')
        ungetch(s[i++]);
}