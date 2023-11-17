import java.util.HashMap;
import java.util.Map;

public class PrototypeRegistryDinamico {
    public static void main(String[] args) throws CloneNotSupportedException {
        criarModelo('J',"SC");
        criarModelo('F',"RS");
        ClienteRegistry3 clienteRegistry3 = ClienteRegistry3.getInstance();
        Cliente3 cliente = clienteRegistry3.getCliente3("F RS");
        cliente.nomeCliente = "João Paulo de Souza";
        cliente.documento = "1214456921";
        System.out.println(cliente);

        Cliente3 cliente2 = clienteRegistry3.getCliente3("J SC");
        cliente2.nomeCliente = "Guloseimas LTDA";
        cliente2.documento = "05.886.835/0001-04";
        cliente2.codigoCliente +=1;
        System.out.println(cliente);
        System.out.println(cliente2);
    }
    public static void criarModelo(char tipoPessoa,String UF){
        Cliente3 cliente3 = new Cliente3();
        cliente3.tipoPessoa = tipoPessoa;
        cliente3.UF = UF;

        String chave = String.format("%c %s",tipoPessoa, UF);
        ClienteRegistry3.getInstance().addCliente3(chave,cliente3);
    }
}

final class Cliente3 implements Cloneable{
    public int codigoCliente = 0;
    public String nomeCliente;
    public char tipoPessoa;
    public String documento;
    public String  UF;
    public Cliente3(){
        this.codigoCliente += 1;
    }

    @Override
    public Cliente3 clone() throws CloneNotSupportedException {
        return (Cliente3) super.clone();
    }

    @Override
    public String toString() {
        return String.format("Nome: %s - código %d | Documento %s | Tipo de Pessoa %c | Estado: %s",nomeCliente,codigoCliente,documento,tipoPessoa,UF);
    }
}

final class ClienteRegistry3{
    private static final ClienteRegistry3 INSTANCE = new ClienteRegistry3();
    private static final Map<String,Cliente3> REGISTRY = new HashMap<>();
    public static ClienteRegistry3 getInstance(){
        return INSTANCE;
    }
    public Cliente3 getCliente3(String chave) {
        try {
            return REGISTRY.get(chave).clone();
        } catch (CloneNotSupportedException ex) {
        }
        return null;
    }

    public Cliente3 addCliente3(String chave, Cliente3 cliente3){
        return REGISTRY.put(chave,cliente3);
    }
}
