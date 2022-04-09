package dhbw.fowler2.theatre;

import dhbw.fowler2.theatre.kategorien.Play;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class StatementPrinter {
    
    protected List<Play> allPlays;
    
    public StatementPrinter(List<Play> plays) {
        allPlays = plays;
    }            

    private StatementData createStatementData(Invoice invoice) {
        var result = new StatementData();
        result.customer = invoice.customer;
        result.performances = invoice.performances;
        result.totalAmount = totalAmount(result.performances);
        result.totalVolumeCredits = totalVolumeCredits(result.performances);
        return result;
    }
    
    public String textStatement(Invoice invoice) {
        return renderText(createStatementData(invoice));
    }

    public String HtmlStatement(Invoice invoice){
        return renderHTML(createStatementData(invoice));
    }
    
    protected String usd(int aNumber) {
        NumberFormat frmt = NumberFormat.getCurrencyInstance(Locale.US);
        return frmt.format(aNumber);
    }
    
    protected int totalVolumeCredits(List<Performance> performances) {
        var result = 0;
        for (var perf : performances) {
            result += volumeCreditsFor(perf);
        }
        return result;
    }
    
    protected int volumeCreditsFor(Performance aPerformance) {
        return aPerformance.play.getVolumeCredits(aPerformance);
    }

    protected int totalAmount(List<Performance> performances) {
        int result = 0;
        for (var perf : performances) {
            result += amountFor(perf) / 100;
        }
        return result;
    }
    
    protected int amountFor(Performance aPerformance) {
        return aPerformance.play.getAmount(aPerformance);
    }
    
    public String renderText(StatementData data) {
        var result = String.format("Statement for %s\n", data.customer);

        for (var perf : data.performances) {
            result += String.format(" %s: %s (%s seats)\n", perf.play.name, usd(amountFor(perf) / 100), perf.audience);
        }
        result += String.format("Amount owed is %s\n", usd(data.totalAmount));
        result += String.format("You earned %s credits\n", data.totalVolumeCredits);
        return result;
    }

    public String renderHTML(StatementData data) {
        var result = "<h1>Statement for " + data.customer + "</h1>\n";
        result += "<table>\n";
        result += "<tr><th>play</th><th>seats</th><th>cost</th></tr>";
        for (var perf : data.performances) {
        result += "<tr><td>" + perf.play.name + "</td><td>" + perf.audience + "</td>";
        result += "<td>" + usd(amountFor(perf)) + "</td></tr>\n";
        } 
        result += "</table>\n";
        result += "<p>Amount owed is <em>" + usd(data.totalAmount) + "</em></p>\n";
        result += "<p>You earned <em>" + data.totalVolumeCredits + "</em> credits</p>\n";
        return result;
    }
}