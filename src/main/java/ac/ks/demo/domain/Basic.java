package ac.ks.demo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class Basic {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  String email;

    @Column
    private  String lable;

    @Column
    private  String name;

    @Column
    private  String phoneNum;

    @Builder
    public Basic(String name, String lable, String email, String phoneNum) {
        this.name = name;
        this.lable = lable;
        this.email = email;
        this.phoneNum = phoneNum;
    }
}
