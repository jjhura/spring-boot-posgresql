package controller;

import dto.request.ConfigRequestDto;
import dto.request.TransactionRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.ConfigPointService;
import service.LoyaltyCardService;

import javax.validation.Valid;
import java.util.Arrays;

@RestController
@RequestMapping("/api/loyalty-card")
public class LoyaltyCardController {

    @Autowired
    private ConfigPointService configPointService;

    @Autowired
    private LoyaltyCardService loyaltyCardService;

    @PostMapping("/config")
    public ResponseEntity<Object> assignPDToPDFinOS(@RequestBody ConfigRequestDto configRequestDto) {
        var data = configPointService.setConfig(configRequestDto.getPointOfConversion());
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @PostMapping("/transaction/add")
    public ResponseEntity<Object> addTransaction(@RequestBody TransactionRequestDto transactionRequestDto) throws Exception {
        var data = loyaltyCardService.updatePointForCard(transactionRequestDto);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
