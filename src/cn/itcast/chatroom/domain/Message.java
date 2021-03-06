package cn.itcast.chatroom.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.annotations.Expose;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * DTO类，用来存放聊天的消息
 * @author BoBo
 *
 */
@Document(collection = "message")
public class Message {

	@Id
	private ObjectId id;  //_id

	//发送者
	@Expose
	public String from;//发送者的sessionId
	
	//发送者名称
	@Expose
	public String fromName;  //昵称
	
	//接收者
	@Expose
	public String to;
	
	//发送的文本
	@Expose
	public String text;
	
	//发送日期
	@Expose
	public Date date;
	
	//在线用户列表
	@Expose
	@Transient
	List<User> userList = new ArrayList<User>();
	
	
	public List<User> getUserList() {
		return userList;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getFromName() {
		return fromName;
	}
	public void setFromName(String fromName) {
		this.fromName = fromName;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	@PersistenceConstructor
	public Message(String from, String fromName, String to, String text, Date date) {
		this.from = from;
		this.fromName = fromName;
		this.to = to;
		this.text = text;
		this.date = date;
	}

	public Message() {
	}

	public Message(String from, String fromName, String to, Date date) {
		this.from = from;
		this.fromName = fromName;
		this.to = to;
		this.date = date;
	}
}
