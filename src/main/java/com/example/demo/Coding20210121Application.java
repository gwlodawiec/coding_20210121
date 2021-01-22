package com.example.demo;

import java.time.Duration;
import java.time.Instant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.service.AnotherOccurenciesCounter;
import com.example.demo.service.BetterOccurenciesCounter;
import com.example.demo.service.LinearOccurenciesCounter;
import com.example.demo.service.OccurenciesCounter;
import com.example.demo.utils.StringArrayProvider;

@SpringBootApplication
public class Coding20210121Application {

	public static void main(String[] args) {
		SpringApplication.run(Coding20210121Application.class, args);

		OccurenciesCounter linearCounter = new LinearOccurenciesCounter();
		OccurenciesCounter betterCounter = new BetterOccurenciesCounter();
		OccurenciesCounter anotherCounter = new AnotherOccurenciesCounter();
		String[] input = StringArrayProvider.getSortedArray(100000);
		// String[] input = {"a","b","b","b","b","b","d","h","h","h","p","p"};

		int loops = 100;
		long elapsedTimeLinear = 0L;
		long elapsedTimeBetter = 0L;
		long elapsedTimeAnother = 0L;
		for (int i = 0; i < loops; i++) {
			Instant startLinear = Instant.now();
			linearCounter.count(input);
			Instant afterLinear = Instant.now();
			betterCounter.count(input);
			Instant afterBetter = Instant.now();
			anotherCounter.count(input);
			Instant stop = Instant.now();

			elapsedTimeLinear = elapsedTimeBetter + Duration.between(startLinear, afterLinear).toNanos();
			elapsedTimeBetter = elapsedTimeBetter + Duration.between(afterLinear, afterBetter).toNanos();
			elapsedTimeAnother = elapsedTimeAnother + Duration.between(afterBetter, stop).toNanos();

		}

		System.out.println("Better: " + elapsedTimeBetter / loops + "\n" + "Linear: " + elapsedTimeLinear / loops + "\n"
				+ "Another: " + elapsedTimeAnother / loops);

	}

}
