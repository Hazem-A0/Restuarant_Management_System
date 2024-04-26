package Services;

import java.util.List;

public class Bill {
    private int billId;
    private int customerId;
    private String paymentType;
    private Order order;

    // Constructor
    public Bill(int billId, int customerId, String paymentType, Order order) {
        this.billId = billId;
        this.customerId = customerId;
        this.paymentType = paymentType;
        this.order = order;
    }

    // Function to calculate total price
    public double totalPrice() {
        double totalPrice = 0.0;
        for (OrderItem item : order.getItems()) {
            totalPrice += item.getMenuItem().getPrice() * item.getQuantity();
        }
        return totalPrice;
    }

    // Function to cancel payment
    public void cancelPayment() {
        // Implementation for canceling payment
        System.out.println("Payment canceled for Bill ID: " + billId);
    }

    // Function to process payment
    public void pay() {
        // Implementation for processing payment
        System.out.println("Payment processed for Bill ID: " + billId);
    }

    // Getters and setters
    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
