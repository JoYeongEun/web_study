package ac.ks.demo.domain;

import ac.ks.demo.repository.WorkRepository;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestComponent;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.text.ParseException;

import static org.assertj.core.api.Assertions.assertThat;

public class WorkTest {
    @Autowired
    WorkRepository workRepository;
    Work savedwork;




    @Before
    public void init(){

        savedwork = workRepository.save(Work.builder()
                .company("(주)홍길동")
                .position("개발자")
                .website("http://www.company.domain")
                .startDate(new Date(2019,1,1))
                .endDate(new Date(2019,1,2))
                .summary("홍길동 회사 이력사항")
                .build()
        );
    }

    @Test
    public void testFindWork(){
        Work foundWork = workRepository.findById(savedwork.getWebsite()).orElse(null);
        assertThat(foundWork.getWebsite()).isEqualTo(savedwork.getWebsite());
    }

    @Test
    public void testFindAllcompany(){
        List<Work> findallcompany = workRepository.findAllBycompany("(주)홍길동");
        assertThat(findallcompany.size()).isEqualTo(1);
    }

    @Test
    public void testFirstcompany(){
        Work findfirstcompany = workRepository.findFirstBycompany("(주)홍길동");
        assertThat(findfirstcompany.getCompany()).isEqualTo("(주)홍길동");
    }

    }
