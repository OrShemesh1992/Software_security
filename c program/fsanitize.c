#include <stdio.h>
#include <stdbool.h>

void adress(){
        int * arr = malloc(10*sizeof(int));
        for (size_t i = 0; i < 10; i++) {
                printf("%d ", arr[i]);
        }
        free(arr);
        printf("%d\n",arr[0]);// BOOM heap-use-after-free on address
}

void leak(){
        int * arr = malloc(10*sizeof(int));
        for (size_t i = 0; i < 10; i++) {
                printf("%d ", arr[i]);
        }
        printf("\n");
        arr=10; // BOOM detected memory leaks
}

void bounds(){
        int arr[10];
        for (size_t i = 0; i < 10; i++) {
                arr[i]=0;
        }
        for (size_t i = 0; i < 11; i++) {//runtime error: index 10 out of bounds for type 'int [10]
                printf("%d ", arr[i]);
        }
        printf("\n");
}
void divZero(){
        int ten=10;
        int zreo=2*0;
        int divebyzero=(ten/zreo); //BOOM division by zero
}

int main() {
        printf("%s\n","Functio adress sanitize" );
        adress();
        printf("%s\n","Functio leak sanitize" );
        leak();
        printf("%s\n","Functio bounds sanitize" );
        bounds();
        printf("%s\n","Functio divZero sanitize" );
        divZero();
        return 0;
}
