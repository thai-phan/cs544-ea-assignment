package bank.domain;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class TraceRecord {
  @Id
  @GeneratedValue
  private Long id;

  @Temporal(TemporalType.TIMESTAMP)
  private Date date;

  private String result;

  public TraceRecord(Date date, String result) {
    this.date = date;
    this.result = result;

  }

  public TraceRecord() {

  }

  public void setDate(Date date) {
    this.date = date;
  }

  public void setResult(String result) {
    this.result = result;
  }

  public Date getDate() {
    return date;
  }

  public String getResult() {
    return result;
  }
}
