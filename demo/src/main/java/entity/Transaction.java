package entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name ="transaction", indexes = {@Index(columnList = "id", name = "idx_transaction")})
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "loyalty_card_id")
    private LoyaltyCard loyaltyCard;

    @Column(name = "point_adjust", length = 20)
    private Double pointAdjust;

    @Column(name = "spent_adjust", length = 20)
    private Double spentAdjust;

    @Column(name = "create_on")
    private LocalDateTime createOn;
}
