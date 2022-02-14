package rentcar.domain;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RentCarTest {


    @DisplayName("자동차_타입_생성_테스트")
    @Test
    void createRentCarTest() {
        List<String> rentCar = Arrays.asList("Sonata", "K5", "Sonata", "Avante", "K5");
        List<Integer> distance = Arrays.asList(150, 260, 120, 300, 390);

        IntStream.range(0, 5)
            .forEach(idx ->
                assertThat(RentCar.of(rentCar.get(idx), distance.get(idx)).getName()).isEqualTo(
                    rentCar.get(idx))
            );
    }
}