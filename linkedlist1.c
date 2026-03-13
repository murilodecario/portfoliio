#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
    int data;
    struct Node* next;
} Node;

void inserir(Node** head, int val) {
    Node* novo = (Node*)malloc(sizeof(Node));
    novo->data = val;
    if (*head == NULL || (*head)->data >= val) {
        novo->next = *head;
        *head = novo;
    } else {
        Node* curr = *head;
        while (curr->next != NULL && curr->next->data < val) curr = curr->next;
        novo->next = curr->next;
        curr->next = novo;
    }
}

int removerMenoresQueK(Node** head, int k) {
    int removidos = 0;
    while (*head != NULL && (*head)->data < k) {
        Node* temp = *head;
        *head = (*head)->next;
        free(temp);
        removidos = 1;
    }
    return removidos;
}

void exibirLista(Node* head) {
    if (!head) printf("Lista vazia.\n");
    while (head) {
        printf("%d ", head->data);
        head = head->next;
    }
    printf("\n");
}

int main() {
    Node* head = NULL;
    int op, val, k;
    char buffer[10];

    do {
        printf("\n1-Inserir | 2-Remover < K | 3-Exibir | 0-Sair: ");
        scanf("%d", &op);
        switch (op) {
            case 1:
                printf("Digite numeros inteiros ou qualquer letra para parar:\n");
                while (scanf("%d", &val) == 1) inserir(&head, val);
                scanf("%s", buffer);
                break;
            case 2:
                printf("Valor de K: "); scanf("%d", &k);
                if (removerMenoresQueK(&head, k)) printf("Sucesso!\n");
                else printf("Nenhum elemento menor que %d.\n", k);
                break;
            case 3:
                exibirLista(head);
                break;
        }
    } while (op != 0);
    return 0;
}