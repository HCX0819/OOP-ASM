package payment;

public class Invoice {
    private String customerName;
    private double amount;
    private String paymentMethod;

    public Invoice(String customerName, double amount, String paymentMethod) {
        this.customerName = customerName;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getAmount() {
        return amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    
    

    public void printInvoice() {
        System.out.println("\n--- INVOICE ---");
        System.out.println("Customer: " + customerName);
        System.out.printf("Amount: $%.2f\n", amount);
        System.out.println("Payment Method: " + paymentMethod);
    }

    public void printReceipt() {
        System.out.println("\n--- RECEIPT ---");
        System.out.println("Payment successful for: " + customerName);
        System.out.printf("Amount Paid: $%.2f\n", amount);
    }
}
