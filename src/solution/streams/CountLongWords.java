package solution.streams;


import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2023/05/13/21:55
 * @Description:
 */
public class CountLongWords {
    public static void main(String[] args) throws IOException {
        var contents = new String(Files.readAllBytes(Paths.get("F:/codes/abc.txt")), StandardCharsets.UTF_8);
        System.out.println(contents);
        List<String> words = List.of(contents.split("\\PL+"));// 以非字母分割，这样分割出来就是一个个单词
        long count = 0;
        for (String word : words) {
            if (word.length() > 8) count++;
        }
        System.out.println(count);
        // 用流的方式来统计
        count = words.stream().filter(word -> word.length() > 8).count();
        System.out.println(count);
        // 以并行流的方式来统计
        count = words.parallelStream().filter(word -> word.length() > 8).count();
        System.out.println(count);
        // stream是一个String[]array
        Stream<String> stream = Stream.of(contents.split("\\PL+"));
        System.out.println(Arrays.toString(stream.toArray()));
        Stream<String> song = Stream.of("gently", "down", "the", "stream");
        System.out.println(Arrays.toString(song.toArray()));
        Stream<String> silence = Stream.empty();
        System.out.println(Arrays.toString(silence.toArray()));
        Stream<String> echos = Stream.generate(() -> "Echo");
        // 报了OutOfMemory的错误，因为generate方法得到的是无限流
        // System.out.println(Arrays.toString(echos.toArray()));
        Stream<Double> randoms = Stream.generate(Math::random);
        // 报了OutOfMemory的错误，因为generate方法得到的是无限流
        // System.out.println(Arrays.toString(randoms.toArray()));
        // 也是无限流
        Stream<BigInteger> integers = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE));
        // 有限流
        var limit = new BigInteger("1000000");
        Stream<BigInteger> integerStream = Stream.iterate(BigInteger.ZERO, n -> n.compareTo(limit) < 0, n -> n.add(BigInteger.ONE));
        System.out.println(integerStream.toArray().length);

    }
}
