#include <cs50.h>
#include <stdio.h>
#include <ctype.h>
#include <stdlib.h>
#include <string.h>

int main(int argc, string argv[])
{
    if (argc == 2)
    {
        int k = atoi(argv[1]);
        if (k > 0)
        {
            string mess = GetString();
            int cipher; 
            for (int i = 0, length = strlen(mess); i < length; i++)
            {
                int letter = mess[i];
                if (isalpha(mess[i]))
                {
                    if (isupper(mess[i]))
                    {
                        cipher = ((((letter - 65) + k) % 26) + 65);
                    }  
                    else
                    {
                        cipher = ((((letter - 97) + k) % 26) + 97);
                    } 
                    printf("%c", cipher); 
                }
                else
                {
                    printf("%c", mess[i]);
                }
            }
            printf("\n");
        }
        return 0;
    }
    printf("Wrong!!!");
    return 1;
}