package ru.neoflex.gateway.data.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@Schema(description = "Предложение по кредиту")
public class LoanOfferDTO {

    @Schema(description = "id предложения")
    private Long applicationId;

    @Schema(description = "Запрашиваемая сумма")
    private BigDecimal requestedAmount;

    @Schema(description = "Конечная сумма")
    private BigDecimal totalAmount;

    @Schema(description = "Кол-во месяцев")
    private Integer term;

    @Schema(description = "Месячный платеж")
    private BigDecimal monthlyPayment;

    @Schema(description = "Ставка")
    private BigDecimal rate;

    @Schema(description = "Включена ли страховка")
    private Boolean isInsuranceEnabled;

    @Schema(description = "Зарплатный клиент")
    private Boolean isSalaryClient;
}
