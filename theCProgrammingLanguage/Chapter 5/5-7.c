#include <stdio.h>
#include <string.h>
#define MAXLINES 5000	/* max #lines to be sorted */

char *lineptr[MAXLINES];	/* pointers to text lines */

#define MAXLEN 1000	/* max length of any input line */
int getline(char *, int);

char *alloc(int);

#define MAXSTORE 8000

/* readlines:  read input lines */
int readlines(char *lineptr[], int maxlines, char *lines)
{
	int len, nlines;
	char line[MAXLEN];
	char *maximum = lines + MAXSTORE;

	nlines = 0;
	while ((len = getline(line, MAXLEN)) > 0)
		if (nlines >= maxlines && lines+len > maximum)
			return -1;
 		else {
			*(lines-1) = '\0';  /* delete newline */
			lineptr[nlines++] = lines;
			lines+=len;
		}

	return nlines;
}