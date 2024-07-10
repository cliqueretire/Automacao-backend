package jornadas.correios.steps;


import io.cucumber.java.pt.Dado;
import io.restassured.http.Method;
import jornadas.correios.actions.PedidosCorreiosAction;
import jornadas.generico.actions.GenericoAction;
import jornadas.generico.steps.GenericoSteps;
import jornadas.pedidos.actions.PedidosAction;

import java.net.http.HttpResponse;

public class PedidoscorreiosSteps {

PedidosCorreiosAction PedidosCorreiosAction;

HttpResponse _response;

    public int _statusCode;

    public PedidoscorreiosSteps() throws Exception {

        PedidosCorreiosAction= new PedidosCorreiosAction();
    }

    @Dado("que eu acesso a api post pedidos de correios com codigoobjeto {string},largura {string},comprimento {string}, altura {string}, peso {string}, formato {string}e pcd {string}")
    public void queEuAcessoAApiPostPedidosDeCorreiosComCodigoobjetoLarguraComprimentoAlturaPesoFormatoEPcd(String codigoobjeto, String largura, String comprimento, String altura, String peso, String formato, String pcd) throws Exception {
        _response = PedidosCorreiosAction.runAPICriarpedidoCorreios(Method.POST, codigoobjeto, largura, comprimento, altura, peso,formato,pcd);
    }





}


