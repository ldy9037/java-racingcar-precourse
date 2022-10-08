package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    
    private List<Car> winners;

    Winners(List<Car> winners) {
        this.winners = winners; 
    }

    public List<String> getNames() {
        List<String> result = new ArrayList<>();
        
        for (Car winner : winners) {
            result.add(winner.getName());
        }

        return result;
    }
}
