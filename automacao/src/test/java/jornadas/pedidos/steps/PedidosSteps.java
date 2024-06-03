package jornadas.pedidos.steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.restassured.http.Method;
import jornadas.generico.actions.GenericoAction;
import jornadas.generico.steps.GenericoSteps;
import jornadas.pedidos.actions.PedidosAction;

import java.net.http.HttpResponse;

public class PedidosSteps {
    PedidosAction pedidosAction;
    GenericoSteps genericoSteps;
    GenericoAction genericoActions;
    HttpResponse _response;
    public int _statusCode;

    public PedidosSteps() throws Exception {

        genericoSteps = new GenericoSteps();
        pedidosAction = new PedidosAction();
        genericoActions = new GenericoAction();

    }


    //executando e capturando a resposta da API
    @Dado("que eu acesso a api post pedidos de delivery com company {string},toCustomer {string},ebox {string} e type {string}")
    public void que_eu_acesso_a_api_post_pedidos_de_delivery_com_company_toCustomer_ebox_e_type(String company, String toCustomer, String ebox, String type) throws Exception {
        _response = pedidosAction.runAPIPedidosDelivery(Method.POST, company, toCustomer, ebox, type);

    }

    //validando o status code da API
    @Entao("devo obter o codigo de status {int}")
    public void devo_obter_o_codigo_de_status(Integer code) {
        genericoActions.validarStatusCode(_response,code);
    }

    //Validando os campos da API
    @Entao("devo validar o campo {string}")
    public void devoValidarOCampo(String nomecampo) {
        pedidosAction.validarCamposPedidos(nomecampo,_response);
    }
}







