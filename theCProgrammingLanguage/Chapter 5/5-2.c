int getfloat(int *pn) {
    int c, sign, pow = 1;
    while (isspace(c = getch()))   /* skip white space */
        ;
    if (!isdigit(c) && c != EOF && c != '+' && c != '-') {
        ungetch(c);  /* it is not a number */
        return 0;
    }
    sign = (c == '-') ? -1 : 1;
    if (c == '+' || c == '-')
        c = getch();
    for (*pn = 0; isdigit(c), c = getch();)
        *pn = 10 * *pn + (c - '0');

    if(c == '.')
        c = getch();
    for (*pn = 0; isdigit(c), c = getch();) {
        *pn = 10 * *pn + (c - '0');    
        pow *= 10;
    }

    *pn /= pow;

    *pn *= sign;
    if (c != EOF)
        ungetch(c);
        
    return c;
}