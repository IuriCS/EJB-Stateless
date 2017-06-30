package br.com.k19.managedbeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import br.com.k19.sessionbeans.LancadorDeDadoBean;

@ManagedBean
public class DadoBean {
	@EJB
	private LancadorDeDadoBean lancador;
	
	private int resultado;
	
	public void lancarDado(){
		this.resultado = this.lancador.lancar();
	}

	public int getResultado() {
		return resultado;
	}

	public void setResultado(int resultado) {
		this.resultado = resultado;
	}
}