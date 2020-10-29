#include <ctype.h>

/* atof: convert string s to double */
/* extended to handle scientific notation */
double atof(char s[]) {
	double val, power;
	int i, sign;
	int exponentSign;
	int exponent;

	for (i = 0; isspace(s[i]); i++) /* skip white space */
		;
	sign = (s[i] == '-') ? -1 : 1;
	if (s[i] == '+' || s[i] == '-')
		i++;
	for (val = 0.0; isdigit(s[i]); i++)
		val = 10.0 * val + (s[i] - '0');
	if (s[i] == '.')
		i++;
	for (power = 1.0; isdigit(s[i]); i++) {
		val = 10.0 * val + (s[i] - '0');
		power *= 10;
	}

    /* handle exponent */
	if(s[i] == 'e' || s[i] == 'E') {
		++i;
		
		exponentSign = (s[i] == '-') ? -1 : 1;
		if (s[i] == '+' || s[i] == '-')
		    i++;
		
		for (exponent = 0; isdigit(s[i]); i++)
			exponent = (s[i] - '0') + exponent;

		for(; exponent > 0; exponent--) {
			if(exponentSign == 1)
				power /= 10;
			else
				power *= 10;
		}
	}

	return sign * val / power;
}