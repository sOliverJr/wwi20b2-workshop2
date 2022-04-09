package dhbw.fowler2.theatre;


import dhbw.fowler2.theatre.kategorien.Play;

public class Performance {

    public Play play;
    public int audience;

    public Performance(Play play, int audience) {
        this.play = play;
        this.audience = audience;
    }
}
