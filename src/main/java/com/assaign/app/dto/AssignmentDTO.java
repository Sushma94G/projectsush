package com.assaign.app.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="assignmentTable")
public class AssignmentDTO implements Serializable{
    @Id
	private int pin;
	private String course;
	private String topic;
	private String description;
	private Date deadLine;
	private String uploadType;
	
	public AssignmentDTO() {
		System.out.println("Created \t"+this.getClass().getSimpleName());
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDeadLine() {
		return deadLine;
	}

	public void setDeadLine(Date deadLine) {
		this.deadLine = deadLine;
	}

	public String getUploadType() {
		return uploadType;
	}

	public void setUploadType(String uploadType) {
		this.uploadType = uploadType;
	}

	@Override
	public String toString() {
		return "AssignmentDTO [pin=" + pin + ", course=" + course + ", topic=" + topic + ", description=" + description
				+ ", deadLine=" + deadLine + ", uploadType=" + uploadType + "]";
	}
	
	
}
