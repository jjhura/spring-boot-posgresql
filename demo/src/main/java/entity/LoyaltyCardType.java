package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name ="loyalty_card_type", indexes = {@Index(columnList = "id", name = "idx_loyalty_card_type")})
public class LoyaltyCardType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "spent_threshold", length = 20, scale = 2)
    private Double spentThreshold;

    @Column(name = "duration", length = 10)
    private Long duration;

    @Column(name = "discount_percent", length = 2)
    private Double discountPercent;

    @Column(name = "create_on")
    private LocalDateTime createOn;

    @Column(name = "modified_on")
    private LocalDateTime modifiedOn;
}
