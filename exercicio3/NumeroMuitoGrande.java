import java.util.Scanner;

public class NumeroMuitoGrande {
    
    // Método para leitura dos valores
    public String lerN (){
        Scanner input = new Scanner( System.in );
        System.out.println(" Digite um num muito GIGA: ");
        String n = input.next();       
        return n;
    }
        
    // Método para transformar uma String em um vetor contendo INT
    public int[] transformaVetor (String n){
        int[] v = new int[31];
        int t = n.length();
        int i, j;       
        for ( i = t, j = 0; i > 0; i--, j++ ){
            char caracter = n.charAt(j);
            v[30 - i] = Character.getNumericValue(caracter);
        }
        return v;
    }
    
    // Método de Soma
    public void somaBig (int []x, int []y, int []soma){
        int c = 0;
        for (int i = 29; i >= 0; i--) {
            if (i == 0) {
                if ((soma[i] + x[i] + y[i]) > 10) {
                    System.out.println(" Menor que 30 algarismos, por favor! ");
                    break;
                }
            }
            soma[i] = soma[i] + x[i] + y[i];
            if (soma[i] >= 10) {
                soma[i] = soma[i] - 10;
                c = 1;
                soma[i - 1] = 1;
            }
            if (c == 1) {
                c = 0;
                soma[i - 1] = 1;
            }
        }
        c = 0;
        System.out.print (" O resultado da soma é: ");
        for (int i = 0; i <= 29; i++) {
            if (soma[i] == 0 && c == 0) {
                if (soma[i + 1] != 0) {
                    c = 1;
                }
            }else {
                System.out.print(soma[i]);
            }
        }
        System.out.println(" ");
    } 
    
    // Método de Multiplicação 
    public void multBig (int []x, int []y, int []mult){
        int i, j, aux;        
        for (i = 0; i < 30; i++){
            mult[i] = 0;
        }
        for (j = 29; j >= 0; j--){
            int sobeM = 0; // Vai para Multiplicação
            int result = j;
            i = 29;
            do{
                mult[result] += ((x[j] * y[i]) + sobeM) % 10;
                sobeM = ((x[i] * y[j]) + sobeM) / 10;
                result--;
                i--;
            }while((i > 0) && (result > 0));
        }
        int sobeS = 0; // Vai para Soma
        for (i = 29; i >= 0; i--){
            aux = (mult[i] + sobeS) % 10;
            sobeS = mult[i] / 10;
            mult[i] = aux;
        }
        
        System.out.print (" O resultado da multiplicacao é: ");
        i = 0; // Loop para "anulação" dos zero(s) restantes dos vetores
        do{
          i++;
        }while (mult[i] == 0);
        for (; i < 30; i++) {
            System.out.print(mult[i]);
        }
        System.out.println(" ");     
    }
    
    public static void main (String [] args){
        NumeroMuitoGrande n = new NumeroMuitoGrande ();
               
        String n1 = n.lerN (); // Primeiro Número a ser lido
        String n2 = n.lerN (); // Segundo  Número a ser lido
              
        int[] v1 = new int[30];
        int[] v2 = new int[30];
        int[] vf = new int[30];
        
        v1 = n.transformaVetor(n1); // Recebe num vetor os caracteres da String
        v2 = n.transformaVetor(n2); // Recebe num vetor os caracteres da String     
        
        n.somaBig (v1, v2, vf); // Chamada Soma
        n.multBig (v1, v2, vf);// Chamada método da Multiplicação
    }
}
