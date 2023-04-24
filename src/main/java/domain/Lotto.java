package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    public List<Integer> createLottoNumber() {
        List<Integer> preparedLottoNumbers = new ArrayList<>();

        for (int i = 1; i <= 45; i++) {
            preparedLottoNumbers.add(i);
        }
        Collections.shuffle(preparedLottoNumbers);

        return preparedLottoNumbers.subList(0, 6);
    }

    public List<Number> createLottoNumber2() {
        List<Number> preparedLottoNumbers = new ArrayList<>();

        for (int i = 1; i <= 45; i++) {
            preparedLottoNumbers.add(new Number(i));
        }
        Collections.shuffle(preparedLottoNumbers);

        return List.of(new Number(1), new Number(2), new Number(2), new Number(2), new Number(2),
            new Number(2));
    }
}
