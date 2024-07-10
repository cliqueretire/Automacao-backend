package jornadas.correios.actions;

import io.restassured.http.Method;
import jornadas.generico.actions.TokenAction;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PedidosCorreiosAction {

    TokenAction tokenAction;
    public PedidosCorreiosAction() throws Exception {
        tokenAction = new TokenAction();
    }
    public HttpResponse
    runAPICriarpedidoCorreios(Method method, String codigoobjeto, String largura, String comprimento, String altura, String peso, String formato, String pcd)throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        String json = new StringBuilder()
                .append("{\n" +
                        "    \"data\": {\n" +
                        "        \"codigoobjeto\": \""+codigoobjeto+"\",\n" +
                        "        \"largura\": \""+largura+"\",\n" +
                        "        \"comprimento\": \""+comprimento+"\",\n" +
                        "        \"altura\": \""+altura+"\"\n" +
                        "        \"peso\": \""+peso+"\"\n" +
                        "        \"formato\": \""+formato+"\"\n" +
                        "        \"pcd\": \""+pcd+"\"\n" +
                        "        \n" +
                        "    }\n" +
                        "}").toString();

        String token = tokenAction.runAPItokencorreios("alinearrivabene@correios.com.br","*53kgWsuVy8XCs*P");


        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://services-stg.cliqueretire.com.br/correios/v1/lockers/correios/05503989/objeto"))
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .header("Authorization","Bearer "+"")
                .header("content-type","application/json")
                .build();

        HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());

        return response;
    }
}
