package br.com.exemplo.multiscriptbanco.view;

import java.util.List;

public class Consulta {
	private List<String> colunas;
	private List<List<Object>> linhas;

	public List<String> getColunas() {
		return colunas;
	}

	public void setColunas(List<String> colunas) {
		this.colunas = colunas;
	}

	public List<List<Object>> getLinhas() {
		return linhas;
	}

	public void setLinhas(List<List<Object>> linhas) {
		this.linhas = linhas;
	}

}
