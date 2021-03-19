/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valid.service;

import com.valid.dao.ClienteMapper;
import com.valid.model.Cliente;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

/**
 *
 * @author neira
 */
@Service
public class ClientService {

    @Autowired
    private JdbcTemplate jtm;

    /**
     *
     * @return all clients
     */
    public List<Cliente> findAll() {

        String sql = "SELECT * FROM cliente";
        List<Cliente> clientes = jtm.query(sql, new ClienteMapper());
        return clientes;
    }

    /**
     *
     * @param id
     * @return the client by id
     */
    public Cliente findById(Integer id) {
        String sql = "SELECT * FROM cliente WHERE ID=?";
        Cliente cliente = (Cliente) jtm.queryForObject(sql, new ClienteMapper(), id);

        return cliente;
    }

    /**
     *
     * @param cliente
     * @return the client created with id
     */
    public int create(Cliente cliente) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jtm.getDataSource())
                .withTableName("cliente").usingGeneratedKeyColumns("id");
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("nombre", cliente.getNombre());
        parameters.put("apellido", cliente.getApellido());
        parameters.put("procesado", cliente.isProcesado());
        return simpleJdbcInsert.executeAndReturnKey(parameters).intValue();
    }

    /**
     *
     * @param ids
     * @return a total lots executions
     */
    public int processBatch(List<Integer> ids) {
        String sql = "UPDATE cliente set procesado=?2  where id=?1";
        int count = jtm.batchUpdate(sql, ids, 5,
                (PreparedStatement ps, Integer id) -> {
                    ps.setInt(1, id);
                    ps.setBoolean(2, true);
                }
        ).length;
        return count;
    }

}
