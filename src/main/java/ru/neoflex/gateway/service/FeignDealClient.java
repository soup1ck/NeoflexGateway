package ru.neoflex.gateway.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.neoflex.gateway.data.dto.FinishRegistrationRequestDTO;

@FeignClient(name = "gateway-deal", url = "http://localhost:8081/deal")
public interface FeignDealClient {

    @PutMapping(value = "/calculate/{applicationId}")
    void calculateRequest(@RequestBody FinishRegistrationRequestDTO finishRegistrationRequestDTO,
                          @PathVariable Long applicationId);

    @PostMapping(value = "/document/{applicationId}/send")
    void sendRequestForDocument(@PathVariable Long applicationId);

    @PostMapping(value = "/document/{applicationId}/sign")
    void sendRequestForSignDocument(@PathVariable Long applicationId);

    @PostMapping(value = "/document/{applicationId}/{code}")
    void signDocument(@PathVariable Long applicationId, @PathVariable Integer code);
}
