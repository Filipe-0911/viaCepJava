import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;

import br.com.buscacep.classes.Cep;
import br.com.buscacep.classes.ConectaApi;
import br.com.buscacep.classes.CriaArquivoJson;
import br.com.buscacep.classes.MeuGson;
import br.com.buscacep.records.Endereco;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String valorObtidoSystem = "";
        List<Endereco> listaEnderecos = new ArrayList<>();

        while(!valorObtidoSystem.equals("sair")) {
            System.out.println("Digite um cep: ");
            valorObtidoSystem = (String) in.nextLine();
            
            if(valorObtidoSystem.equals("sair")) break;

            Gson gson = new MeuGson().getGson();

            try {
                Cep cep = new Cep(valorObtidoSystem);
    
                ConectaApi connect = new ConectaApi(cep.getCep());
                Endereco endereco = gson.fromJson(connect.getJson(), Endereco.class);

                listaEnderecos.add(endereco);
        
                
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("Programa finalizado com sucesso.");
            }
        }
        
        CriaArquivoJson arquivo = new CriaArquivoJson("enderecos.json", listaEnderecos);
        arquivo.escreveLista();
        in.close();
    }
}
