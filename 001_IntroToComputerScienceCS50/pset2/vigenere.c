#include <stdio.h>
#include <cs50.h>
#include <string.h>
#include <ctype.h>
#include <stdlib.h>

int main(int argc, string argv[])
{
    if (argc != 2)
    {
        printf("Wrong!!! \n");
        return 1;
    }
    string k = argv[1];
    int klen = strlen(k);
    for (int p = 0; p < klen; p++)
    {
        if (!isalpha(k[p]))
        {
            printf("Word");
            return 1;
        }
    }
    string mess = GetString();
    for (int i = 0, j = 0, length = strlen(mess); i < length; i++, j++)
    {
        int letter = mess[i];
        int cipher;
        int kletter;
        if (isalpha(mess[i]))
        {
            kletter = toupper(k[j % klen]) - 65;
            if (isupper(mess[i]))
            {
                cipher = (((letter - 65) + kletter) % 26) + 65;
            }
            else 
            {
                cipher = (((letter - 97) + kletter) % 26) + 97;
            }
            printf("%c", cipher); 
        }
        else
        {
            printf("%c", mess[i]);
            j = j - 1;
        }
    }
    printf("\n");
    return 0;
}