/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valid.dao;

import com.valid.model.Cliente;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author neira
 */
public class ClienteMapper implements RowMapper<Cliente> {

    /**
     * Converts the result set database in object 
     * @param rs
     * @param rowNum
     * @return
     * @throws SQLException
     */
    @Override
    public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Cliente(rs.getString("nombre"), rs.getString("apellido"),rs.getInt("id"),rs.getBoolean("procesado"));
    }

}
