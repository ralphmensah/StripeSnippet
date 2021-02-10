import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentConfirmParams;
import com.stripe.param.PaymentIntentCreateParams;

public class Main {
    public static void main(String[] args) throws StripeException {
        String MY_API_KEY = "add key here";

        Stripe.apiKey =MY_API_KEY;
        //work on stripe here

//        Map<String ,Object> customerParams = new HashMap<>();
//        customerParams.put("email","man@mail.com");
//        Created a customer
//        Customer customer = Customer.create(customerParams);
//        System.out.println(customer.toJson());
//        System.out.println("Customer id :" + customer.getId());

//        retrieve customer
//        CustomerRetrieveParams CustomerParams = CustomerRetrieveParams.builder()
//                .addExpand("sources").build();
//        Customer a = Customer.retrieve("cus_Iu6pfP565PDEN6", CustomerParams, null);
//        outdated
//        Customer a  = Customer.retrieve("cus_Iu6pfP565PDEN6");
//        System.out.println("Customer  for a :" + a.toJson());

//        adding a card
//        Map<String ,Object> cardParams = new HashMap<>();
//        cardParams.put("number","4242424242424242");
//        cardParams.put("exp_month","11");
//        cardParams.put("exp_year","23");
//        cardParams.put("cvc","123");
//
////        creating token for secure payment
//        Map<String ,Object> tokenParams = new HashMap<>();
//        tokenParams.put("card",cardParams);
////
//        Token token = Token.create(tokenParams);
//
////        Adding source
//        Map<String ,Object> source = new HashMap<>();
//        source.put("source", token.getId());
//
////        Adding source to customer
//            a.getSources().create(source);

//        charging a customer
//        Map<String, Object> ChargeParams = new HashMap<>();
//        ChargeParams.put("amount", 50000);
//        ChargeParams.put("currency", "usd");
//        ChargeParams.put("customer", a.getId());
//
//        Charge charge = Charge.create(ChargeParams);
//        System.out.println(charge);

        //retrieve product by price
//        Product product = Product.retrieve("prod_IrmZPDvM5UiSly");
//        System.out.println("Product params ->"+product.toJson());
//        Map<String, Object> prodParams = new HashMap<>();
//        prodParams.put("plan","price_1IG309EZz34s3JY5HNgDsqqb");//price
//        prodParams.put("quantity","1");
////        create item for subs
//        Map<String, Object> items = new HashMap<>();
//        items.put("0",prodParams);
//////        in other to subscribe provide must add the request params eg items
//        Map<String, Object> subParams = new HashMap<>();
//        subParams.put("items",items);
//        subParams.put("customer",a.getId());
//        subParams.put("off_session", "true");
////
//        Subscription cus = Subscription.create(subParams);
//        System.out.println(cus.toJson());
//
////        Creating a payment Intent
//        Map<String, Object> paymentIntParams = new HashMap<>();
//        paymentIntParams.put("amount","1000");
//        paymentIntParams.put("currency","usd");
//        paymentIntParams.put("customer",a.getId());
//
//
//        PaymentIntent paymentIntent = PaymentIntent.create(paymentIntParams);
//
//        System.out.println(paymentIntent.toJson());

        //        Creating a setup Intent
//        Map<String, Object> setUpParams = new HashMap<>();
//        setUpParams.put( "usage", "off_session");
//        setUpParams.put( "customer", a.getId());
//        setUpParams.put("payment_method_data", token.getId());
//
//        SetupIntent setupIntent =  SetupIntent.create(setUpParams);
//        System.out.println(setupIntent.toJson());

//        SetupIntent setUpRetrieved = SetupIntent.retrieve("seti_1IIV8OEZz34s3JY5c9ics0vl");


//        System.out.println(setUpRetrieved.toJson());

        PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
                .setCustomer("cus_Iu6lPq3py40Ds8")
                .setAmount(1000L)
                .setCurrency("usd")
                .build();

        PaymentIntent paymentIntent = PaymentIntent.create(params);
        System.out.println("payment intent created -> "+paymentIntent.toJson());


//        SetupIntentConfirmParams
//
        PaymentIntentConfirmParams paymentIntentConfirmParams = PaymentIntentConfirmParams.builder()
                .setPaymentMethod("pm_card_visa")
                .build();
        PaymentIntent intent = PaymentIntent.retrieve("pi_1IIeegEZz34s3JY5FpILzLOg");
        PaymentIntent confirmedIntent = intent.confirm(paymentIntentConfirmParams);
        System.out.println("payment intent created -> "+confirmedIntent.toJson());




    }
}
