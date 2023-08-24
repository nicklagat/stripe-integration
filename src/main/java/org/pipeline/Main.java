package org.pipeline;

import com.stripe.exception.StripeException;

public class Main {
    public static void main(String[] args) {
        String apiKey = "apiKey";


        StripeService stripeService = new StripeService(apiKey);


        String testToken = "tok_visa"; // This is a test token provided by Stripe for testing purposes.

        try {
            String chargeId = stripeService.charge(testToken, 10000000); // Example amount, e.g., $20.00
            System.out.println(chargeId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            System.out.println(stripeService.refundCharge("ch_3NihYEAUEKU5UeZQ2B50RtR7"));
        } catch (StripeException e) {
            throw new RuntimeException(e);
        }


    }


}
