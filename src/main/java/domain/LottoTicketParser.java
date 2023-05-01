package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicketParser {

    public static LottoTicket parse(String input) {
        List<LottoNumber> numbers = Arrays.stream(input.split(","))
                                          .map(String::trim)
                                          .map(Integer::parseInt)
                                          .map(LottoNumber::of)
                                          .collect(Collectors.toList());
        return LottoTicket.of(numbers);
    }

}
