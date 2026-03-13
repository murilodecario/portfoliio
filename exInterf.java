interface Collection {
    int MAXIMUM = 500;
    void add(int obj);
    int find(int obj);
    int currentCount();
}

class MyVector implements Collection {
    
    private int[] data = new int[MAXIMUM];
    private int i = 0;

    public void add(int obj) {
        if (i < MAXIMUM) {
            data[i] = obj;
            i++;
        }
    }
    
    public int find(int obj) {
        for (int i = 0; i < i; i++) {
            if (data[i] == obj) {
                return i; 
            }
        }
        return -1;
    }

    public int currentCount() {
        return i;
    }
}

class MyLinkedList implements Collection{
    
}

public class exInterf {
    public static void main(String[] args) {
        MyVector v1 = new MyVector();

        for (int i = 10; i <= 20; i++) {
            v1.add(i);
        }

        
        System.out.println("Posição do 13: " + v1.find(13)); 
        System.out.println("Total de itens: " + v1.currentCount());
    }
}