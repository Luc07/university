package com.facisa.arqi.client;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Client {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id;
	private String name;
}