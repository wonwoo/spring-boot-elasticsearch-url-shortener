package me.wonwoo.shrotener.repository;

import me.wonwoo.shrotener.domain.Sequence;
import me.wonwoo.shrotener.domain.Url;
import me.wonwoo.utils.ShortURL;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by wonwoo on 2016. 5. 5..
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class UrlRepositoryTest {

  @Autowired
  private UrlRepository urlRepository;

  @Test
  public void urlTest(){
    Long seq = 2L;
    String encode = ShortURL.encode(seq.intValue());
    Url url = new Url();
    url.setId(encode);
    url.setUrl("http://wonwoo.ml");
    urlRepository.save(url);
  }
}