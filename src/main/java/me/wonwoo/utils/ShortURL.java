package me.wonwoo.utils;

/**
 * ShortURL: Bijective conversion between natural numbers (IDs) and short strings
 * <p>
 * ShortURL.encode() takes an ID and turns it into a short string
 * ShortURL.decode() takes a short string and turns it into an ID
 * <p>
 * Features:
 * + large alphabet (51 chars) and thus very short resulting strings
 * + proof against offensive words (removed 'a', 'e', 'i', 'o' and 'u')
 * + unambiguous (removed 'I', 'l', '1', 'O' and '0')
 * <p>
 * Example output:
 * 123456789 <=> pgK8p
 * <p>
 * Source: https://github.com/delight-im/ShortURL (Apache License 2.0)
 */
public class ShortURL {

  public static final String ALPHABET = "23456789bcdfghjkmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ-_";
  public static final int BASE = ALPHABET.length();

  public static String encode(int num) {
    StringBuilder str = new StringBuilder();
    while (num > 0) {
      str.insert(0, ALPHABET.charAt(num % BASE));
      num = num / BASE;
    }
    return str.toString();
  }

  public static int decode(String str) {
    int num = 0;
    for (int i = 0; i < str.length(); i++) {
      num = num * BASE + ALPHABET.indexOf(str.charAt(i));
    }
    return num;
  }
}