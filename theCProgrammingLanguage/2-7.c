#include <stdio.h>

unsigned invert(unsigned x, int p, int n) {
    unsigned mask;
    
    //get value to move
    mask = (x >> (p+1-n)) & ~(~0 << n);
    
    //move mask to p and does the | operation
    if(p > n)
        mask = ~(mask << p-n);
    x = x | (~mask & ~(~0 << n));

    //move mask to beginning
    //move mask to p and does the & operation
    if(p > n) {
        mask = (mask >> p-n);
        mask = (mask << p-n);
    }
    x = x & ~mask; //| (~0 << n))

    return x;
}

int main()
{   
    //111110[1000] -> 100010[0111]
    //1111101000 = 1000 -> 1111100111 = 999
    printf("%d\n", 1000); 
    printf("%d", invert(1000, 3, 4));
    
    return 0;
}
