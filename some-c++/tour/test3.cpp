#include <iostream>

using namespace std;

enum color
{
    red,
    green = 5,
    blue
};

int main()
{

    color c = red;
    cout << "red:" << c << endl;

    color c2 = blue;
    cout << "blue:" << c2 << endl;

    cout << "-----------------------------------" << endl;
    cout << "Size of char : " << sizeof(char) << endl;
    cout << "Size of int : " << sizeof(int) << endl;
    cout << "Size of short int : " << sizeof(short int) << endl;
    cout << "Size of long int : " << sizeof(long int) << endl;
    cout << "Size of float : " << sizeof(float) << endl;
    cout << "Size of double : " << sizeof(double) << endl;
    cout << "Size of wchar_t : " << sizeof(wchar_t) << endl;

    return EXIT_SUCCESS;
}