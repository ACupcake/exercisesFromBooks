#include <stdio.h>

#define MAXLINES 1000

/* readlines:  read input lines */
int readlines(char *lineptr[], int maxlines)
{
	int len, nlines;
	char *p, line[MAXLEN];

	nlines = 0;
	while ((len = getline(line, MAXLEN)) > 0)
		if (nlines >= maxlines || p = alloc(len) == NULL)
			return -1;
		else {
			line[len-1] = '\0';  /* delete newline */
			strcpy(p, line);
			lineptr[nlines++] = p;
		}
	return nlines;
 }

/* writelines:  write output lines */
void writelines(char *lineptr[], int nlines, int n) {
	if(nlines < n)
		for (int i = 0; i < nlines; i++)
			printf("%s\n", lineptr[i]);
	else if(nlines > n)
		for (int i = n; i < nlines; i++)
			printf("%s\n", lineptr[i]);
}

int main(int argc, char *argv[]) {
	int n = 10;

	if(argc > 1)
		n = atoi(*(argv[1]+1));
	
	if(nlines = readlines(lineptr, MAXLINES)
		writelines(lineptr, nlines, n);
}