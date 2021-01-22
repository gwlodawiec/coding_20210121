# coding_20210121

Spring Boot project contains three approaches for finding number of occurences of each element in sorted array.

## Algorithms description

[`LinearOccurenciesCounter.java`](src/main/java/com/example/demo/service/LinearOccurenciesCounter.java) (1a - O(n))

Simple algorithm with `O(n)` time complexity. It iterates through each element of an array, counts occurences of each distinct element and store it in map.

[`BetterOccurenciesCounter.java`](src/main/java/com/example/demo/service/BetterOccurenciesCounter.java)

More efficient algorithm, but not better than O(n) in pesimistic case. It not iterates through each element of the array, but 'jumps' from first to last index of each distinct array element.

[`AnotherOccurenciesCounter.java`](src/main/java/com/example/demo/service/AnotherOccurenciesCounter.java)

The most efficient algorithm with `O(log n)` time complexity, but there is one important assumption -> we have constant number of possible chars in array (eg. only letters from alphabet). In this case we loop only through possible chars in an array and use binary search for finding last occurence of each element

## Generating input data

[`StringArrayProvider.java`](/src/main/java/com/example/demo/utils/StringArrayProvider.java) - helper class for generating test String arrays that contains letters from standard alphabet (25 possible letters).
It also provides custom implementation of finding last index of particular element in String array.

## Test coverage

For unit testing the JUnit 5 library was used. In addition to that, I used Jacoco as the code coverage tool. Report from Jacoco can be found under `target/site/jacoco/index.html` file after executing `mvn clean install` maven command on project.

## Running application

To run application just execute following command:

`mvn spring-boot:run`

in the project main directory. You can customize `main` method of [`Coding20210121Application.java`](src/main/java/com/example/demo/Coding20210121Application.java) class to test different approaches and provide different inputs.
