#include <iostream>
#define SIZE 100
using namespace std;

class bst_node{
public :
    string name;
    string phonenum;
    string birth;
    bst_node *left, *right;

    void set_data(string s1, string s2, string s3);
};

void bst_node :: set_data(string s1, string s2, string s3){
    name = s1;
    phonenum = s2;
    birth = s3;
}

class nstack{
    bst_node *t[SIZE];
    int top;
public :
    nstack();
    void push(bst_node *s);
    bst_node* pop();
    bool stack_empty();
};

nstack :: nstack(){
    top = 0;
}

void nstack :: push(bst_node *s){
    t[top] = s;
    top++;
}

bst_node* nstack :: pop(){
    top--;
    return t[top];
}

bool nstack :: stack_empty(){
    if(top == 0) return true;
    else return false;
}
