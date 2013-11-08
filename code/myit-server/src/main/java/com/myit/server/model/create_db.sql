drop table if exists T_BUSINESS_BUSINESSIFO;

drop table if exists T_BUSINESS_COMMOIFO;

drop table if exists T_BUSINESS_SHIPPING;

drop table if exists T_COMM_CODEGEN;

drop table if exists T_COMM_LOCATION;

drop table if exists T_MEMBER_MEMBERINFO;

drop table if exists T_ORDER_COMMO;

drop table if exists T_ORDER_ORDERINFO;

drop table if exists T_ORDER_SHOPPINGCART;

drop table if exists T_SYS_OPLOG;

drop table if exists T_SYS_USER;

/*==============================================================*/
/* Table: T_BUSINESS_BUSINESSIFO                                */
/*==============================================================*/
create table T_BUSINESS_BUSINESSIFO
(
   ID                   bigint not null auto_increment comment '主键',
   BUSINESS_NO          varchar(20) not null comment '商户号',
   REAL_NAME            varchar(50) not null comment '商户名称',
   CREATE_TIME          datetime not null comment '注册时间',
   LAST_MODIFIED        datetime comment '上次更新时间',
   PROVIENCE_ID         numeric(8,0) not null comment '省份',
   CITY_ID              numeric(8,0) not null comment '城市',
   COUNTY_ID            numeric(8,0) not null comment '区县',
   ADDRESS              varchar(255) comment '地址',
   STATU                varchar(2) not null default '-1' comment '状态：-1-禁用，0-启用',
   primary key (ID)
);

/*==============================================================*/
/* Table: T_BUSINESS_COMMOIFO                                   */
/*==============================================================*/
create table T_BUSINESS_COMMOIFO
(
   ID                   bigint not null auto_increment comment '主键',
   COMMO_NO             varchar(20) not null comment '商品编号',
   COMMO_NAME           varchar(50) not null comment '商户名称',
   BUSINESS_ID          numeric(8,0) not null comment '商户ID',
   COMMO_DESCRIBE       varchar(255) not null comment '商品描述',
   CREATE_TIME          datetime not null comment '注册时间',
   LAST_MODIFIED        datetime comment '上次更新时间',
   STATU                varchar(2) not null default '-1' comment '状态：-1-禁用，0-启用',
   SETTLE_PRICE         decimal(8,4) not null comment '进价',
   SELL_PRICE           decimal(8,4) not null comment '售价',
   primary key (ID)
);

/*==============================================================*/
/* Table: T_BUSINESS_SHIPPING                                   */
/*==============================================================*/
create table T_BUSINESS_SHIPPING
(
   ID                   bigint not null auto_increment comment '主键',
   BUSINESS_ID          numeric(8,0) not null comment '商户ID',
   LOCATION_ID          numeric(8,0) not null comment '位置ID',
   ADDRESS              varchar(255) comment '地址',
   CREATE_TIME          datetime not null comment '创建时间',
   LAST_MODIFIED        datetime comment '上次更新时间',
   STATU                varchar(2) not null default '-1' comment '状态：-1-禁用，0-启用',
   primary key (ID)
);

/*==============================================================*/
/* Table: T_COMM_CODEGEN                                        */
/*==============================================================*/
create table T_COMM_CODEGEN
(
   ID                   bigint not null auto_increment comment '主键',
   CODE_TYPE            varchar(50) not null comment '编码类型',
   GEN_TPL              varchar(50) not null comment '规则模板',
   CUR_VALUE            bigint not null default 0 comment '当前流水号值',
   CODE_DESCRIBE        varchar(255) not null comment '编码描述',
   CREATE_TIME          datetime not null comment '创建时间',
   LAST_MODIFIED        datetime comment '上次更新时间',
   STATU                varchar(2) not null default '-1' comment '状态：-1-禁用，0-启用',
   primary key (ID)
);

/*==============================================================*/
/* Table: T_COMM_LOCATION                                       */
/*==============================================================*/
create table T_COMM_LOCATION
(
   ID                   bigint not null auto_increment comment '主键',
   PROV_ID              bigint not null comment '省份ID',
   PROV_NAME            varchar(50) not null comment '省份名称',
   CITY_ID              bigint not null comment '城市ID',
   CITY_NAME            varchar(50) not null comment '城市名称',
   COUNTY_ID            bigint not null comment '区县ID',
   COUNTY_NAME          varchar(50) not null comment '区县名称',
   CREATE_TIME          datetime not null comment '创建时间',
   LAST_MODIFIED        datetime comment '上次更新时间',
   STATU                varchar(2) not null default '-1' comment '状态：-1-禁用，0-启用',
   primary key (ID)
);

