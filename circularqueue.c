#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

#define MAX_F 50 

typedef struct {
    int itens[MAX_F];
    int inicio;
    int fim;
    int tam;
} Fila;

void inicializar(Fila *f) {
    f->inicio = f->fim = -1; 
    f->tam = 0;
}

bool cheia(Fila f) {
    return f.tam == MAX_F;
}

bool vazia(Fila f) {
    return f.tam == 0;
}

bool inserir(Fila *f, int item) {
    if (cheia(*f)) return false;

    if (f->inicio == -1) f->inicio = 0;

    f->fim = (f->fim + 1) % MAX_F;
    f->itens[f->fim] = item;
    f->tam++;

    return true;
}

bool remover(Fila *f, int *item) {
    if (vazia(*f)) return false;

    *item = f->itens[f->inicio];
    f->tam--;

    if (f->tam == 0) {
        f->inicio = f->fim = -1;
    } else {
        f->inicio = (f->inicio + 1) % MAX_F;
    }

    return true;
}

void multiplode3(Fila *f) {
    int tamanhoOriginal = f->tam;
    int valor;

    for (int i = 0; i < tamanhoOriginal; i++) {
        remover(f, &valor);
        // Se NÃO for múltiplo de 3, volta para a fila
        if (valor % 3 != 0) {
            inserir(f, valor);
        }
    }
}

void imprimirFila(Fila f) {
    if (vazia(f)) {
        printf("Fila vazia.");
        return;
    }
    int i = f.inicio;
    for (int cont = 0; cont < f.tam; cont++) {
        printf("[%d] ", f.itens[i]);
        i = (i + 1) % MAX_F;
    }
}

int main() {
    Fila f;
    inicializar(&f);

    inserir(&f, 3);
    inserir(&f, 4);
    inserir(&f, 9);
    inserir(&f, 12);
    inserir(&f, 7);
    inserir(&f, 8);

    printf("Fila Original: ");
    imprimirFila(f);
    
    multiplode3(&f);

    printf("\nFila apos remover multiplos de 3: ");
    imprimirFila(f);
    printf("\n\n");

    system("pause");
    return 0;
}