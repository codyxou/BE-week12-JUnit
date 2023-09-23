package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.assertj.core.util.VisibleForTesting;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoJUnitTest {

	private TestDemo testDemo;

	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) { 
		if (!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
		}

	}
	
	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly () {
		assertThat(testDemo.addPositive(4,5)).isEqualTo(9);

		assertThat(testDemo.addPositive(40,50)).isEqualTo(90);
		assertThat(testDemo.addPositive(1,2)).isEqualTo(3);
		assertThat(testDemo.addPositive(35,25)).isEqualTo(60);
	}
	
	@Test
	void assertThatPairsOfMultipliedNumbersAreUnderFiveHundred () {
		//will pass
		assertThat(testDemo.multiplyWithLimit(50, 5)).isEqualTo(250);
		assertThat(testDemo.multiplyWithLimit(-20, 3)).isEqualTo(-60);
		//will throw exception since it's expected to equal 500 and we want the product under.
		assertThat(testDemo.multiplyWithLimit(50, 5)).isEqualTo(250);

	}
	
	//mocked method
	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		
		doReturn(5).when(mockDemo).getRandomInt();
		int fiveSquared = mockDemo.randomNumberSquared();
		assertThat(fiveSquared).isEqualTo(25);
	}

	static Stream<Arguments> argumentsForAddPositive() {
		//@formatter:off
		return Stream.of(
				Arguments.of(2,4,6, false),
				Arguments.of(3,5,8, false),
				Arguments.of(5,4,9, false),
				Arguments.of(0,0,0, true)
				);
		//@formatter:on
	}

}
