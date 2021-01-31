#define SWAP(t,x,y) {\
	t pivot;\
	pivot = x;\
	x = y;\
	y = pivot;}

//or

//#define SWAP(a,b) do { t a; a=x; x=y;y=a } while(0)
/* The do while serves as a way to prevent bad unwrap */
