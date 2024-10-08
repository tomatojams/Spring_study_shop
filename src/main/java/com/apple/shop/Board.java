package com.apple.shop;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;
import lombok.ToString;

/**
 * Created by tomatojams on 24. 8. 14.
 */
@Entity
@ToString
public class Board {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long id;

  @Column(columnDefinition = "TEXT")
  public String title;

  public Date date;

}