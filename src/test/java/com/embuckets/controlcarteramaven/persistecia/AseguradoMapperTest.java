/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.embuckets.controlcarteramaven.persistecia;

import com.embuckets.controlcarteramaven.dominio.Asegurado;
import com.embuckets.controlcarteramaven.dominio.Domicilio;
import com.embuckets.controlcarteramaven.dominio.Email;
import com.embuckets.controlcarteramaven.dominio.Telefono;
import java.io.Serializable;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author emilio
 */
public class AseguradoMapperTest {

    private AseguradoMapper aseguradoMapperTested;

    public AseguradoMapperTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        aseguradoMapperTested = new AseguradoMapper();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of save method, of class AseguradoMapper.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        Asegurado asegurado = new Asegurado("Emilio", "Hernandez", "Segovia");
        asegurado.setRfc("HESE930522GK0");
        asegurado.agregarTelefono(new Telefono("552119514"));
        asegurado.agregarTelefono(new Telefono("551234567"));
        Domicilio domicilio = new Domicilio("Aniceto Ortega", "1330");
        domicilio.setColonia("Del Valle");
        asegurado.agregarEmail(new Email("emilio@correo.com"));
        asegurado.agregarEmail(new Email("emilio@otro.correo.com"));
        Serializable id = aseguradoMapperTested.save(asegurado);
        System.out.println("id: " + id);
    }

}
