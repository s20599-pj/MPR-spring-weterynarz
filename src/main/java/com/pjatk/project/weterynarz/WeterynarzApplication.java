package com.pjatk.project.weterynarz;

import com.pjatk.project.weterynarz.repository.PracownikRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = PracownikRepository.class)
public class WeterynarzApplication{

	public static void main(String[] args) {
		SpringApplication.run(WeterynarzApplication.class, args);
	}

}
