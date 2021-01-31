int strend(char *s, char *t) {
	char *temp = t;

	while(*s) {
		if(*s == *t)
			t++;
		else
			t = temp;
		s++;
	}

	if(*t == '\0')
		return 1;
	return 0;
}