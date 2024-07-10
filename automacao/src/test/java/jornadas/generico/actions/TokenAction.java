package jornadas.generico.actions;

import io.restassured.http.Method;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class TokenAction {


    public TokenAction() throws Exception {

    }

    public String runAPItoken( String email, String password)throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        String json = new StringBuilder()
                .append("{\n" +
                        "    \"email\": \""+email+"\",\n" +
                        "    \"password\": \""+password+"\"\n" +
                        "}").toString();


        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://services-stg.cliqueretire.com.br/io/api/v1/auth/sign-in"))
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .header("content-type","application/json")
                .build();

        HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
        String token = response.body();
        return token;
    }
    public String runAPItokencorreios( String email, String password)throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        String json = new StringBuilder()
                .append("{\n" +
                        "    \"email\": \""+email+"\",\n" +
                        "    \"password\": \""+password+"\"\n" +
                        "}").toString();


        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://services-stg.cliqueretire.com.br/correios/v1/authenticate"))
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .header("content-type","application/json")
                .build();

        HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
        String token = response.body();
        return token;
    }

}
