#include <stdio.h>

void lower(char *text) {
    int i = 0;
    while(text[i] != '\0')
        text[i] = (text[i] <= 90) ? text[i++]+32 : text[i++];
}