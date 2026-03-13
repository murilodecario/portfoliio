#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
    int id;
    struct Node* next;
} Node;

typedef struct {
    Node *head, *tail;
    int size;
} Fila;

void enfileirar(Fila* f, int id) {
    Node* novo = (Node*)malloc(sizeof(Node));
    novo->id = id;
    novo->next = NULL;
    if (!f->head) {
        f->head = f->tail = novo;
    } else {
        f->tail->next = novo;
        f->tail = novo;
    }
    f->size++;
}

int desenfileirar(Fila* f) {
    if (!f->head) return -1;
    Node* temp = f->head;
    int id = temp->id;
    f->head = f->head->next;
    if (!f->head) f->tail = NULL;
    free(temp);
    f->size--;
    return id;
}

void limparBuffer() {
    int c;
    while ((c = getchar()) != '\n' && c != EOF);
}

int main() {
    Fila f = {NULL, NULL, 0};
    int op, id;

    do {
        printf("\n1-Adicionar | 2-Ver Inicio | 3-Atender | 4-Quantidade | 0-Sair: ");
        if (scanf("%d", &op) != 1) {
            printf("Entrada invalida! Digite um numero.\n");
            limparBuffer();
            op = -1;
            continue;
        }

        switch (op) {
            case 1:
                printf("Senha: ");
                if (scanf("%d", &id) != 1) {
                    printf("Senha invalida.\n");
                    limparBuffer();
                } else {
                    enfileirar(&f, id);
                }
                break;
            case 2:
                if (f.head) printf("Inicio: %d\n", f.head->id);
                else printf("Fila vazia\n");
                break;
            case 3:
                id = desenfileirar(&f);
                if (id != -1) printf("Atendido: %d\n", id);
                else printf("Fila vazia\n");
                break;
            case 4:
                printf("Total: %d\n", f.size);
                break;
        }
    } while (op != 0);

    return 0;
}