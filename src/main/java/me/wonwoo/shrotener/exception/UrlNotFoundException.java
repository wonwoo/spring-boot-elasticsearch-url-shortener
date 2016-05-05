package me.wonwoo.shrotener.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by wonwoo on 2016. 5. 5..
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UrlNotFoundException extends RuntimeException {

  private final String url;

  public UrlNotFoundException(String url){
    this.url = url;
  }

  @Override
  public String getMessage() {
    return url + " not found ";
  }
}
