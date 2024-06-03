package jornadas.generico.actions;

import io.restassured.path.json.JsonPath;

import java.net.http.HttpResponse;

import static org.junit.Assert.assertEquals;

public class GenericoAction {

    public void validarStatusCode(HttpResponse response, int code) {
        assertEquals(code,response.statusCode());
    }
    public String _JsonPath(String body, String path){
        JsonPath jsonPath= JsonPath.given(body);
        return jsonPath.getString(path);

    }


}
