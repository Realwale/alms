package org.vfdtech.alm.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "liability_report")
public class LiabilityReport {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @JsonProperty(value = "client_name")
    private String clientName;

    @JsonProperty(value = "effective_date")
    private LocalDate effectiveDate;

    @JsonProperty(value = "settlement_date")
    private LocalDate settlementDate;

    @JsonProperty(value = "face_amount")
    private BigDecimal faceAmount;

    @JsonProperty(value = "rate")
    private BigDecimal rate;

    @JsonProperty(value = "ttm")
    private BigDecimal ttm;
}
