package com.hotelreserve;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hotelreserve.mapper")
public class HotelreserveApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelreserveApplication.class, args);
	}
}
