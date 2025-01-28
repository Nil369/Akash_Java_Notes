interface Notifier {
    void sendNotification(String message);
}

public class _7_AnonymousLambda {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        //1. Anonymous Classes:
        // Notify via Email
        Notifier emailNotifier = new Notifier() {
            @Override
            public void sendNotification(String message) {
                System.out.println("Sending Email: " + message);
            }
        };

        // Notify via SMS
        Notifier smsNotifier = new Notifier() {
            @Override
            public void sendNotification(String message) {
                System.out.println("Sending SMS: " + message);
            }
        };


        // 2. Lambda Expressions:
        // Notify via Email
        Notifier emailNotify = message -> System.out.println("Sending Email: " + message);

        // Notify via SMS
        Notifier smsNotify = message -> System.out.println("Sending SMS: " + message);

        // Sending notifications
        emailNotifier.sendNotification("Your order has been shipped!");
        smsNotifier.sendNotification("Your order will arrive tomorrow.");

        emailNotify.sendNotification("Your order has been shipped using Lambda Expressions!");
        smsNotify.sendNotification("Your order will arrive tomorrow, using Lambda Expressions!");


    }
}
