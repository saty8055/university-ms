package com.hss.ums.service.funds;

import com.hss.ums.config.exception.DataValidityException;
import com.hss.ums.entity.FundRaiser;
import com.hss.ums.entity.Funds;
import com.hss.ums.entity.bean.FundRaiserDto;
import com.hss.ums.entity.bean.FundsDto;

import java.util.List;

public interface FundsService {

    List<FundsDto> funds();

    List<FundRaiserDto> fundRaisers();

    FundsDto addFunds(FundsDto funds) throws DataValidityException;

    FundRaiserDto addFundRaiser(FundRaiserDto fundRaiser) throws DataValidityException;

}
