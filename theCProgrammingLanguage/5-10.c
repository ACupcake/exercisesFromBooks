#include <stdio.h>

int main(int argc, char const *argv[])
{
	int arr[argc];
	int argsN = 0;
	
	for(int i = 1; i < argc; i++)
	{
		if(argv[i][0] >= '1' && argv[i][0] <= '9')
		{
			arr[argsN++] = argv[i][0] - '0';
		}
		else
		{
			switch(argv[i][0])
			{
				case('+'):
					arr[argsN - 2] = arr[argsN - 1] + arr[argsN - 2];
					break;
				case('-'):
					arr[argsN - 2] = arr[argsN - 1] - arr[argsN - 2];
					break;
				case('x'):
					arr[argsN - 2] = arr[argsN - 1] * arr[argsN - 2];
					break;
				case('/'):
					arr[argsN - 2] = arr[argsN - 1] / arr[argsN - 2];
					break;
				argsN--;
			}
		}
	}

	printf("%d\n", arr[0]);

	return 0;
}