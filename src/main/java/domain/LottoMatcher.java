package domain;

import java.util.List;

public class LottoMatcher {

    public int getMatchingCount(List<Integer> lastLottoNumbers, List<Integer> currentLottoNumbers) {
        int count = 0;
        for (Integer lastLottoNumber : lastLottoNumbers) {
            if (currentLottoNumbers.contains(lastLottoNumber)) {
                count++;
            }
        }
        return count;
    }
}
