#include <stdio.h>

void escape(char *s, char *t) {
	int sLetter = 0;
	int tLetter = 0;

	while(t[tLetter] != '\0') {
		switch(t[tLetter]) {
			case('\n'):
				s[sLetter++] = '\\';
				s[sLetter] = 'n';
				break;
			case('\t'):
				s[sLetter++] = '\\';
				s[sLetter] = 't';
				break;
			default:
				t[tLetter] = s[sLetter];
				break;
		}
		tLetter++;
		sLetter++;
	}

	s[sLetter] = '\0';
}