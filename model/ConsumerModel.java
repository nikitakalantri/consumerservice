package com.voucher.consumer.service.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "consumertable")
public class ConsumerModel {
	@Id
	@GeneratedValue
	private int consumerId;
	@Column(name = "consumerName")
	private String consumerName;
	@Column(name = "consumerEmail")
	private String consumerEmail;
	private String voucherId;

	public ConsumerModel() {
		super();
	}

	public ConsumerModel(String consumerName, String consumerEmail, String voucherId) {
		super();
		this.consumerName = consumerName;
		this.consumerEmail = consumerEmail;
		this.voucherId = voucherId;
	}

	public ConsumerModel(int consumerId, String consumerName, String consumerEmail, String voucherId) {
		super();
		this.consumerId = consumerId;
		this.consumerName = consumerName;
		this.consumerEmail = consumerEmail;
		this.voucherId = voucherId;
	}

	@Override
	public String toString() {
		return "ConsumerModel [consumerId=" + consumerId + ", consumerName=" + consumerName + ", consumerEmail="
				+ consumerEmail + ", voucherId=" + voucherId + "]";
	}

	public int getConsumerId() {
		return consumerId;
	}

	public void setConsumerId(int consumerId) {
		this.consumerId = consumerId;
	}

	public String getConsumerName() {
		return consumerName;
	}

	public void setConsumerName(String consumerName) {
		this.consumerName = consumerName;
	}

	public String getConsumerEmail() {
		return consumerEmail;
	}

	public void setConsumerEmail(String consumerEmail) {
		this.consumerEmail = consumerEmail;
	}

	public String getVoucherId() {
		return voucherId;
	}

	public void setVoucherId(String voucherId) {
		this.voucherId = voucherId;
	}

}
