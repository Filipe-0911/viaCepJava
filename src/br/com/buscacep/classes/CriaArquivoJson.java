package br.com.buscacep.classes;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import br.com.buscacep.records.Endereco;

public class CriaArquivoJson {
    private FileWriter escrita;
    private String nomeDoArquivo;
    private List<Endereco> listaEndereco;
    Gson gson = new MeuGson().getGson();

    public CriaArquivoJson(String nomeDoArquivo, List<Endereco> lista) throws IOException {
        this.nomeDoArquivo = nomeDoArquivo;
        this.listaEndereco = lista;
        this.escrita = new FileWriter(this.nomeDoArquivo);
    }
    public CriaArquivoJson(String nomeDoArquivo, Endereco e) throws IOException {
        this.nomeDoArquivo = nomeDoArquivo;
        this.escrita = new FileWriter(this.nomeDoArquivo);
    }

    public void escreveLista() throws IOException {
        this.escrita.write(gson.toJson(this.listaEndereco));
        escrita.close();
        System.out.println(this.listaEndereco);
    }

    public void escreveEndereco(Endereco e) throws IOException {
        this.escrita.write(gson.toJson(e));
        escrita.close();
        System.out.println(e);
    }

    public List<Endereco> getListaEndereco() {
        return listaEndereco;
    }


    
}
