package com.example.demo;
import com.example.model.Account;
import com.example.model.Bookmark;
import com.example.repo.AccountRepository;
import com.example.repo.BookmarkRepository;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.demo","com.example.model","com.example.controller", "com.example.repo"
})
@EntityScan("com.example.model")
@EnableJpaRepositories("com.example.repo")
public class BookmarksApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookmarksApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(AccountRepository accountRepository,
						   BookmarkRepository bookmarkRepository) {
		return args ->
			Arrays.asList("jhoeller","dsyer","pwebb","ogierke","rwinch","mfisher","mpollack","jlong")
				.forEach(username -> {
					Account account = accountRepository.save(new Account(username, "password"));
					bookmarkRepository.save(new Bookmark(account, "http://bookmark.com/1/" + username, "A description"));
					bookmarkRepository.save(new Bookmark(account, "http://bookmark.com/2/" + username, "A description"));
				});
	}

}

