package com.voucher.consumer.service.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "consumervouchertable")
public class ResponseModel {

	@Id
	@GeneratedValue
	private int consumerId;
	@Column(name = "consumerName")
	private String consumerName;
	@Column(name = "consumerEmail")
	private String consumerEmail;
	@Column(name = "voucherNumber")
	private int voucherNumber;
	@Column(name = "voucherType")
	private String voucherType;
	@Column(name = "voucherAmount")
	private String voucherAmount;
	@Column(name = "requestedQuantity")
	private String requestedQuantity;
	@Column(name = "voucherId")
	private String voucherId;

	public ResponseModel(int consumerId, String consumerName, String consumerEmail, int voucherNumber,
			String voucherType, String voucherAmount, String requestedQuantity, String voucherId) {
		super();
		this.consumerId = consumerId;
		this.consumerName = consumerName;
		this.consumerEmail = consumerEmail;
		this.voucherNumber = voucherNumber;
		this.voucherType = voucherType;
		this.voucherAmount = voucherAmount;
		this.requestedQuantity = requestedQuantity;
		this.voucherId = voucherId;
	}

	public String getVoucherId() {
		return voucherId;
	}

	public void setVoucherId(String voucherId) {
		this.voucherId = voucherId;
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

	public int getVoucherNumber() {
		return voucherNumber;
	}

	public void setVoucherNumber(int voucherNumber) {
		this.voucherNumber = voucherNumber;
	}

	public String getVoucherType() {
		return voucherType;
	}

	public void setVoucherType(String voucherType) {
		this.voucherType = voucherType;
	}

	public String getVoucherAmount() {
		return voucherAmount;
	}

	public void setVoucherAmount(String voucherAmount) {
		this.voucherAmount = voucherAmount;
	}

	public String getRequestedQuantity() {
		return requestedQuantity;
	}

	public void setRequestedQuantity(String requestedQuantity) {
		this.requestedQuantity = requestedQuantity;
	}

	public ResponseModel() {
		super();
	}

	public ResponseModel(String consumerName, String consumerEmail, int voucherNumber, String voucherType,
			String voucherAmount, String requestedQuantity, String voucherId) {
		super();
		this.consumerName = consumerName;
		this.consumerEmail = consumerEmail;
		this.voucherNumber = voucherNumber;
		this.voucherType = voucherType;
		this.voucherAmount = voucherAmount;
		this.requestedQuantity = requestedQuantity;
		this.voucherId = voucherId;
	}

	@Override
	public String toString() {
		return "ResponseModel [consumerId=" + consumerId + ", consumerName=" + consumerName + ", consumerEmail="
				+ consumerEmail + ", voucherNumber=" + voucherNumber + ", voucherType=" + voucherType
				+ ", voucherAmount=" + voucherAmount + ", requestedQuantity=" + requestedQuantity + ", voucherId="
				+ voucherId + "]";
	}

}
