package com.zorba11.notemaker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class NotemakerApplicationTests {

	Calculator underTest = new Calculator();

	@Test
	void itShouldAddNumbers() {
//		given
		int numberOne = 10;
		int numberTwo = 30;

//		when
		int result = underTest.add(numberOne, numberTwo);

//		then
		int expected = 40;
		assertThat(result).isEqualTo(expected);
	}

	class Calculator {
		int add(int a, int b) {
			return a + b;
		}
	}

}
