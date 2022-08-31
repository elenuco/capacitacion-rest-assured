package org.example.clase_4.modelos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestPost{

	@JsonProperty("title")
	private String title;

	@JsonProperty("body")
	private String body;

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setBody(String body){
		this.body = body;
	}

	public String getBody(){
		return body;
	}

	@Override
 	public String toString(){
		return 
			"RequestPost{" + 
			"title = '" + title + '\'' + 
			",body = '" + body + '\'' + 
			"}";
		}
}