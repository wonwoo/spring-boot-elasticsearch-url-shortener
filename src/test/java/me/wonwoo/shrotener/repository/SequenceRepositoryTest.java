package me.wonwoo.shrotener.repository;

import me.wonwoo.shrotener.domain.Sequence;
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
public class SequenceRepositoryTest {

  @Autowired
  private SequenceRepository sequenceRepository;

  @Test
  public void saveTest(){
    Sequence sequence = new Sequence();
    sequence.setId("urlShort");
    sequence.setSequence(1L);
    sequenceRepository.save(sequence);
  }

  @Test
  public void findAndUpdateTest(){
    Sequence urlShort = sequenceRepository.findOne("urlShort");
    urlShort.setSequence(urlShort.getSequence() + 1);
    sequenceRepository.save(urlShort);
    System.out.println(urlShort);
  }
}