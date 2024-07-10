# language: pt
@pedidocorreios
Funcionalidade: Validar pedidos correios

    @pedidocorreiospost
    Esquema do Cenário: Verificar criar pedidos correios
        Dado que eu acesso a api post pedidos de correios com codigoobjeto "<codigoobjeto>",largura "<largura>",comprimento "<comprimento>", altura "<altura>", peso "<peso>", formato "<formato>"e pcd "<pcd>"
        Entao devo obter o codigo de status 200

        Exemplos:
            |codigoobjeto |largura|comprimento|altura|peso|formato |pcd|
            |teste109     |5      |5          |5     |1   |pacote  |N  |
