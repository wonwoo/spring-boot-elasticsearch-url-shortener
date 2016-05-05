package me.wonwoo.utils;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wonwoo on 2016. 5. 4..
 */
public class ShortURLTest {

  @Test
  public void encode() throws Exception {
    String encode = ShortURL.encode(123456789);
    System.out.println(encode);
  }

  @Test
  public void decode() throws Exception {
    int decode = ShortURL.decode("jPTNm");
    System.out.println(decode);
  }
}