// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class ProtypeClone {
    public static void main(String[] args) throws CloneNotSupportedException {
        Cliente cliente = new Cliente();
        cliente.nomeCliente = "João Paulo de Souza";
        cliente.codigoCliente = 1;
        cliente.tipoPessoa = 'F';
        cliente.documento = "1214456921";
        System.out.println(cliente);

        Cliente cliente2 = cliente.clone();
        cliente2.codigoCliente += 1;
        System.out.println(cliente);
        System.out.println(cliente2);
    }
}
final class Cliente implements Cloneable{
    public int codigoCliente;
    public String nomeCliente;
    public char tipoPessoa;
    public String documento;

    @Override
    public Cliente clone() throws CloneNotSupportedException {
        return (Cliente) super.clone();
    }

    @Override
    public String toString() {
        return String.format("Nome: %s - código %d | Documento %s",nomeCliente,codigoCliente,documento);
    }
}