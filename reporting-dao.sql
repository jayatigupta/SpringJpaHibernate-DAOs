CREATE TABLE advertiser (
  li_id int NOT NULL UNIQUE,
  li_name varchar(255) DEFAULT NULL,
  advertiser_id int DEFAULT NULL,
  advertiser_name varchar(255) DEFAULT NULL,
  currency_id int DEFAULT NULL,
  end_time int DEFAULT NULL,
  io_currency_id int DEFAULT NULL,
  io_id int DEFAULT NULL,
  io_name varchar(255) DEFAULT NULL,
  io_region_id int DEFAULT NULL,
  li_budget varchar(255) DEFAULT NULL,
  licensee_id int DEFAULT NULL,
  pricing_type int DEFAULT NULL,
  start_time int DEFAULT NULL
);

CREATE TABLE creative (
  cr_id int NOT NULL UNIQUE,
  width int DEFAULT NULL,
  height int DEFAULT NULL,
  is_popup varchar(255) DEFAULT NULL,
  name varchar(255) DEFAULT NULL,
  type varchar(255) DEFAULT NULL,
  url varchar(255) DEFAULT NULL
);

CREATE TABLE pixel (
  px_id int NOT NULL UNIQUE,
  count int DEFAULT NULL,
  is_piggyback varchar(255) NOT NULL,
  max_time int DEFAULT NULL,
  times_fired int DEFAULT NULL,
  type int NOT NULL
);

CREATE TABLE publisher (
  li_id int NOT NULL UNIQUE,
  li_name varchar(255) DEFAULT NULL,
  io_id int DEFAULT NULL,
  io_name varchar(255) DEFAULT NULL,
  licensee_id int DEFAULT NULL,
  pricing_type int DEFAULT NULL,
  publisher_id int DEFAULT NULL,
  publisher_name varchar(255) DEFAULT NULL
);

CREATE TABLE segment (
  seg_id int NOT NULL UNIQUE,
  name varchar(255) NOT NULL
);

