package ac.ks.demo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Getter
@NoArgsConstructor
@Entity
@Table
public class Work {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String website;

    @Column
    private String company;

    @Column
    private String position;

    @Column
    private Date startDate;

    @Column
    private Date endDate;

    @Column
    private String summary;

    @Builder
    public Work(String website, String company, String position, Date startDate, Date endDate, String summary) {
        this.website = website;
        this.company = company;
        this.position = position;
        this.startDate = startDate;
        this.endDate = endDate;
        this.summary = summary;
    }
}