/*==============================================================*/
/* Table: T_MEMBER_MEMBERINFO                                   */
/*==============================================================*/
create table T_MEMBER_MEMBERINFO
(
   ID                   bigint not null auto_increment comment '主键',
   MEMBER_NO            varchar(20) not null comment '会员号',
   PASSWORD             varchar(50) not null comment '密码',
   REAL_NAME            varchar(50) comment '姓名',
   SEX                  varchar(1) default '1' comment '性别：0-女，1-男',
   BIRTHDAY             date comment '生日',
   MOBILE               varchar(20) not null comment '手机',
   EMAIL                varchar(50),
   LAST_LOGIN_TIME      datetime comment '上次登录时间',
   LAST_LOGIN_IP        varchar(20) comment '上次登录ip',
   CREATE_TIME          datetime not null comment '注册时间',
   LAST_MODIFIED        datetime comment '上次更新时间',
   PROVINCE_ID         bigint comment '省份',
   CITY_ID              bigint comment '城市',
   COUNTY_ID            bigint comment '区县',
   ADDRESS              varchar(256) comment '地址',
   STATU                varchar(2) not null default '-1' comment '状态：-1-禁用，0-启用',
   primary key (ID)
);

/*==============================================================*/
/* Table: T_ORDER_COMMO                                         */
/*==============================================================*/
create table T_ORDER_COMMO
(
   ID                   bigint not null auto_increment comment '主键',
   ORDER_ID             bigint not null comment '订单ID',
   COMMO_ID             bigint not null comment '商品ID',
   COMMO_NAME           varchar(50) not null comment '商品名称',
   SETTLE_PRICE         decimal(8,4) not null comment '结算价',
   SELL_PRICE           decimal(8,4) not null comment '售价',
   COMMO_AMOUNT         int not null default 1 comment '商品数量',
   CREATE_TIME          datetime not null comment '创建时间',
   LAST_MODIFIED        datetime comment '上次更新时间',
   STATU                varchar(2) not null default '-1' comment '状态：-1-禁用，0-启用',
   primary key (ID)
);

/*==============================================================*/
/* Table: T_ORDER_ORDERINFO                                     */
/*==============================================================*/
create table T_ORDER_ORDERINFO
(
   ID                   bigint not null auto_increment comment '主键',
   MEMBER_ID            bigint not null comment '会员ID',
   ORDER_NO             varchar(20) not null comment '订单编号',
   CONTACT_NAME         varchar(50) not null comment '姓名',
   MOBILE            varchar(20) not null comment '手机',
   EMAIL                varchar(50) comment 'EMAIL',
   CREATE_TIME          datetime not null comment '下单时间',
   LAST_MODIFIED        datetime comment '上次更新时间',
   PROVINCE_ID         bigint not null comment '省份',
   CITY_ID              bigint not null comment '城市',
   COUNTY_ID            bigint not null comment '区县',
   ADDRESS              varchar(255) not null comment '地址',
   SELL_AMOUNT          decimal(8,4) not null comment '订单金额',
   SETTLE_AMOUNT        decimal(8,4) comment '结算金额',
   STATU                varchar(2) not null default '-1' comment '状态：-1-作废，0-保存待支付，1-支付待确认，2-确认待发货，3-发货带签收，4-签收',
   primary key (ID)
);

/*==============================================================*/
/* Table: T_ORDER_SHOPPINGCART                                  */
/*==============================================================*/
create table T_ORDER_SHOPPINGCART
(
   ID                   bigint not null auto_increment comment '主键',
   MEMBER_ID            bigint not null comment '订单ID',
   COMMO_ID             bigint not null comment '商品ID',
   COMMO_NAME           varchar(50) not null comment '商品名称',
   SETTLE_PRICE         decimal(8,4) not null comment '结算价',
   SELL_PRICE           decimal(8,4) not null comment '售价',
   COMMO_AMOUNT         int not null default 1 comment '商品数量',
   CREATE_TIME          datetime not null comment '创建时间',
   LAST_MODIFIED        datetime comment '上次更新时间',
   STATU                varchar(2) not null default '-1' comment '状态：-1-禁用，0-启用',
   primary key (ID)
);

/*==============================================================*/
/* Table: T_SYS_OPLOG                                           */
/*==============================================================*/
create table T_SYS_OPLOG
(
   ID                   bigint not null auto_increment comment '主键',
   USER_NAME            varchar(20) not null comment '用户名',
   OP_TYPE              varchar(50) not null comment '操作类型',
   OP_DESCRIBE          varchar(255) not null comment '操作描述',
   CREATE_TIME          date not null comment '日志时间',
   primary key (ID)
);

/*==============================================================*/
/* Table: T_SYS_USER                                            */
/*==============================================================*/
create table T_SYS_USER
(
   ID                   bigint not null auto_increment comment '主键',
   USER_NAME            varchar(20) not null comment '会员号',
   PASSWORD             varchar(50) not null comment '密码',
   REAL_NAME            varchar(50) comment '姓名',
   SEX                  varchar(1) default '1' comment '性别：0-女，1-男',
   BIRTHDAY             date comment '生日',
   TELEPHONE            varchar(20) not null comment '手机',
   LAST_LOGIN_TIME      datetime comment '上次登录时间',
   LAST_LOGIN_IP        varchar(20) comment '上次登录ip',
   CREATE_TIME          datetime not null comment '注册时间',
   LAST_MODIFIED        datetime comment '上次更新时间',
   STATU                varchar(2) not null default '-1' comment '状态：-1-禁用，0-启用',
   primary key (ID)
);
