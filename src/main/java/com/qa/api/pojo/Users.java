package com.qa.api.pojo;

public class Users {
	
private String name;
private String job;
private String id;

public Users() {

}

public Users(String name, String job, String id) {
	this.name = name;
	this.job = job;
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getJob() {
	return job;
}
public void setJob(String job) {
	this.job = job;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
@Override
public String toString() {
	return "[name=" + name + ", job=" + job + ", id=" + id + "]";
}

}
