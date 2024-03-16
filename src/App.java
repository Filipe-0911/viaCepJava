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
            System.out.println("Digite um CEP para obter dados ou digite SAIR ");
            valorObtidoSystem = (String) in.nextLine();

            if(valorObtidoSystem.equalsIgnoreCase("sair")) break;

            Gson gson = new MeuGson().getGson();

            try {
                Cep cep = new Cep(valorObtidoSystem);
    
                ConectaApi connect = new ConectaApi(cep.getCep());
                Endereco endereco = gson.fromJson(connect.getJson(), Endereco.class);
                System.out.println(endereco);

                listaEnderecos.add(endereco);
        
                
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("Programa finalizado com sucesso.");
            }
        }
        
        if(listaEnderecos.size() > 0) {
            CriaArquivoJson arquivo = new CriaArquivoJson("enderecos.json", listaEnderecos);
            arquivo.escreveLista();
            in.close();
        } else {
            System.out.println("Você não informou nenhum CEP válido.");
        }
    }
}
