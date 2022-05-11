package ServiceCalculatoare.model.payment;

public class PayPalPayment implements PaymentMethod{
    String email;
    String password;

    @Override
    public void pay() {
        System.out.println("Paying by PayPal");
    }
}
