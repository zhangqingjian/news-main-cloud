/**
 * 
 */
package com.yo.news.tcc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
*/
/**
 * @author JAN
 * @CreatedTime：2017年10月19日 下午5:35:52 说明：
 */
public class testLambda
{
	public static void main1(String[] args)
	{
		// filter
		Stream<String> stream1 = Stream.of("ami", "naoki", "akko");
		stream1.filter(s -> s.startsWith("a")).forEach(x -> System.out.print(x + " "));
		System.out.println();

		// distinct
		Stream<String> stream2 = Stream.of("ami", "naoki", "akko", "ami");
		stream2.distinct().forEach(x -> System.out.print(x + " "));
		System.out.println();

		// limit
		IntStream.iterate(1, n -> n + 1).limit(10L).forEach(x -> System.out.print(x + " "));
		System.out.println();

		// skip
		IntStream.rangeClosed(1, 10).skip(5L).forEach(x -> System.out.print(x + " "));
		System.out.println();

		// limit,skip
		IntStream.iterate(1, n -> n + 1).skip(100L).limit(5L).forEach(x -> System.out.print(x + " "));
		System.out.println();

		// limit
		Stream<String> stream = Stream.generate(() -> "Java");
		stream.limit(3L).forEach(x -> System.out.print(x + " "));

		// map sample1
		Stream<String> stream1a = Stream.of("naoki", "akko", "ami");
		Stream<String> stream1b = stream1a.map(s -> s.toUpperCase());
		stream1b.forEach(x -> System.out.print(x + " "));
		System.out.println();

		// map sample2
		Stream<String> stream2s = Stream.of("naoki", "akko", "ami");
		Stream<Integer> stream2i = stream2s.map(s -> s.length());
		stream2i.forEach(x -> System.out.print(x + " "));
		System.out.println();

		// map sample3
		IntStream stream3a = IntStream.of(1, 2, 3);
		IntStream stream3b = stream3a.map(n -> n * 10);
		stream3b.forEach(x -> System.out.print(x + " "));
		System.out.println();

		// map,flatmap
		List<Integer> data1 = Arrays.asList(10);
		List<Integer> data2 = Arrays.asList(20, 30);
		List<Integer> data3 = Arrays.asList(40, 50, 60);
		List<List<Integer>> dataList = Arrays.asList(data1, data2, data3);

		dataList.stream().map(data -> data.stream()).forEach(l -> l.forEach(x -> System.out.print(x + " ")));

		System.out.println();

		dataList.stream().flatMap(data -> data.stream()).forEach(x -> System.out.print(x + " "));
		System.out.println();

		// sorted
		Stream.of("naoki", "akko", "ami").sorted().forEach(x -> System.out.print(x + " "));
		System.out.println();

		Stream.of("naoki", "akko", "ami").sorted(Comparator.reverseOrder()).forEach(x -> System.out.print(x + " "));
		System.out.println();

		// peek
		List<String> list = Stream.of("one", "three", "two", "three", "four").filter(s -> s.length() > 3)
				.peek(e -> System.out.println("after filter:" + e + " ")).distinct().map(String::toUpperCase)
				.peek(e -> System.out.println("after map:" + e + " ")).collect(Collectors.toList());

	}
}
