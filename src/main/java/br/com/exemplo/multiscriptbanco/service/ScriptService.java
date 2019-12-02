package br.com.exemplo.multiscriptbanco.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.stereotype.Service;

import br.com.exemplo.multiscriptbanco.view.Consulta;
import br.com.exemplo.multiscriptbanco.view.DatasourceView;
import br.com.exemplo.multiscriptbanco.view.ScriptView;

@Service
public class ScriptService {

	public Consulta executaConsulta(final ScriptView script) throws SQLException {
		Consulta consulta = new Consulta();
		DataSource data = getDataSource(script.getDatasource());
		Connection conn = data.getConnection();
		
		PreparedStatement ps = conn.prepareStatement(script.getSql());
		ResultSet rs = ps.executeQuery();
        ResultSetMetaData rsmd = rs.getMetaData();
        
        int numeroColunas = rsmd.getColumnCount();
        consulta.setColunas(new ArrayList<>());
        for (int i = 1; i <= numeroColunas; i++) {
        	consulta.getColunas().add(rsmd.getColumnLabel(i));
        }
        
		consulta.setLinhas(new ArrayList<>());
		
		while (rs.next()) {
			List<Object> linha = new ArrayList<Object>();
	        for (int i = 1; i <= numeroColunas; i++) {
	        	linha.add(rs.getObject(i));
	        }
	        consulta.getLinhas().add(linha);
		}
		
		ps.close();
		conn.close();
		
		return consulta;
		
	}
	
	public Integer executa(final ScriptView script) throws SQLException {
		DataSource data = getDataSource(script.getDatasource());
		Connection conn = data.getConnection();
		
		PreparedStatement ps = conn.prepareStatement(script.getSql());
		        
        int total = ps.executeUpdate(); 
        
		ps.close();
		conn.close();
		
		return total;
	}

		
	
	
	
	private DataSource getDataSource(final DatasourceView datasourceView) {
		return DataSourceBuilder.create().driverClassName(datasourceView.getDriver()).url(datasourceView.getUrl())
				.username(datasourceView.getUsername()).password(datasourceView.getPassword()).build();
	}
}
