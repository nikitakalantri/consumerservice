CREATE TABLE consumervouchertable (
		consumerId Integer primary key,
		consumerName varchar(30),
		consumerEmail varchar(30),
		voucherNumber Integer,
		voucherType varchar(30),
		voucherAmount varchar(30),
		requestedQuantity varchar(50)
	);