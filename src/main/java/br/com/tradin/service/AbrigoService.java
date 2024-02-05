package br.com.tradin.service;

import br.com.tradin.client.ClientHttpConfiguration;
import br.com.tradin.domain.Abrigo;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AbrigoService {

    ClientHttpConfiguration client;

    public AbrigoService(ClientHttpConfiguration client) {
        this.client = client;
    }

    public void listarAbrigos() throws IOException, InterruptedException {
        String uri = "http://localhost:8080/abrigos";
        HttpResponse<String> response = client.requisicaoGet(uri);
        String responseBody = response.body();
        Abrigo[] abrigos = new ObjectMapper().readValue(responseBody, Abrigo[].class);
        List<Abrigo> abrigoList = Arrays.stream(abrigos).toList();
        if (abrigoList.isEmpty()) {
            System.out.println("Não há abrigos cadastrados");
        } else {
            mostrarAbrigos(abrigoList);
        }
    }

    private void mostrarAbrigos(List<Abrigo> abrigos) {
        System.out.println("Abrigos cadastrados:");
        for (Abrigo abrigo : abrigos) {
            long id = abrigo.getId();
            String nome = abrigo.getNome();
            System.out.println(id +" - " +nome);
        }
    }

    public void cadastrarAbrigo() throws IOException, InterruptedException {
        System.out.println("Digite o nome do abrigo:");
        String nome = new Scanner(System.in).nextLine();
        System.out.println("Digite o telefone do abrigo:");
        String telefone = new Scanner(System.in).nextLine();
        System.out.println("Digite o email do abrigo:");
        String email = new Scanner(System.in).nextLine();

        Abrigo abrigo = new Abrigo(nome, email, telefone);

        String uri = "http://localhost:8080/abrigos";
        HttpResponse<String> response = client.requisicaoPost(uri, abrigo);
        int statusCode = response.statusCode();
        String responseBody = response.body();
        if (statusCode == 200) {
            System.out.println("Abrigo cadastrado com sucesso!");
            System.out.println(responseBody);
        } else if (statusCode == 400 || statusCode == 500) {
            System.out.println("Erro ao cadastrar o abrigo:");
            System.out.println(responseBody);
        }
    }

}
