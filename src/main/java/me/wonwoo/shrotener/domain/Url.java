package me.wonwoo.shrotener.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * Created by wonwoo on 2016. 5. 5..
 */
@Document(indexName = "shortener", type = "urls", shards = 1, replicas = 0, refreshInterval = "-1")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Url {

  @Id
  private String id;

  private String url;
}
