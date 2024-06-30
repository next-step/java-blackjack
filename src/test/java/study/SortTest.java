package study;

import org.junit.jupiter.api.Test;

import java.util.List;

public class SortTest {

    @Test
    void sort_test() {
        List<Integer> list = new java.util.ArrayList<>(List.of(4, 3, 5, 1, 2, 9));

        list.sort((a, b) -> b.compareTo(a));

        System.out.println(list);
    }
}
