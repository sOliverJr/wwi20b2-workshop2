package dhbw.fowler2.theatre.kategorien;

import dhbw.fowler2.theatre.Performance;

public abstract class Play {

    public String name;

    public Play(String name) {
        this.name = name;
    }

    public abstract int getAmount(Performance performance);

    public int getVolumeCredits(Performance performance) {
        return Math.max(performance.audience - 30, 0);
    }
}
