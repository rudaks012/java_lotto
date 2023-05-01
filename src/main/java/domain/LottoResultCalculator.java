package domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResultCalculator {

    private final List<LottoTicket> lottos;
    private final Winner winner;

    public LottoResultCalculator(List<LottoTicket> lottos, Winner winner) {
        this.lottos = lottos;
        this.winner = winner;
    }

    public Map<MatchType, Long> calculate() {
        Map<MatchType, Long> resultMap = new EnumMap<>(MatchType.class);
        for (MatchType matchType : MatchType.values()) {
            resultMap.put(matchType, countMatch(matchType));
        }
        return resultMap;
    }

    private long countMatch(MatchType matchType) {
        return lottos.stream()
                     .mapToInt(ticket -> LottoMatcher.matchCount(ticket, winner.getWinnerTicket()))
                     .filter(matches -> matches == matchType.getMatchingNumbers())
                     .count();
    }
}
