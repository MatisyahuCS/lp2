
import java.util.Scanner;

public class CPF {
    
    public String lerCpf(){
        Scanner input = new Scanner( System.in );
        System.out.println(" Digite os 9 primeiros digitos do CPF: ");
        String cpf = input.next();       
        return cpf;
    }
    
    public int[] getCaractere (String cpf){
        int[] v = new int[11];
        int tamanho = cpf.length();
        for ( int i = 0; i < tamanho; i++ ){
            char caractere = cpf.charAt(i);
            v[i] = Character.getNumericValue (caractere);
        }
        return v;
    }

    public int primeiroDigito (int[] v){
        int peso = 10;
        int soma = 0;
        int d1;
       
        for (int i = 9; i > 0; i--) {
            soma += v[i] * (peso--);
        }
        if (soma % 11 < 2){
            d1 = 0;
        }else{ 
            d1 = 11 - (soma % 11);
        }
        v[10] = d1;
        return v[9];
    } 
    
    public int segundoDigito (int[] v){
        int peso = 11;
        int soma = 0;
        int d2;
       
        for (int i = 10; i > 0; i--) {
            soma += v[i] * (peso--);
        }
        if (soma % 11 < 2){
            d2 = 0;
        }else{ 
            d2 = 11 - (soma % 11);
        }
        v[10] = d2;
        return v[10];
    } 
    
    public static void main(String[] args) {
        int[] v = new int[11];
        CPF cpf1 = new CPF();
        String c;
        
        c     = cpf1.lerCpf();
        v     = cpf1.getCaractere(c);
        v[9]  = cpf1.primeiroDigito (v);
        v[10] = cpf1.segundoDigito (v);
        
        System.out.println(" O num do CPF e': " );
        for ( int i = 0; i < 11; i++){
            System.out.print(v[i]);
        }
        System.out.println(" ");
    }
}
