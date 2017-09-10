#include <stdio.h>
#include <cs50.h>

// Prototype
void cough(int n);
void sneeze(int n);
void say(string word, int n);

int main(void)
{
    cough(3);

    sneeze(3);
}

void cough(int n)
{
    say("cough", n);
}

void sneeze(int n)
{
    say("sneeze", n);
}

void say(string word, int n)
{
    for(int i = 0; i < n; i++)
    {
        printf("%s\n", word);
    }
}

