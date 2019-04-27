package ac.ks.demo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table
public class Location {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String postCode;

    @Column
    private  String address;

    @Builder
    public Location(String postCode, String address) {
        this.postCode = postCode;
        this.address = address;
    }
}
