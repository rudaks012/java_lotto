package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DefaultLottoGenerator implements LottoGenerator {

    @Override
    public List<Integer> generateLotto() {
        List<Integer> preparedLottoNumbers = new ArrayList<>();

        for (int i = 1; i <= 45; i++) {
            preparedLottoNumbers.add(i);
        }
        Collections.shuffle(preparedLottoNumbers);
        return preparedLottoNumbers.subList(0, 6);
    }
}
