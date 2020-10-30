package racingcar;

import org.mockito.Mockito;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("RacingGame 클래스 테스")
class RacingGameTest {

    @ParameterizedTest
    @DisplayName("tryNum 보다 많이 play 하면 gameOver 되어야 한다.")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    void checkNotGameOver(int loop) {
        int carNum = 3;
        int tryNum = 5;
        Memento memento = new Memento(carNum, tryNum);
        RacingGame game = new RacingGame(memento);

        RandomGenerator random = Mockito.mock(RandomGenerator.class);
        for (int i = 0; i < loop; i++) {
            game.play(random);
        }

        boolean expectedGameOver = loop < tryNum;
        assertThat(game.checkNotGameOver())
                .isEqualTo(expectedGameOver);
    }
}