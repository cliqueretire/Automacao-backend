package jornadas.pedidos.actions;

import io.restassured.http.Method;
import jornadas.generico.actions.GenericoAction;
import jornadas.generico.actions.TokenAction;
import org.junit.Assert;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PedidosAction {

    TokenAction tokenAction;
    public PedidosAction() throws Exception {
        tokenAction = new TokenAction();
    }
    public HttpResponse
    runAPIPedidosDelivery(Method method, String company, String toCustomer, String ebox, String type)throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        String json = new StringBuilder()
                .append("{\n" +
                        "    \"data\": {\n" +
                        "        \"company\": \""+company+"\",\n" +
                        "        \"toCustomer\": \""+toCustomer+"\",\n" +
                        "        \"ebox\": \""+ebox+"\",\n" +
                        "        \"type\": \""+type+"\"\n" +
                        "        \n" +
                        "    }\n" +
                        "}").toString();

        String token = tokenAction.runAPItoken("joao.santana@cliqueretire.com.br","123456");


HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://services-stg.cliqueretire.com.br/io/api/v1/order"))
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .header("Authorization","Bearer "+token)
                .header("content-type","application/json;charset=UTF-8")
                .build();

        HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());

        return response;
    }


    public void validarCamposPedidos(String nomecampo, HttpResponse response) {
        GenericoAction genericoAction = new GenericoAction();
        if(nomecampo.equalsIgnoreCase("id")){
            String auxiliar = genericoAction._JsonPath(response.body().toString(),"id");
            Assert.assertNotNull(auxiliar);
        }
        if(nomecampo.equalsIgnoreCase("type")){
            String auxiliar = genericoAction._JsonPath(response.body().toString(),"type");
            Assert.assertNotNull(auxiliar);
        }

        if(nomecampo.equalsIgnoreCase("trackingCode")){
            String auxiliar = genericoAction._JsonPath(response.body().toString(),"trackingCode");
            Assert.assertNotNull(auxiliar);
        }
        if(nomecampo.equalsIgnoreCase("status")){
            String auxiliar = genericoAction._JsonPath(response.body().toString(),"status");
            Assert.assertNotNull(auxiliar);
            Assert.assertEquals("CREATED",auxiliar);
        }
        if(nomecampo.equalsIgnoreCase("companyId")){
            String auxiliar = genericoAction._JsonPath(response.body().toString(),"companyId");
            Assert.assertNotNull(auxiliar);
        }
        if(nomecampo.equalsIgnoreCase("eboxId")){
            String auxiliar = genericoAction._JsonPath(response.body().toString(),"eboxId");
            Assert.assertNotNull(auxiliar);
            Assert.assertEquals("ba1e5703-334c-4a8e-9fe1-c26549d9af81",auxiliar);
        }

        if(nomecampo.equalsIgnoreCase("toCustomerId")){
            String auxiliar = genericoAction._JsonPath(response.body().toString(),"toCustomerId");
            Assert.assertNotNull(auxiliar);
            Assert.assertEquals("3c22ffd1-7236-44b1-aa6c-430b221864a0",auxiliar);
        }

    }
}
