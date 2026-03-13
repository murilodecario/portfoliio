#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
    char tipo;
    int senha;
    struct Node *next, *prev;
} Node;

typedef struct {
    Node *head, *tail, *lastGrave;
} Lista;

void limparBuffer() {
    int c;
    while ((c = getchar()) != '\n' && c != EOF);
}

void inserir(Lista* l, int senha, char tipo) {
    Node* novo = (Node*)malloc(sizeof(Node));
    novo->senha = senha;
    novo->tipo = tipo;
    novo->next = novo->prev = NULL;

    if (tipo == 'g') {
        if (!l->head) {
            l->head = l->tail = l->lastGrave = novo;
        } else if (!l->lastGrave) {
            novo->next = l->head;
            l->head->prev = novo;
            l->head = l->lastGrave = novo;
        } else {
            novo->next = l->lastGrave->next;
            novo->prev = l->lastGrave;
            if (l->lastGrave->next) l->lastGrave->next->prev = novo;
            else l->tail = novo;
            l->lastGrave->next = novo;
            l->lastGrave = novo;
        }
    } else {
        if (!l->head) {
            l->head = l->tail = novo;
        } else {
            novo->prev = l->tail;
            l->tail->next = novo;
            l->tail = novo;
        }
    }
}

void atender(Lista* l) {
    if (!l->head) {
        printf("Lista vazia.\n");
        return;
    }

    Node* temp;
    if (l->head->tipo == 'g') {
        temp = l->head;
        printf("Atendendo Grave - Senha: %d\n", temp->senha);
        if (l->lastGrave == temp) l->lastGrave = NULL;
        l->head = l->head->next;
        if (l->head) l->head->prev = NULL;
        else l->tail = NULL;
    } else {
        temp = l->tail;
        printf("Atendendo Ameno - Senha: %d\n", temp->senha);
        l->tail = l->tail->prev;
        if (l->tail) l->tail->next = NULL;
        else l->head = NULL;
    }
    free(temp);
}

int main() {
    Lista l = {NULL, NULL, NULL};
    int op, senha;
    char tipo;

    do {
        printf("\n1-Inserir | 2-Ver Inicio | 3-Atender | 0-Sair: ");
        if (scanf("%d", &op) != 1) { limparBuffer(); op = -1; continue; }

        switch (op) {
            case 1:
                printf("Senha e Tipo (g/a): ");
                if (scanf("%d %c", &senha, &tipo) != 2) { limparBuffer(); break; }
                inserir(&l, senha, tipo);
                break;
            case 2:
                if (l.head) printf("No inicio: [%c] Senha %d\n", l.head->tipo, l.head->senha);
                else printf("Vazia\n");
                break;
            case 3:
                atender(&l);
                break;
        }
    } while (op != 0);
    return 0;
}