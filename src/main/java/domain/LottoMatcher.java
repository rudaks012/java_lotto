package domain;

public class LottoMatcher {

    public static int matchCount(LottoTicket ticket, LottoTicket winningTicket) {
        return (int) ticket.numbers().stream()
                                   .filter(winningTicket::contains)
                                   .count();
    }
}
