import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Invoice {
    private String transactionId;

    public Invoice(String transactionId) {
        this.transactionId = transactionId;
    }

    @Override
    public String toString() {
        return "Invoice{transactionId='" + transactionId + "'}";
    }
}

public class InvoiceCreation {
    public static void main(String[] args) {

        List<String> transactionIds = Arrays.asList(
                "TXN1001",
                "TXN1002",
                "TXN1003"
        );

        List<Invoice> invoices = transactionIds.stream()
                .map(Invoice::new)   // constructor reference
                .collect(Collectors.toList());

        invoices.forEach(System.out::println);
    }
}
