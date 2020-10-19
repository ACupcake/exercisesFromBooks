void expand(char *s1, char *s2) {
	int i = 0;
	int k = 0;
    int c = 0;

	while(s1[i] != '\0') {
		if(s1[i] != '-') {
			for(int j = s1[i]+c; j <= s1[i+2]; j++) {
				s2[k++] = j;
				c = 0;
			}
		}
    	i++;
    	if(s1[i] == '-')
    	    c = 1;
	}	
}