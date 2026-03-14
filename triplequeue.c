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
    f->inicio = 0;
    f->fim = -1; 
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

    if (f->fim == MAX_F - 1) {
        int deslocamento = f->inicio;
        for (int i = f->inicio; i <= f->fim; i++) {
            f->itens[i - deslocamento] = f->itens[i];
        }
        f->fim = f->fim - deslocamento;
        f->inicio = 0;
    }

    f->itens[++f->fim] = item;
    f->tam++;
    return true;
}

bool remover(Fila *f, int *item) {
    if (vazia(*f)) return false;
    *item = f->itens[f->inicio];
    f->inicio++;
    f->tam--;
    return true;
}

void triplicarImpares(Fila *f) {
    int tamanhoOriginal = f->tam;
    int valor;
    for (int i = 0; i < tamanhoOriginal; i++) {
        remover(f, &valor);
        inserir(f, valor);
        if (valor % 2 != 0) {
            inserir(f, valor * 3);
        }
    }
}

int main() {
    Fila f;
    int temp;
    inicializar(&f);

    inserir(&f, 1);
    inserir(&f, 4);
    inserir(&f, 5);

    printf("Fila Original: ");
    for(int i = f.inicio; i <= f.fim; i++) printf("[%d] ", f.itens[i]);
    
    triplicarImpares(&f);

    printf("\nFila Apos Triplicar Impares: ");
    for(int i = f.inicio; i <= f.fim; i++) printf("[%d] ", f.itens[i]);
    printf("\n\n");

    system("pause");
    return 0;
}