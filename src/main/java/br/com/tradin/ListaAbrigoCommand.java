package br.com.tradin;

import br.com.tradin.client.ClientHttpConfiguration;
import br.com.tradin.service.AbrigoService;

import java.io.IOException;

public class ListaAbrigoCommand implements Command{



    @Override
    public void execute() {
        try {
            ClientHttpConfiguration client = new ClientHttpConfiguration();
            AbrigoService abrigoService = new AbrigoService(client);
            abrigoService.listarAbrigos();
        } catch (IOException | InterruptedException e) {
            // throw new RuntimeException(e.getMessage());
            System.out.println(e.getMessage());
        }
    }
}
