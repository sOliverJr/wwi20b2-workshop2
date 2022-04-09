package dhbw.fowler2.theatre.kategorien;

import dhbw.fowler2.theatre.Performance;

public class Comedy extends Play
{
    public Comedy(String name)
    {
        super(name);
    }

    public int getAmount(Performance performance) {
        var result = 30000;
        if (performance.audience > 20) {
            result += 10000 + 500 * (performance.audience - 20);
        }
        result += 300 * performance.audience;
        return result;
    }
    
    public int getVolumeCredits(Performance performance) {
        return super.getVolumeCredits(performance) + (int) Math.floor(performance.audience / 5);
    }
}
