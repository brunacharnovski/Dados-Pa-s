/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bruna.charnovski
 */
public class Dados {

    public List<Estado> getEstados() {
        List<Estado> lista;
        lista = new ArrayList();

        try {

            Connection c = DriverManager.getConnection("jdbc:sqlite:bancocidades.db");
            Statement stm = c.createStatement();

            String sql = "SELECT  * FROM ESTADO";
            PreparedStatement pstm = c.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {

                Estado e = new Estado();
                e.setId(rs.getInt("id"));
                e.setNome(rs.getString("nome"));
                e.setSigla(rs.getString("sigla"));
                lista.add(e);
            }
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public List<Cidade> getCidade(int idEstado) {
        List<Cidade> lista;
        lista = new ArrayList();

        try {

            Connection c = DriverManager.getConnection("jdbc:sqlite:bancocidades.db");
            Statement stm = c.createStatement();

            String sql = "SELECT  * FROM CIDADE WHERE ESTADO_ID = ";
            sql += String.valueOf(idEstado);
            
            PreparedStatement pstm = c.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {

                Cidade city = new Cidade();
                city.setId(rs.getInt("id"));
                city.setNome(rs.getString("nome"));
                city.setIdEstado(rs.getInt("estado_id"));
                lista.add(city);
            }
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}
