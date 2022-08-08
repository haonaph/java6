package com.poly.store.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="authorities", uniqueConstraints = {
		@UniqueConstraint
		(columnNames = {"username", "role"})})
public class authority  implements Serializable{
	@Id
	Integer id;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="username")
	private account accounts;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="role")
	private role role;

}
