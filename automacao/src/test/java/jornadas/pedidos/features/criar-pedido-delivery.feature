# language: pt
@pedidodeliveryreturn
Funcionalidade: Validar pedidos delivery

  @pedidoreturndeliverypost
  Esquema do Cenário: Verificar criar pedidos return e delivery
    Dado que eu acesso a api post pedidos de delivery com company "<company>",toCustomer "<toCustomer>",ebox "<ebox>" e type "<type>"
    Entao devo obter o codigo de status 200

    Exemplos:
      | company                              | toCustomer                           | ebox                                | type    |
      | 35fee5a5-4b5a-42ef-a583-55fd4e4f364d | 3c22ffd1-7236-44b1-aa6c-430b221864a0 |ba1e5703-334c-4a8e-9fe1-c26549d9af81 |return   |


  @validarcampospost @validarcampos
  Esquema do Cenário: Validar campos da api delivery e return
    Dado que eu acesso a api post pedidos de delivery com company "<company>",toCustomer "<toCustomer>",ebox "<ebox>" e type "<type>"
    Entao devo obter o codigo de status 200
    Entao devo validar o campo "id"
    Entao devo validar o campo "type"
    Entao devo validar o campo "trackingCode"
    Entao devo validar o campo "status"
    Entao devo validar o campo "companyId"
    Entao devo validar o campo "eboxId"
    Entao devo validar o campo "toCustomerId"

    Exemplos:
      | company                              | toCustomer                           | ebox                                | type    |
      | 35fee5a5-4b5a-42ef-a583-55fd4e4f364d | 3c22ffd1-7236-44b1-aa6c-430b221864a0 |ba1e5703-334c-4a8e-9fe1-c26549d9af81 |delivery |


