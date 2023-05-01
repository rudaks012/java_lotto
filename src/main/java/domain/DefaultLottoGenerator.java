package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DefaultLottoGenerator implements LottoGenerator {

    @Override
    public LottoTicket generateLottoTicket() {
        List<LottoNumber> preparedLottoNumbers = prepareLottoNumbers();
        Collections.shuffle(preparedLottoNumbers);
        return LottoTicket.of(preparedLottoNumbers.subList(0, 6));
    }

    private List<LottoNumber> prepareLottoNumbers() {
        return IntStream.rangeClosed(1, 45)
                        .mapToObj(LottoNumber::of)
                        .collect(Collectors.toList());
    }
}
