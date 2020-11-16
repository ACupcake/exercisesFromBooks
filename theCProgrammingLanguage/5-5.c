/* copies at most n characters of t to s*/
char *strncpy(char *s, char *t, int n) {
	while((*s++ = *t++) && n-- > 0)
		;
}

/* concatenates at most n characters of t to s*/
char *strncat(char *s, char *t, int n) {
	while(*s++)
		;
	while((*s++ = *t++) && n-- > 0)
		;
}

/* compares at most n characters of t to s*/
char *strncmp(char *s, char *t, int n) {
	while((*s++ == *t++) && n-- > 0)
		if(*s == '\0')
			return 0
		;

	if(n <= 0)
		return 0;
	return (*s - *t);
}