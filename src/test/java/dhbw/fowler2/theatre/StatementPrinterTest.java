package dhbw.fowler2.theatre;

import dhbw.fowler2.theatre.kategorien.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class StatementPrinterTest {
    
    @Test
    public void printsStatements() {
        List<Play> plays = new ArrayList<Play>();
        plays.add(0, new Tragedy("Hamlet"));
        plays.add(1, new Comedy("As You Like It"));
        plays.add(2, new Tragedy("Othello"));

        
        Invoice invoice = new Invoice("BigCo", List.of(new Performance(plays.get(0), 55),
        new Performance(plays.get(1), 35),
        new Performance(plays.get(2), 40)));
        
        StatementPrinter statementPrinter = new StatementPrinter(plays);
        var result = statementPrinter.statement(invoice);
        
        Assert.assertEquals("Statement print mismatch", "Statement for BigCo\n" +
        " Hamlet: $650.00 (55 seats)\n" +
        " As You Like It: $580.00 (35 seats)\n" +
        " Othello: $500.00 (40 seats)\n" +
        "Amount owed is $1,730.00\n" +
        "You earned 47 credits\n", result);
    }
}