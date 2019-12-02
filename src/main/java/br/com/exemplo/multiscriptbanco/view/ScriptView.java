package br.com.exemplo.multiscriptbanco.view;

public class ScriptView {
	private String sql;
	private DatasourceView datasource;

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public DatasourceView getDatasource() {
		return datasource;
	}

	public void setDatasource(DatasourceView datasource) {
		this.datasource = datasource;
	}

}
