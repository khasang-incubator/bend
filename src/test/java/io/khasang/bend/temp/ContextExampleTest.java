package io.khasang.bend.temp;

import io.khasang.bend.config.AppConfig;
import io.khasang.bend.config.DataConfig;
import io.khasang.bend.config.jpa.HibernateConfig;
import io.khasang.bend.dao.BarsukDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;


// mockMvc
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class, DataConfig.class, HibernateConfig.class})
public class ContextExampleTest {

    @Autowired
    private BarsukDao barsukDao;

    @Test
    public void testEx(){
        assertNotNull(barsukDao.getByName("Jack"));
    }
}
