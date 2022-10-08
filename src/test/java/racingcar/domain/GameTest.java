package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    @DisplayName("모든 라운드를 진행됐는지 확인한다")
    void 게임종료_확인() {
        // given 
        RoundCount roundCount = new RoundCount("3");
        Cars cars = Cars.from("test1,test2");
        Game game = new Game(cars, roundCount);

        // when 
        for (int i = 0; i < roundCount.getCount(); i++) {
            game.round();
        }

        // then
        assertThat(game.isOver()).isTrue();
    }
}
