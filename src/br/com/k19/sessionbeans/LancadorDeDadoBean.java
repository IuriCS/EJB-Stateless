package br.com.k19.sessionbeans;

import java.util.Random;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;

@Stateless
public class LancadorDeDadoBean {
	
	private static int contador;
	
	@PostConstruct
	public void init(){
		synchronized(LancadorDeDadoBean.class){
			LancadorDeDadoBean.contador++;
			System.out.println("Lançador criado...\nTotal de lançadores criados: "+LancadorDeDadoBean.contador);
		}
		
	}
	
	@PreDestroy
	public void destroy(){
		synchronized(LancadorDeDadoBean.class){
			LancadorDeDadoBean.contador--;
			System.out.println("Lançador destruído...\nTotal: "+LancadorDeDadoBean.contador);
		}
	}
	
	private Random gerador;
	
	public LancadorDeDadoBean() {
		this.gerador = new Random();
	}
	
	public int lancar(){
		return this.gerador.nextInt(6) + 1;
	}
	
}
