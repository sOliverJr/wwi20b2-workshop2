package dhbw.fowler2.theatre;

import dhbw.fowler2.theatre.kategorien.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class StatementPrinterTest {
    
    @Test
    public void printsTextStatements() {
        List<Play> plays = new ArrayList<Play>();
        plays.add(0, new Tragedy("Hamlet"));
        plays.add(1, new Comedy("As You Like It"));
        plays.add(2, new Tragedy("Othello"));

        
        Invoice invoice = new Invoice("BigCo", List.of(new Performance(plays.get(0), 55),
        new Performance(plays.get(1), 35),
        new Performance(plays.get(2), 40)));
        
        StatementPrinter statementPrinter = new StatementPrinter(plays);
        var result = statementPrinter.textStatement(invoice);

        System.out.print(result);

        Assert.assertEquals("Statement print mismatch", "Statement for BigCo\n" +
        " Hamlet: $650.00 (55 seats)\n" +
        " As You Like It: $580.00 (35 seats)\n" +
        " Othello: $500.00 (40 seats)\n" +
        "Amount owed is $1,730.00\n" +
        "You earned 47 credits\n", result);
    }


    @Test
    public void printsHtmlStatements() {
        List<Play> plays = new ArrayList<Play>();
        plays.add(0, new Tragedy("Hamlet"));
        plays.add(1, new Comedy("As You Like It"));
        plays.add(2, new Tragedy("Othello"));

        
        Invoice invoice = new Invoice("BigCo", List.of(new Performance(plays.get(0), 55),
        new Performance(plays.get(1), 35),
        new Performance(plays.get(2), 40)));
        
        StatementPrinter statementPrinter = new StatementPrinter(plays);
        
        var result = statementPrinter.HtmlStatement(invoice);


        Assert.assertEquals("<h1>Statement for BigCo</h1>\n" +
        "<table>\n" + 
        "<tr><th>play</th><th>seats</th><th>cost</th></tr><tr><td>Hamlet</td><td>55</td><td>$65,000.00</td></tr>\n" +
        "<tr><td>As You Like It</td><td>35</td><td>$58,000.00</td></tr>\n" +
        "<tr><td>Othello</td><td>40</td><td>$50,000.00</td></tr>\n" +
        "</table>\n" +
        "<p>Amount owed is <em>$1,730.00</em></p>\n" + 
        "<p>You earned <em>47</em> credits</p>", result);
    }

    
}