package br.com.buscacep.classes;

public class Cep {
    private String cep;

    public Cep (int cep) {
        String stringCep = Integer.toString(cep);

        if (stringCep.length() == 8) {
            this.cep = stringCep;
        }
        else {
            throw new Error("CEP inválido");
        }
    }

    public Cep (String cep) {
        this.cep = cep.length() == 8 ? cep : " ";
        // throw new Error("CEP inválido");
    }

    public String getCep() {
        return cep;
    }

    @Override
    public String toString() {
        return "%s-%s".formatted(this.cep.substring(0, 5), this.cep.substring(5, 8));
    }
    
}
