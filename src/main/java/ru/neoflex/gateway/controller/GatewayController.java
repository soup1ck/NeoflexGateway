package ru.neoflex.gateway.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.neoflex.gateway.data.dto.FinishRegistrationRequestDTO;
import ru.neoflex.gateway.data.dto.LoanApplicationRequestDTO;
import ru.neoflex.gateway.data.dto.LoanOfferDTO;
import ru.neoflex.gateway.service.FeignApplicationClient;
import ru.neoflex.gateway.service.FeignDealClient;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Шлюз",
        description = "Микросервис для реализации паттерна api-gateway")
public class GatewayController {

    private final FeignApplicationClient feignApplicationClient;
    private final FeignDealClient feignDealClient;

    @Operation(summary = "Получение предложений по кредиту")
    @PostMapping(value = "/application")
    public List<LoanOfferDTO> getLoanOffers(@RequestBody LoanApplicationRequestDTO loanApplicationRequestDTO) {
        return feignApplicationClient.getLoanOffers(loanApplicationRequestDTO);
    }

    @Operation(summary = "Установка принятого предложения")
    @PostMapping(value = "/application/apply")
    public void applyOffer(@RequestBody LoanOfferDTO loanOfferDTO) {
        feignApplicationClient.applyOffer(loanOfferDTO);
    }

    @Operation(summary = "Окончательная регистрация")
    @PostMapping(value = "application/registration/{applicationId}")
    public void calculateRequest(@RequestBody FinishRegistrationRequestDTO finishRegistrationRequestDTO,
                                 @PathVariable Long applicationId) {
        feignDealClient.calculateRequest(finishRegistrationRequestDTO, applicationId);
    }

    @Operation(summary = "Получение документов по кредиту на почту")
    @PostMapping(value = "document/{applicationId}")
    public void sendRequestForDocument(@PathVariable Long applicationId) {
        feignDealClient.sendRequestForDocument(applicationId);
    }

    @Operation(summary = "Запрос на подписание документов и получение кода на почту")
    @PostMapping(value = "document/{applicationId}/sign")
    public void sendRequestForSignDocument(@PathVariable Long applicationId) {
        feignDealClient.sendRequestForSignDocument(applicationId);
    }

    @Operation(summary = "Подпись документов")
    @PostMapping(value = "document/{applicationId}/{code}")
    public void signDocument(@PathVariable Long applicationId, @PathVariable Integer code) {
        feignDealClient.signDocument(applicationId, code);
    }
}
