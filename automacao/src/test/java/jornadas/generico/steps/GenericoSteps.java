package jornadas.generico.steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.restassured.http.Method;
import jornadas.generico.actions.GenericoAction;
import jornadas.pedidos.actions.PedidosAction;

import java.net.http.HttpResponse;

public class GenericoSteps {

    PedidosAction pedidosAction;
    GenericoAction genericoActions;

    public HttpResponse get_response() {
        return _response;
    }

    public void set_response(HttpResponse _response) {
        this._response = _response;
    }

    HttpResponse _response;

    public GenericoSteps() throws Exception {

    }




}
