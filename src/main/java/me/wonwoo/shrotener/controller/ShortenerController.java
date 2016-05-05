package me.wonwoo.shrotener.controller;

import me.wonwoo.shrotener.domain.Sequence;
import me.wonwoo.shrotener.domain.Url;
import me.wonwoo.shrotener.domain.UrlDto;
import me.wonwoo.shrotener.exception.UrlNotFoundException;
import me.wonwoo.shrotener.repository.SequenceRepository;
import me.wonwoo.shrotener.repository.UrlRepository;
import me.wonwoo.utils.ShortURL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by wonwoo on 2016. 5. 5..
 */

@Controller
public class ShortenerController {

  @Autowired
  private SequenceRepository sequenceRepository;

  @Autowired
  private UrlRepository urlRepository;

  @PostMapping("/url")
  @ResponseBody
  public Url save(@RequestBody Url url) {
    Sequence urlShort = sequenceRepository.findOne("urlShort");
    urlShort.setSequence(urlShort.getSequence() + 1);
    sequenceRepository.save(urlShort);
    Long seq = urlShort.getSequence();
    String encode = ShortURL.encode(seq.intValue());
    url.setId(encode);
    return urlRepository.save(url);
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.MOVED_PERMANENTLY)
  public String get(@PathVariable String id){
    Url url = urlRepository.findOne(id);
    if(url == null){
      throw new UrlNotFoundException(id);
    }
    return "redirect:" + url.getUrl();
  }

  @GetMapping("/")
  public String url(){
    return "index";
  }
}
