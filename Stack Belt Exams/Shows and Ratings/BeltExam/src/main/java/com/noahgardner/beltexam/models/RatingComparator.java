package com.noahgardner.beltexam.models;

public class RatingComparator implements java.util.Comparator<Rating>{
	@Override
	public int compare(Rating a, Rating b) {
		return (a.getRating() - b.getRating());
	}
	
	public RatingComparator() {}
}
