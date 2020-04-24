package entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name ="loyalty_card", indexes = {@Index(columnList = "id", name = "idx_loyalty_card")})
public class LoyaltyCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code", length = 20)
    private String code;

    @Column(name = "phone", length = 20)
    private String phone;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "loyalty_card_type_id")
    private LoyaltyCardType loyaltyCardType;

    @Column(name = "point", length = 20, scale = 2)
    private Double point;

    @Column(name = "total_spent", length = 20, scale = 2)
    private Double totalSpent;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "create_on")
    private LocalDateTime createOn;

    @Column(name = "modified_on")
    private LocalDateTime modifiedOn;
}
