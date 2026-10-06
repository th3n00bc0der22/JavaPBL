package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.Protagonista;
import views.Terminal;

import java.io.File;
import java.io.IOException;

public class Database {

    private final ObjectMapper mapper;
    private final File arquivo;

    // A classe configura o motor do Jackson e o arquivo alvo logo na instanciação
    public Database(String caminhoArquivo) {
        this.mapper = new ObjectMapper();
        this.arquivo = new File(caminhoArquivo);
    }

    // Abre o arquivo, escreve o JSON identado, e fecha automaticamente
    public void salvarProgresso(Protagonista protagonista) {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(arquivo, protagonista);
            System.out.println("Jogo salvo em: " + arquivo.getAbsolutePath());
            Terminal.aplicaDelay(1000);
        } catch (IOException e) {
            System.out.println("Erro ao tentar salvar o arquivo: " + e.getMessage());
            Terminal.aplicaDelay(1000);

        }
        catch (Exception e){
            System.out.println("sei la" + e.getMessage());
        }
    }

    // Abre o arquivo, constrói o objeto via sobrecarga, e fecha automaticamente
    public Protagonista carregarProgresso() {
        if (!arquivo.exists()) {
            System.out.println("Nenhum save encontrado no caminho especificado.");
            return null;
        }

        try {
            return mapper.readValue(arquivo, Protagonista.class);
        } catch (IOException e) {
            System.out.println("Erro ao carregar o save: " + e.getMessage());
            return null;
        }
    }
}