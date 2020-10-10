/**Delete all chars in s1 from s2**/
void squeeze(char s1[], char s2[]) {
	int i, j, k;
	for (i = 0; s1[i] != '\0'; i++) {
		for (j = k = 0; s2[j] != '\0'; j++)
			if(s1[i] != s2[j])
				s2[k++] = s2[j];
		s2[k] = '\0';
	}
}
