package com.see0gan.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
class MyProjectUsingMysqlApplicationTests {

	@Test
	void itShouldAddNumbers() {
		
		Calculator underTest = new Calculator();
		
		// given
		int numberOne = 10;
		int numberTow = 20;
		
		//when
		int result = underTest.add(numberOne, numberTow);
		
		// then
		assertThat(result).isEqualTo(130);
	}
	
	class Calculator {
		int add(int a, int b) {
			return a+b;
		}
	}

}
