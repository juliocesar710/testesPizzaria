import java.util.Scanner;
public class Venda extends Produto{

    private static String[] formasPagamento = {"PIX","Dinheiro","Cartão de Débito","Cartão de Crédito"}; 
    static Scanner scan = new Scanner(System.in);

    public static void gerarNotaFiscal(String nome,double total,String formaPagamento){
        System.out.printf("""
            \n\n==========--NOTA FISCAL--==========\n\n
                Pizzaria: nome a definir\n
                Cliente: %s\n
                Pedido: ver com Arthur\n
                Pizza-----------Mussarela\n
                Bebida----------Chá de Hortlã\n
                Sobremesa-------Bolo de chocolate\n
                Total: %.2f\n
                Forma de pagamento: %s\n
                Obrigado pela preferência!!!
            \n\n=========--VOLTE SEMPRE--==========\n\n
                """,nome,total,formaPagamento);
    }

    public static void pagPix(double total){
        System.out.printf("\n\nTotal: %.2f\n\nPagamento pelo pix\n\nPIX da pizzaria: 109-109\n",total);
        System.out.print("Enviou Comprovante?[1]SIM\t[2]NÃO\nSelecione: ");
        int comp =scan.nextInt();
        if(comp==1){
            System.out.println("\nObrigado pela preferência!!!");
        }
        else if(comp==2){
            System.out.println("Desculpe não recebemos o comprovante\n\n");
            pagPix(total);
        }
        else{
            pagPix(total);
        }
    }

    public static void pagDin(){
        System.out.println("Se dirija ao caixa!");
    }

    public static void pagCarDeb() {

        System.out.println("Insira ou aproxime o cartão da máquina.");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.print("Insira a senha: ");
        String senha = scan.next();
        if(senha.length()!=4){
            System.out.println("Algo errado com a senha.\nTente novamente.");
            pagCarDeb();
        }
    }

    public static void pagCarCred(){
        System.out.print("Insira seu cpf: ");
        scan.nextLine();
        String cpf = scan.nextLine();
        int parc = recursivaCarCred();

        System.out.println("Insira ou aproxime o cartão da máquina.");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.print("Insira a senha: ");
        String senha = scan.next();
        if(senha.length()!=4){
            System.out.println("\nAlgo errado com a senha.\nTente novamente.\n");
            pagCarDeb();
        }
    }
    public static int recursivaCarCred(){
        System.out.print("Selecione em quantas vezes vai parcelar de 1 a 6 vezes: ");
        int parc = scan.nextInt();
        if(parc<1||parc>6){
            return recursivaCarCred();
        }
        return parc;
    }

    public static void formaPagamento(double total){

        System.out.print("Escolha a maneira ade pagamento:"
        +"\n1- PIX\n2- Dinheiro\n3- Cartão de Crédito\n4- Cartão de Débito\nSelecione: ");
        int op = scan.nextInt();
        switch(op){
            case 1:
                pagPix(total);
                gerarNotaFiscal("Julio", total, formasPagamento[0]);
                break;
            case 2:
                pagDin();
                gerarNotaFiscal("Julio", total, formasPagamento[1]);
                break;
            case 3:
                pagCarDeb();
                gerarNotaFiscal("Julio", total, formasPagamento[2]);
                break;
            case 4:
                pagCarCred();
                gerarNotaFiscal("Julio", total, formasPagamento[3]);
                break;
            default:
                System.out.println("Houve um erro no seu pagamento, por favor volte ao inicio.\n\n");
                formaPagamento(total);
        }
    }

   
    

}