class Vetor2D{

    float x, y;

    Vetor2D() {
        x = 0; y = 0;
    }

    Vetor2D(float X, float Y) {
        x = X; y = Y;
    }



    public float produtoEscalar(Vetor2D v2){
        return (this.x * v2.x)+(this.y * v2.y);
    }



    public float produtoEscalar(float x2, float y2){
        return (this.x * x2)+(this.y * y2);
    }
}



public class exProdEscalar {
    public static void main(String[] args){
        System.out.println("Produto escalar de vetores");
        Vetor2D v1 =  new Vetor2D(1,2);
        Vetor2D v2 =  new Vetor2D(3,5);

        //passagem por referencia
        System.out.println("("+v1.x+"*"+v2.x+")+("+v1.y+"*"+v2.y+") = "+v1.produtoEscalar(v2));

        //passagem por valor
        System.out.println(v1.produtoEscalar(8, 8));

    }

   

}