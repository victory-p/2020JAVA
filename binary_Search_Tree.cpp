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

class bst_tree{
    bst_node *root;
    int csize;
public :
    bst_tree();
    void insert_node(bst_node t);
    void show_inorder();
    bst_node search(string pnum);
};

bst_tree :: bst_tree(){
    root = NULL;
}

void bst_tree :: insert_node(bst_node t){
    bst_node *p;
    bst_node *tmp;

    tmp = new bst_node;
    *tmp = t;
    tmp->left = NULL;
    tmp->right = NULL;

    if(root == NULL){
        root = tmp;
        return;
    }

    p = root;
    while(1){
        if(p->phonenum == t.phonenum){
            cout << "Insertion Failed : the Key " << t.phonenum << " already exists." << endl;
            return;
        }
        if(p->phonenum < t.phonenum){
            if(p->right == NULL){
                p->right = tmp;
                return;
            }
            else p = p->right;
        }
        else{
            if(p->left == NULL){
                p->left = tmp;
                return;
            }
            else p = p->left;
        }
    }
}

void bst_tree :: show_inorder(){
    nstack s1;
    bst_node *t;

    t = root;
    while(1){
        while(t != NULL){
            s1.push(t);
            t = t->left;
        }
        while(t == NULL){
            if(s1.stack_empty()) return;
            t = s1.pop();
        }
        cout << t->name << " : " << t->phonenum << " : " << t->birth << "\n";
        t = t->right;
    }
}

bst_node bst_tree :: search(string pnum){
    bst_node *p;

    p = root;
    if(root == NULL){
        bst_node tmp;
        tmp.set_data("None", "00000000000", "0000");
        cout << "The key " << pnum << " does not exist.\n";
        return tmp;
    }

    while(1){
        if(p->phonenum == pnum) return (*p);
        if(p->phonenum < pnum){
            if(p->right == NULL){
                bst_node tmp;
                tmp.set_data("None", "00000000000", "0000");
                cout << "The key " << pnum << " does not exist.\n";
                return tmp;
            }
            else p = p->right;
        }
        else{
            if(p->left == NULL){
                bst_node tmp;
                tmp.set_data("None", "00000000000", "0000");
                cout << "The key " << pnum << " does not exist.\n";
                return tmp;
            }
            else p = p->left;
        }
    }
}
