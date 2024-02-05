package br.com.tradin;

import br.com.tradin.client.ClientHttpConfiguration;
import br.com.tradin.service.PetService;

import java.io.IOException;

public class ImportarPetsAbrigoCommand implements Command{
    @Override
    public void execute() {
        try {
            ClientHttpConfiguration client = new ClientHttpConfiguration();
            PetService petService = new PetService(client);
            petService.importarPetsAbrigo();
        } catch (IOException | InterruptedException e) {
            //throw new RuntimeException(e);
            System.out.println(e.getMessage());
        }
    }
}
