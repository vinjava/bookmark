package com.example.exception;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BookmarkNotFoundException extends RuntimeException {

	public BookmarkNotFoundException(long bookmarkId) {
		super("could not find bookmark '" + bookmarkId + "'.");
	}
}