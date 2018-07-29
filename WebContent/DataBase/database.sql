create database db_shop;
use db_shop;

create table tb_user(
	id int(10) not null primary key auto_increment comment '主键',
	username varchar(50) not null comment '用户名',
	password varchar(50) not null comment '密码'
);

create table tb_orderitem(
	id int(10) not null primary key auto_increment,
	productId int(10) not null comment '商品ID',
	productName varchar(100) not null comment '商品名称',
	productPrice float not null comment '商品价格',
	amount int(10) not null comment '商品数量',
	orderId varchar(30) not null comment '订单ID'
);

create table tb_productinfo(
	id int(10) not null primary key auto_increment,
	name varchar(100) not null comment '商品名称',
	description TEXT comment '商品描述',
	createTime dateTime comment '创建时间',
	basePrice float comment '采购价格',
	marketprice float comment '市场价格',
	sellprice float comment '销售价格',
	clickcount int(11) comment '浏览量',
	sellCount int(11) comment '销售量'
);

create table tb_order(
	id int(10) not null primary key auto_increment,
	name varchar(50) not null comment '订单名称',
	address varchar(200) not null comment '送货地址',
	mobile varchar(20) not null comment '电话',
	totalprice float comment '采购价格',
	createtime datetime comment '创建时间',
	paymentway varchar(20) comment '支付方式',
	orderstate varchar(16) comment '订单状态',
	customeid int(10) not null comment '会员ID'
);

create table tb_customer(
	id int(10) not null primary key auto_increment,
	username varchar(50) not null comment '会员名称',
	password varchar(50) not null comment '密码',
	address varchar(200) comment '收货地址',
	mobile varchar(20) comment '电话号码'
);
