/* Recursive version of reverse */
/* 
    It's also possible not to use static,
    but we would need to pass more parameters,
    in this case, i starting with 0 and j
    starting with strlen(s)-1
*/
void reverse(char s[]) {
	int c;
	static int i = 0;
	static int j;
	
	if(i == 0){
	    j = strlen(s)-1;
	}
	
	if(i < j){
	    c = s[i];
	    s[i] = s[j];
	    s[j] = c;
		i++;
		j--;
		reverse(s);
	}
}