#include <stdio.h>
#define MAXLINE 1000 /* maximum input line length */

int getlinee(char line[], int max);
int strindex(char source[], char searchfor[]);

char pattern[] = "ould"; /* pattern to search for */

/* find all lines matching pattern */
main() {
	char line[MAXLINE];	
	int found = 0;	
	
	while (getlinee(line, MAXLINE) > 0)
		if (strindex(line, pattern) >= 0) {
			printf("%s %d\n", line, strindex(line, pattern));	
			found++;
		}
	return found;
}

/* getline:  get line into s, return length */
int getlinee(char s[], int lim) {	
	int c, i;	
	i = 0;	
	while (--lim > 0 && (c=getchar()) != EOF && c != '\n')	
		s[i++] = c;	
	if (c == '\n')	
		s[i++] = c;	
	s[i] = '\0';	
	
	return i;
}

/* strindex: return the index of the last occurrence of t in s, -1 if none */
int strindex(char s[], char t[]) {
	int i, j, k;
	int found = -1;
    
	for (i = 0; s[i] != '\0'; i++) {
		for (j=i, k=0; t[k]!='\0' && s[j]==t[k]; j++, k++) {
		    if(t[k+1] == '\0') {
			    found = i;
		    }
		}
	}
	return found;
	
}
