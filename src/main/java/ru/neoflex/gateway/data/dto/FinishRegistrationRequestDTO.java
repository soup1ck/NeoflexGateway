package ru.neoflex.gateway.data.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.neoflex.gateway.data.enums.Gender;
import ru.neoflex.gateway.data.enums.MaritalStatus;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class FinishRegistrationRequestDTO {

    private Gender gender;
    private MaritalStatus maritalStatus;
    private Integer dependentAmount;
    private LocalDate passportIssueDate;
    private String passportIssueBranch;
    private EmploymentDTO employment;
    private String account;
}
