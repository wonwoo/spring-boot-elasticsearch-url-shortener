package me.wonwoo.shrotener.domain;

import lombok.Data;

/**
 * Created by wonwoo on 2016. 5. 5..
 */
public class UrlDto {

  @Data
  public static class Request{
    private String url;
  }
}
