package br.com.buscacep.classes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MeuGson {
    Gson gson;

    public MeuGson() {
        gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
    }

    public Gson getGson() {
        return gson;
    }

    
}
