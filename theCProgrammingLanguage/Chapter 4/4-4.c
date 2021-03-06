#include<stdio.h>
#include<stdlib.h>

#define MAXOP 100
#define NUMBER '0'

int getop(char []);
void push(double);
double pop(void);
void clear(void);

/* reverse polish calculator */
/* modified to answer the exercise 4-4*/
int main(void)
{
    int type;
    double op2, op;
    int sp2;
    char s[MAXOP];

    while((type = getop(s)) != EOF)
    {
        switch(type)
        {
                case 'p': /* print top element*/
                    sp2 = pop();
                    printf("%f", sp2);
                    push(sp2);
                    /*
                        (the question is ambiguous, should
                         I print all and don't use pop()?)
                        for(int i = sp-1; i >=0; i--)
                            printf("%f ", val[i]);
                    */
                    break;
                case 'd': /* duplicate top element*/
                    /* we can also use the vector val to duplicate*/
                    op2 = pop();
                    push(op2);
                    push(op2);
                    break;
                case 's': /* swap top elements*/
                    /*(it's possible to make using the val vetor)*/
                    op = pop();
                    op2 = pop();
                    push(op);
                    push(op2);
                    break;
                case 'c': /* clear */
                    /*(it's possible to make using the pop until end)*/
                    clear();
                    break;
                case NUMBER:
                        push(atof(s));
                        break;
                case '+':
                        push(pop()+pop());
                        break;
                case '*':
                        push(pop()*pop());
                        break;
                case '-':
                        op2 = pop();
                        push(pop()-op2);
                        break;
                case '/':
                        op2 = pop();
                        if(op2 != 0.0)
                            push(pop()/op2);
                        else
                            printf("error:zero divisor\n");
                        break;
                case '\n':
                        printf("\t%.8g\n",pop());
                        break;
                default:
                        printf("error: unknown command %s\n",s);
                        break;

        }
    }
    return 0;
}


#define MAXVAL 100

int sp = 0;
double val[MAXVAL];

void clear() {
    sp = 0;
}

void push(double f)
{
    if(sp < MAXVAL)
        val[sp++]=f;
    else
        printf("error:stack full, cant push %g\n",f);
}


double pop(void)
{
    if(sp>0)
        return val[--sp];
    else
    {
        printf("error: stack empty\n");
        return 0.0;
    }
}

#include<ctype.h>

int getch(void);
void ungetch(int);

int getop(char s[]) {
    int i, c;
    while ((s[0] = c = getch()) == ' ' || c == '\t')
        ;
    s[1] = '\0';
    if (!isdigit(c) && c != '.' && c != '-')
        return c;       // not a number
    i = 0;
    if (c == '-' || isdigit(c))     // collect integer part along with '-'
        while (isdigit(s[++i] = c = getch()))
            ;
    if (c == '.')       // collect fraction part
        while (isdigit(s[++i] = c = getch()))
            ;
    s[i] = '\0';
    if (c != EOF)
        ungetch(c);
    if (strcmp(s, "-") == 0)
        return '-';
    return NUMBER;
}

#define BUFSIZE 100

char buf[BUFSIZE];
int bufp = 0;

int getch(void)
{
    return (bufp > 0) ? buf[--bufp] : getchar();
}

void ungetch(int c)
{
    if(bufp >= BUFSIZE)
        printf("ungetch: too many characters\n");
    else
        buf[bufp++] = c;
}