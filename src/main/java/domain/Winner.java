package domain;

public class Winner {
    private final LottoTicket winningTicket;

    public Winner(LottoTicket winningTicket) {
        this.winningTicket = winningTicket;
    }

    public LottoTicket getWinnerTicket() {
        return winningTicket;
    }
}
