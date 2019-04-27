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
public class Profile {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String url;

    @Column
    private String network;

    @Column
    private String username;

    @Builder
    public Profile(String url, String network, String username) {
        this.url = url;
        this.network = network;
        this.username = username;
    }
}
