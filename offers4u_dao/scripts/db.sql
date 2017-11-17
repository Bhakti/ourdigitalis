drop table customer;

CREATE TABLE customer
(
   customer_id varchar(9) PRIMARY KEY NOT NULL,
   first_name varchar(20) NOT NULL,
   middle_name varchar(20) NOT NULL,
   DOB date NOT NULL,
   gender varchar(1) NOT NULL,
   house_no_name_street varchar(100),
   city varchar(100),
   state varchar(100),
   country varchar(100),
   pincode varchar(8),
   email_id varchar(100) NOT NULL,
   phone_number varchar(15),
   occupation varchar(100),
   income varchar(13),
   credit_card varchar(13)
);


DROP table if exists category;
CREATE TABLE category (
   category_id varchar(9) PRIMARY KEY NOT NULL,
   category_name varchar(50) NOT NULL
);

DROP table if exists segment;
CREATE TABLE segment(
   segment_id varchar(9) PRIMARY KEY NOT NULL,
   segment_name varchar(50) NOT NULL
);

DROP table if exists category_segment;
CREATE TABLE category_segment(
   segment_id varchar(9) NOT NULL,
   category_id varchar(9) NOT NULL
);


drop table if exists customer_preferences;
CREATE TABLE customer_preferences
(
   customer_id varchar(9) NOT NULL,
   category_id varchar(9) NOT NULL
);

drop table if exists customer_segment;
CREATE TABLE customer_segment
(
   customer_id varchar(9) NOT NULL,
   segment_id varchar(9) NOT NULL
);


drop table if exists merchant;
CREATE TABLE merchant(
	merchant_id varchar(9) PRIMARY KEY NOT NULL,
	name varchar(100) NOT NULL,
	image varchar(256)
);

drop table if exists offers;
CREATE TABLE offers(
	offer_id varchar(9) PRIMARY KEY NOT NULL,
	title varchar(100) NOT NULL,
	image varchar(256),
	image_desc varchar(256),
	description varchar(100),
	details varchar(500),
	t_and_c varchar(500),
	start_date DATETIME NOT NULL,
	end_date DATETIME NOT NULL,
	merchant_id varchar(9) NOT NULL,
	category_id varchar(9) NOT NULL,
	promo_type varchar(25) NOT NULL,
	promo_text varchar(25) NOT NULL,
	reward varchar(50) NOT NULL,
	subscription decimal(10,2) NOT NULL
);

drop table if exists customer_offers;

create table customer_offers (
	id varchar(9) PRIMARY KEY NOT NULL,
	offer_id varchar(9) NOT NULL,
	customer_id varchar(9) NOT NULL,
	roll_out_date date NOT NULL,
	feedback varchar(100),
	rating varchar(1) NOT NULL,
	result varchar(9) NOT NULL
);

ALTER TABLE offers ADD CONSTRAINT FK_OFFERS_MERCHANT FOREIGN KEY ( merchant_id ) REFERENCES merchant ( merchant_id );
CREATE   INDEX FK_OFFERS_MERCHANT_IDX ON offers ( merchant_id );

ALTER TABLE offers ADD CONSTRAINT FK_OFFERS_CATEGORY FOREIGN KEY ( category_id ) REFERENCES category ( category_id );
CREATE   INDEX FK_OFFERS_CATEGORY_IDX ON offers ( category_id );


ALTER TABLE customer_segment ADD CONSTRAINT FK_CS_CUSTOMER FOREIGN KEY ( customer_id ) REFERENCES customer ( customer_id );
CREATE   INDEX FK_CS_CUSTOMER_IDX ON customer_segment ( customer_id );


ALTER TABLE customer_segment ADD CONSTRAINT FK_CS_SEGMENT FOREIGN KEY ( segment_id ) REFERENCES segment ( segment_id );
CREATE   INDEX FK_CS_SEGMENT_IDX ON customer_segment ( segment_id );

ALTER TABLE customer_segment ADD CONSTRAINT PK_CUSTOMER_SEGMENT PRIMARY KEY (customer_id, segment_id);

ALTER TABLE customer_preferences ADD CONSTRAINT FK_CP_CATEGORY FOREIGN KEY ( category_id ) REFERENCES category ( category_id );
CREATE   INDEX FK_CP_CATEGORY_IDX ON customer_preferences ( category_id );

ALTER TABLE customer_preferences ADD CONSTRAINT FK_CP_CUSTOMER FOREIGN KEY ( customer_id ) REFERENCES customer ( customer_id );
CREATE   INDEX FK_CP_CUSTOMER_IDX ON customer_preferences ( customer_id );

ALTER TABLE customer_preferences ADD CONSTRAINT PK_CUSTOMER_PREFERENCES PRIMARY KEY (customer_id, category_id);


ALTER TABLE customer_offers ADD CONSTRAINT FK_CO_OFFERS FOREIGN KEY ( offer_id ) REFERENCES offers ( offer_id );

CREATE   INDEX FK_CO_OFFERS_IDX ON customer_offers ( offer_id );


ALTER TABLE customer_offers ADD CONSTRAINT FK_CO_CUSTOMER FOREIGN KEY ( customer_id ) REFERENCES customer ( customer_id );

CREATE INDEX FK_CO_CUSTOMER_IDX ON customer_offers ( customer_id );

ALTER TABLE category_segment ADD CONSTRAINT PK_CATEGORY_SEGMENT PRIMARY KEY (segment_id, category_id);

ALTER TABLE category_segment ADD CONSTRAINT FK_CATS_CATEGORY FOREIGN KEY ( category_id ) REFERENCES category ( category_id );

CREATE   INDEX FK_CATS_CATEGORY_IDX ON category_segment ( category_id );

ALTER TABLE category_segment ADD CONSTRAINT FK_CATS_SEGMENT FOREIGN KEY ( segment_id ) REFERENCES segment ( segment_id );

CREATE   INDEX FK_CATS_SEGMENT_IDX ON category_segment ( segment_id );


           