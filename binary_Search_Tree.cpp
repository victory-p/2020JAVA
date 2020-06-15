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
