package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private List<Number> lottoNumbers;

    public Lotto() {
        this.lottoNumbers = createLottoNumber();
    }

    private List<Number> createLottoNumber() {
        List<Number> preparedLottoNumbers = new ArrayList<>();

        for (int i = 1; i <= 45; i++) {
            preparedLottoNumbers.add(new Number(i));
        }
        Collections.shuffle(preparedLottoNumbers);

        return preparedLottoNumbers.subList(0, 6);
    }

    public int size() {
        return lottoNumbers.size();
    }
}
