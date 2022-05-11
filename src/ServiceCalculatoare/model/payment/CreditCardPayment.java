package ServiceCalculatoare.model.payment;

import java.util.Date;

public class CreditCardPayment implements PaymentMethod{
    String name;
    Integer cardNumber;
    Integer cvv;
    Date dateOfExpirary;
    @Override
    public void pay() {
        System.out.println("Paying by card");
    }
}
