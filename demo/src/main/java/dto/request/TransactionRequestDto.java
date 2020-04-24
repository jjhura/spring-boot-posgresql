package dto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import entity.LoyaltyCard;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Getter
@Setter
public class TransactionRequestDto {
    private Long loyaltyCardId;
    private Double spentAdjust;

}
