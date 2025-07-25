package domain;

import javax.persistence.Entity;

@Entity
public class CD extends Product {
  private String artist;

  protected CD() {}

  public CD(String artist) {
    this.artist = artist;
  }
}
