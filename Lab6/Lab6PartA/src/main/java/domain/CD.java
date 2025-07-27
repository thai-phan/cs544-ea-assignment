package domain;

import jakarta.persistence.*;

@Entity
@NamedQuery(name="CD.findByArtist", query="select mycd from CD mycd where mycd.artist = :artist")
public class CD extends Product{
	private String artist;

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	@Override
	public String toString() {
		return "CD{" +
				"name='" + name + '\'' +
				", description='" + description + '\'' +
				", price=" + price +
				", artist='" + artist + '\'' +
				'}';
	}
}
