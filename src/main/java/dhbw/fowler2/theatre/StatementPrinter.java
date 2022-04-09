package dhbw.fowler2.theatre;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;

public class StatementPrinter {

    public String print(Invoice invoice, Map<String, Play> plays) {
        var totalAmount = 0;
        var volumeCredits = 0;
        var result = String.format("Statement for %s\n", invoice.customer);

        NumberFormat frmt = NumberFormat.getCurrencyInstance(Locale.US);

        result += String.format("Amount owed is %s\n", frmt.format(invoice.calculation() / 100));
        result += String.format("You earned %s credits\n", invoice.creditCalculation);
        return result;
    }

}
