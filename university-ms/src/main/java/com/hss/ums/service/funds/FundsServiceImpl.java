package com.hss.ums.service.funds;

import com.hss.ums.config.exception.DataValidityException;
import com.hss.ums.entity.FundRaiser;
import com.hss.ums.entity.Funds;
import com.hss.ums.entity.bean.FundRaiserDto;
import com.hss.ums.entity.bean.FundsDto;
import com.hss.ums.repo.FundsRaiserRepo;
import com.hss.ums.repo.FundsRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FundsServiceImpl implements FundsService{

    @Autowired
    private FundsRepo fundsRepo;

    @Autowired
    private FundsRaiserRepo raiserRepo;

    @Override
    public List<FundsDto> funds() {
        List<FundsDto> funds = new ArrayList<>();
        fundsRepo.findAll().forEach(fund -> {
            funds.add(new FundsDto(fund));
        });
        return funds;
    }

    @Override
    public List<FundRaiserDto> fundRaisers() {
        List<FundRaiserDto> funds = new ArrayList<>();
        raiserRepo.findAll().forEach(fundRaiser -> {
            funds.add(new FundRaiserDto(fundRaiser));
        });
        return funds;
    }

    @Override
    public FundsDto addFunds(FundsDto funds) throws DataValidityException {

        if(funds.getAmount() == null || funds.getAmount()<0)
            throw new DataValidityException("Invalid Fund Amount!");

        if(funds.getDeposit() == null)
            funds.setDeposit(true);

        if(funds.getName() == null || funds.getName().isEmpty())
            funds.setName("Not Provided!");

        if(funds.getRemarks() == null || funds.getRemarks().isEmpty())
            funds.setRemarks("Not Provided!");

        Funds fund = new Funds();
        BeanUtils.copyProperties(funds, fund);

        return new FundsDto(fundsRepo.save(fund));
    }

    @Override
    public FundRaiserDto addFundRaiser(FundRaiserDto fundRaiserDto) throws DataValidityException {

        if(fundRaiserDto.getAmount() == null || fundRaiserDto.getAmount()<0)
            throw new DataValidityException("Invalid Fund Amount!");

        if(fundRaiserDto.getReason() == null || fundRaiserDto.getReason().isEmpty())
            throw new DataValidityException("There must be a reason!");

        if(fundRaiserDto.getRemarks() == null || fundRaiserDto.getRemarks().isEmpty())
            fundRaiserDto.setRemarks("Not Provided!");

        FundRaiser fundRaiser = new FundRaiser();
        BeanUtils.copyProperties(fundRaiserDto, fundRaiser);

        return new FundRaiserDto(raiserRepo.save(fundRaiser));
    }
}
