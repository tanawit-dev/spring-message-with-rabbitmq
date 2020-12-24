package com.tanawit.customerservice.entity;

import java.io.Serializable;

import lombok.Data;

/**
 * Package must be the same with Sender project
 * @author GANG-DELL
 *
 */
@Data
public class Customer implements Serializable {

	private Long id;
	private String firstName;
	private String lastName;
	private Integer age;
	private String email;

}
