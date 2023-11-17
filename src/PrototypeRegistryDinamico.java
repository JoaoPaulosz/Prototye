import java.util.HashMap;
import java.util.Map;

public class PrototypeRegistryDinamico {
    public static void main(String[] args) throws CloneNotSupportedException {
        ClienteRegistry2 clienteRegistry2 = ClienteRegistry2.getInstance();
        Cliente2 cliente = clienteRegistry2.getCliente2("PESSOA FISICA");
        cliente.nomeCliente = "João Paulo de Souza";
        cliente.documento = "1214456921";
        System.out.println(cliente);

        Cliente2 cliente2 = clienteRegistry2.getCliente2("PESSOA JURIDICA");
        cliente2.nomeCliente = "Guloseimas LTDA";
        cliente2.documento = "05.886.835/0001-04";
        cliente2.codigoCliente +=1;
        System.out.println(cliente);
        System.out.println(cliente2);
    }
}

final class Cliente3 implements Cloneable{
    public int codigoCliente = 0;
    public String nomeCliente;
    public char tipoPessoa;
    public String documento;

    public Cliente3(){
        this.codigoCliente += 1;
    }

    @Override
    public Cliente3 clone() throws CloneNotSupportedException {
        return (Cliente3) super.clone();
    }

    @Override
    public String toString() {
        return String.format("Nome: %s - código %d | Documento %s | Tipo de Pessoa %c",nomeCliente,codigoCliente,documento,tipoPessoa);
    }
}

final class ClienteRegistry3{
    private static final ClienteRegistry3 INSTANCE = new ClienteRegistry3();
    private static final Map<String,Cliente3> REGISTRY = new HashMap<>();
    static {
        Cliente3 c2 = new Cliente3();
        c2.tipoPessoa = 'F';
        REGISTRY.put("PESSOA FISICA", c2);

        Cliente3 c3 = new Cliente3();
        c3.tipoPessoa = 'J';
        REGISTRY.put("PESSOA JURIDICA",c3);
    }
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
}
