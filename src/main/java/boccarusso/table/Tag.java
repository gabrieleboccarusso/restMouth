package boccarusso.table;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Tag {
	private @Id @GeneratedValue Long id;
	private String name;
  
	Tag () {}
	  
	public Tag (String name) {
		this.setName(name);
	}
	
	public Long getId() {
		return id;
	}
	  
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return this.name + "\n";
	}
}