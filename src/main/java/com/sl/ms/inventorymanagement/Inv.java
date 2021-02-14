package com.sl.ms.inventorymanagement;

import java.util.Date;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.lang.NonNull;


@Entity
public class Inv {

	@Id
	private int id;
	private Date date;
	@NonNull
	@Column(columnDefinition = "JSON")
	@Convert(converter = StringMapConverter.class)
	private Map<String, String> file;

	
	public Map<String, String> getFile() {
		return file;
	}

	public void setFile(Map<String, String> file) {
		this.file = file;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
