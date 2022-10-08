package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameTest {

    private Game game = null;
    private RoundCount roundCount = null;

    @BeforeEach
    void setUp() {
        Cars cars = Cars.from("test1,test2");
        roundCount = new RoundCount("3");
        game = new Game(cars, roundCount);
    }

    @Test
    @DisplayName("모든 라운드를 진행됐는지 확인한다.")
    void 게임종료_확인() {
        // when 
        for (int i = 0; i < roundCount.getCount(); i++) {
            game.round();
        }

        // then
        assertThat(game.isOver()).isTrue();
    }

    @Test
    @DisplayName("모든 라운드가 진행된 상태에서 라운드 진행시 예외가 발생한다.")
    void 게임종료상태에서_라운드진행시_예외발생(){
        // given
        for (int i = 0; i < roundCount.getCount(); i++) {
            game.round();
        }

        // when & then
        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> game.round())
                .withMessageContaining("[ERROR]")
                .withMessage(ErrorMessage.START_ROUND_WHEN_GAME_OVER_ERROR.getMessage());
    }
}
