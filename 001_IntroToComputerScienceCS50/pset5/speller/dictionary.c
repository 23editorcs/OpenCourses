/**
 * Implements a dictionary's functionality.
 */

#include <stdbool.h>

#include "dictionary.h"

typedef struct _node {
    bool isWord;
    struct _node *children[27];
} 
node;

node *root;

/**
 * Returns true if word is in dictionary else false.
 */
bool check(const char *word)


/**
 * Loads dictionary into memory. Returns true if successful else false.
 */
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
        for (int i = 0; word[i] != "\0"; i++) {
            // create an integer to store the value of character in node
            int index;
            
            if (word[i] == "\'") {
                index = 26;
            }
            else {
                index = ((int) (word[i])) % 97;
            }
            
            // add the character to dictionary Tries
            if (trav.children[index] == NULL) {
                node *new_node = malloc(sizeof(node));
                trav.children[index] = new_node;
                trav = trav.children[index];
            }
            else {
                trav = trav.children[index];
            }
        }
        
        trav.isWord = true;
    }
    return true;
    
}

/**
 * Returns number of words in dictionary if loaded else 0 if not yet loaded.
 */
unsigned int size(void)
{
    // TODO
    return 0;
}

/**
 * Unloads dictionary from memory. Returns true if successful else false.
 */
bool unload(void)
{
    // TODO
    return false;
}
