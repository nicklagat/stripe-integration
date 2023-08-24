package org.pipeline;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Refund;

import java.util.HashMap;
import java.util.Map;

public class StripeService {

    public StripeService(String apiKey) {
        Stripe.apiKey = apiKey;
    }



    public String charge(String token, int amount) throws StripeException {
        Map<String, Object> chargeParams = new HashMap<>();
        chargeParams.put("amount", amount);
        chargeParams.put("currency", "usd");
        chargeParams.put("source", token);
        Charge charge = Charge.create(chargeParams);
        return "Charge successful, charge ID: " + charge.getId();
    }



    public Refund refundCharge(String chargeId) throws StripeException {
        Map<String,Object> refundParams = new HashMap<>();
        refundParams.put("charge" ,chargeId);

        return Refund.create(refundParams);

    }
}
