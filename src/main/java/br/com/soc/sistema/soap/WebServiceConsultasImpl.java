package br.com.soc.sistema.soap;

import br.com.soc.sistema.business.ConsultaBusiness;
import br.com.soc.sistema.vo.ConsultaVo;

import javax.jws.WebService;

@WebService(endpointInterface = "br.com.soc.sistema.soap.WebServiceConsultas")
public class WebServiceConsultasImpl implements WebServiceConsultas {

    private final ConsultaBusiness business;

    public WebServiceConsultasImpl() {
        this.business = new ConsultaBusiness();
    }

    @Override
    public void inserirConsulta(ConsultaVo consultaVo) {
        business.salvarConsulta(consultaVo);
    }

    @Override
    public void excluirConsulta(String codigo) {
        business.excluirConsulta(codigo);
    }

    @Override
    public void editarConsulta(ConsultaVo consultaVo) {
        business.editarConsulta(consultaVo);
    }

    @Override
    public String buscarConsulta(String codigo) {
        return business.buscarConsultaPorCodigo(codigo).toString();
    }
}
