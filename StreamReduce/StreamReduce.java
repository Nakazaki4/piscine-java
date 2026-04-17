
import java.util.stream.Stream;

public class StreamReduce {

    public static Integer sumAll(Stream<Integer> s) {
        s.reduce(0, (prev, curr) -> prev + curr);
    }

    public static Integer divideAndAddElements(Stream<Integer> s, int divider) {
        s.map(n -> n / divider).reduce(0, (prev, curr) -> prev + curr);
    }
}
