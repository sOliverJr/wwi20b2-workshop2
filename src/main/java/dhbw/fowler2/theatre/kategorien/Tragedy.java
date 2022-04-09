package dhbw.fowler2.theatre.kategorien;

import dhbw.fowler2.theatre.Performance;

public class Tragedy extends Play
{
    public Tragedy(String name)
    {
        super(name);
    }

    public int getAmount(Performance performance) {
        var result = 40000;
        if (performance.audience > 30) {
            result += 1000 * (performance.audience - 30);
        }
        return result;
    }
}
