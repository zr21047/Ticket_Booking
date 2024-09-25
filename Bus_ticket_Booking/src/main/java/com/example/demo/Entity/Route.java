package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Route {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @NotNull
	    private String from;
	    
	    @NotNull
	    private String to;
	    
	    private int visibility;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getFrom() {
			return from;
		}

		public void setFrom(String from) {
			this.from = from;
		}

		public String getTo() {
			return to;
		}

		public void setTo(String to) {
			this.to = to;
		}
		
		public int getVisibility() {
			return visibility;
		}

		public void setVisibility(int visibility) {
			this.visibility = visibility;
		}

		public Route(Long id, @NotNull String from, @NotNull String to) {
			super();
			this.id = id;
			this.from = from;
			this.to = to;
		}
	    
	    

}
