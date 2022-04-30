package com.hss.ums.web;

import com.hss.ums.config.constants.Url;
import com.hss.ums.config.exception.DataValidityException;
import com.hss.ums.entity.bean.FundRaiserDto;
import com.hss.ums.entity.bean.FundsDto;
import com.hss.ums.service.funds.FundsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Url.SECURE_URL+Url.FUNDS)
@CrossOrigin
public class FundsController {

    @Autowired
    private FundsService fundsService;

    @GetMapping
    public ResponseEntity<?> funds(){
        return ResponseEntity.ok(fundsService.funds());
    }

    @GetMapping(Url.RAISER)
    public ResponseEntity<?> fundRaisers(){
        return ResponseEntity.ok(fundsService.fundRaisers());
    }

    @PostMapping
    public ResponseEntity<?> addFunds(@RequestBody FundsDto funds) throws DataValidityException {
        return ResponseEntity.ok(fundsService.addFunds(funds));
    }

    @PostMapping(Url.RAISER)
    public ResponseEntity<?> addFundRaiser(@RequestBody FundRaiserDto fundRaiser) throws DataValidityException {
        return ResponseEntity.ok(fundsService.addFundRaiser(fundRaiser));
    }

}
