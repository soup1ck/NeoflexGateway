package ru.neoflex.gateway.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.neoflex.gateway.data.dto.LoanApplicationRequestDTO;
import ru.neoflex.gateway.data.dto.LoanOfferDTO;

import java.util.List;

@FeignClient(name = "gateway-application", url = "http://localhost:8082/application")
public interface FeignApplicationClient {

    @PostMapping
    List<LoanOfferDTO> getLoanOffers(@RequestBody LoanApplicationRequestDTO loanApplicationRequestDTO);

    @PostMapping(value = "/offer")
    void applyOffer(@RequestBody LoanOfferDTO loanOfferDTO);
}
