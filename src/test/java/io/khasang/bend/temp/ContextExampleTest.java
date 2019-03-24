package io.khasang.bend.temp;

import io.khasang.bend.config.AppConfig;
import io.khasang.bend.config.DataConfig;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


// mockMvc
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class, DataConfig.class})
public class ContextExampleTest {

//    @Autowired
//    private BarsukDao barsukDao;
//
//    @Test
//    public void testEx() {
//        assertNotNull(barsukDao.getByName("Jack"));
//    }
}
