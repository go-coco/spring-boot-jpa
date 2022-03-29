package com.see0gan.space.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.see0gan.booking.entity.Booking;
import com.see0gan.user.auth.ApplicationUser;

import lombok.Data;

@Entity
public class Guest extends ApplicationUser{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2538016136468788873L;

	@OneToMany(mappedBy = "user")
	private Set<Booking> booking;
	
	public Guest(long id, String name) {
		super();
	}
}
