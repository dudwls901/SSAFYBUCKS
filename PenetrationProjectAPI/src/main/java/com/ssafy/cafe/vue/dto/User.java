package com.ssafy.cafe.vue.dto;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.type.Alias;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Alias("UserVue")
@ApiModel(value = "User : 유저 정보", description = "유저 상세 정보")
public class User {
	@ApiModelProperty(value="아이디")
    private String id;
	@ApiModelProperty(value="이름")
    private String name;
	@ApiModelProperty(value="암호")
    private String pass;
	@ApiModelProperty(value="스탬프")
    private Integer stamps;
    private List<Stamp> stampList = new ArrayList<>();

    public User(String id, String name, String pass, Integer stamps) {
        this.id = id;
        this.name = name;
        this.pass = pass;
        this.stamps = stamps;
    }
    
    public User() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Integer getStamps() {
		return stamps;
	}

	public void setStamps(Integer stamps) {
		this.stamps = stamps;
	}

	public List<Stamp> getStampList() {
		return stampList;
	}

	public void setStampList(List<Stamp> stampList) {
		this.stampList = stampList;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", pass=" + pass + ", stamps=" + stamps + ", stampList="
				+ stampList + "]";
	}
    
    
    
}
