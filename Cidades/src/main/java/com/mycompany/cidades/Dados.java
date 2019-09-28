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
                e.setId(0);
                e.setNome("nome");
                e.setSigla("sigla");
                lista.add(e);
            }
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}
