package entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name ="config_point", indexes = {@Index(columnList = "id", name = "idx_config_point")})
public class ConfigPoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "config")
    private Double config;

    @Column(name = "config_old")
    private Double configOld;

    @Column(name = "create_on")
    @CreationTimestamp
    private LocalDateTime createOn;
}
