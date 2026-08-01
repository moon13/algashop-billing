package com.algaworks.algashop.billing.domain.model.invoice;


import com.algaworks.algashop.billing.domain.model.DomainException;
import com.algaworks.algashop.billing.domain.model.IdGenerator;
import lombok.*;
import org.springframework.util.StringUtils;

import java.util.Objects;
import java.util.UUID;

@Setter(AccessLevel.PRIVATE)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class PaymentSettings {

    @EqualsAndHashCode.Include
     private UUID id;
    private UUID creditCardId;
    private String gatewayCode;
    private PaymentMethod paymentMethod;


    public static PaymentSettings brandNew(PaymentMethod method, UUID creditCard) {
        Objects.requireNonNull(method);
        if (method.equals(PaymentMethod.CREDIT_CARD)){
            Objects.requireNonNull(creditCard);
        }
        return new PaymentSettings(
                IdGenerator.generateTimeBasedUUID(),
                creditCard,
                null,
                method

        );

    }

    void assignGatewayCode(String gatewayCode) {
        if(StringUtils.isEmpty(gatewayCode)){
            throw new IllegalArgumentException();
        }
        if(this.gatewayCode != null){
            throw new DomainException("Gateway code already assigned");
        }

        setGatewayCode(gatewayCode);
    }
}
