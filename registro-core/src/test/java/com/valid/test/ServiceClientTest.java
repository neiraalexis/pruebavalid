/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valid.test;

import com.valid.config.SpringJdbcConfig;
import com.valid.model.Cliente;
import com.valid.service.ClientService;
import java.util.Arrays;
import junit.framework.Assert;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author neira
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringJdbcConfig.class})
public class ServiceClientTest {

    @Autowired
    private ClientService service;

    @Test
    public void testFindAll() {
        assertEquals(5, service.findAll().size());
    }
    
    @Test
    public void testInsert() {
        assertEquals(true,service.create(new Cliente("Test Name", "Test Last"))>0);
    }

    @Test
    public void testProcess() {
        assertEquals("Processing batch 2 lots (5 c/u)", 2, service.processBatch(Arrays.asList(1, 2, 3, 4, 5, 6, 7)));
    }

    @Test(expected = Exception.class)
    public void testFindException() {
        assertEquals("Finding client", 100, service.findById(100));
    }

}
