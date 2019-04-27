package ac.ks.demo.domain;

import ac.ks.demo.repository.BasicRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BasicTest {

    @Autowired
    private BasicRepository basicRepository;
    private Basic savedBasic;

    @Before
    public void init(){
        savedBasic = basicRepository.save(Basic.builder()
                .email("홍길동@naver.com")
                .lable("웹 프로그래머")
                .name("홍길동")
                .phoneNum("010-1234-4567")
                .build()
        );
    }

        @Test
       public void testfindBasic(){
        Basic foundBasic = basicRepository.findById(savedBasic.getEmail()).orElse(null);
        assertThat(foundBasic.getEmail()).isEqualTo(savedBasic.getEmail());
        }

        @Test
        public void testfindAllname(){
        List<Basic> findallname = basicRepository.findAllByname("홍길동");
        assertThat(findallname.size()).isEqualTo(1);
        }

        @Test
        public void tsetfindname(){
        Basic findFirstname = basicRepository.findFirstByname("홍길동");
        assertThat(findFirstname.getName()).isEqualTo("홍길동");
        }

}
