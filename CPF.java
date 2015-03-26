import java.util.Scanner;

public class CPF {
    
    public void lerCpf(){
        Scanner input = new Scanner( System.in );

        System.out.println(" Digite os 9 primeiros digitos do CPF: ");
        String cpf = input.next();
        int tamanho = cpf.length();
        
    }

    public static void main(String[] args) {
        int[] v = new int[11];
        CPF cpf1 = new CPF();
        cpf1.lerCpf();
        int peso = 10;
        int soma1 = 0;

       
        for (int i = 0; i < 9; i++) {

            soma1 += v[i] * (peso--);
        }
    }

}
