#include <stdio.h>

//move bits from [p, p+n] to [y, y+n]
unsigned setbits(unsigned x, int p, int n, int y) {
    unsigned mask;
    ++y;
    
    //get value to move
    mask = (x >> (p+1-n)) //& ~(~0 << n);
    
    //move mask to y+n and does the & operation
    //places one to the right most bits
    mask = ~(~mask << y);
    x = x & mask;
    
    //move mask to beginning
    //move mask to y+n and does the | operation
    //places zero to the right most bits
    mask = (mask >> y);
    mask = (mask << y);
    x = x | mask;
    return x;
}

int main()
{   
    //111110[1000] -> [1000]101000
    //1111101000 = 1000 -> 1000101000 = 552
    printf("%d\n", 1000); 
    printf("%d", setbits(1000, 3, 4, 9));
    
    return 0;
}
