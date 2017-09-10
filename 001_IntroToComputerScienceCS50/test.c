#include <stdio.h>
#include <ctype.h>
#include <stdbool.h>
#include <string.h>
int collatz(int n);
int test_fgets(char *fileName);
bool load(const char *dictionary);

typedef struct _node {
    bool isWord;
    struct _node *children[27];
} 
node;

node *root;

int main(void) 
{
    return load("text");
}


int collatz(int n) {
    if (n == 1) 
        return 0;
    else if (n % 2 == 0)
        return 1 + collatz(n / 2);
    else 
        return 1 + collatz(3*n + 1);
}

int test_fgets(char *fileName) {
    FILE *fp = fopen(fileName, "r");
    
    if (fp == NULL) {
        printf("Could not read the file.\n");
        return 1;
    }
    
    char word[45];
    
    printf("%s", fgets(word, 45, fp));
    
    fclose(fp);
    return 0;
}


bool load(const char *dictionary)
{
    // read a dictionary file with reading operation
    FILE *fp = fopen(dictionary, "r");
    
    // check is it NULL
    if (fp == NULL) {
        printf("Could not read the dictionary file.\n");
        return 1;
    }
    
    // create a variable to store words;
    char word[45];
    
    // read word by word until EOF
    while (fgets(word, 45, fp) != NULL) {
        node *trav = root;
        // iterate into each character and add to dictionary
        for (int i = 0; strcmp(&word[i], "\0"); i++) {
            // create an integer to store the value of character in node
            int index;
            
            if (strcmp(&word[i], "\'")) {
                index = 26;
            }
            else {
                index = ((int) (word[i])) % 97;
            }
            
            // add the character to dictionary Tries
            if (*trav.children[index] == NULL) {
                node *new_node = malloc(sizeof(node));
                trav.children[index] = new_node;
                trav = *trav.children[index];
            }
            else {
                trav = *trav.children[index];
            }
        }
        
        *trav.isWord = true;
    }
    return true;
    
}