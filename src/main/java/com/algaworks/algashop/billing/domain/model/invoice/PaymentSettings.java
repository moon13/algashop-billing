package com.algaworks.algashop.billing.domain.model.invoice;


import com.algaworks.algashop.billing.domain.model.IdGenerator;
import lombok.*;

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
        return new PaymentSettings(
                IdGenerator.generateTimeBasedUUID(),
                creditCard,
                null,
                method

        );

    }

    void assignGatewayCode(String gatewayCode) {
        setGatewayCode(gatewayCode);
    }
}
