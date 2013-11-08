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
   ID                   bigint not null auto_increment comment '����',
   BUSINESS_NO          varchar(20) not null comment '�̻���',
   REAL_NAME            varchar(50) not null comment '�̻�����',
   CREATE_TIME          datetime not null comment 'ע��ʱ��',
   LAST_MODIFIED        datetime comment '�ϴθ���ʱ��',
   PROVIENCE_ID         numeric(8,0) not null comment 'ʡ��',
   CITY_ID              numeric(8,0) not null comment '����',
   COUNTY_ID            numeric(8,0) not null comment '����',
   ADDRESS              varchar(255) comment '��ַ',
   STATU                varchar(2) not null default '-1' comment '״̬��-1-���ã�0-����',
   primary key (ID)
);

/*==============================================================*/
/* Table: T_BUSINESS_COMMOIFO                                   */
/*==============================================================*/
create table T_BUSINESS_COMMOIFO
(
   ID                   bigint not null auto_increment comment '����',
   COMMO_NO             varchar(20) not null comment '��Ʒ���',
   COMMO_NAME           varchar(50) not null comment '�̻�����',
   BUSINESS_ID          numeric(8,0) not null comment '�̻�ID',
   COMMO_DESCRIBE       varchar(255) not null comment '��Ʒ����',
   CREATE_TIME          datetime not null comment 'ע��ʱ��',
   LAST_MODIFIED        datetime comment '�ϴθ���ʱ��',
   STATU                varchar(2) not null default '-1' comment '״̬��-1-���ã�0-����',
   SETTLE_PRICE         decimal(8,4) not null comment '����',
   SELL_PRICE           decimal(8,4) not null comment '�ۼ�',
   primary key (ID)
);

/*==============================================================*/
/* Table: T_BUSINESS_SHIPPING                                   */
/*==============================================================*/
create table T_BUSINESS_SHIPPING
(
   ID                   bigint not null auto_increment comment '����',
   BUSINESS_ID          numeric(8,0) not null comment '�̻�ID',
   LOCATION_ID          numeric(8,0) not null comment 'λ��ID',
   ADDRESS              varchar(255) comment '��ַ',
   CREATE_TIME          datetime not null comment '����ʱ��',
   LAST_MODIFIED        datetime comment '�ϴθ���ʱ��',
   STATU                varchar(2) not null default '-1' comment '״̬��-1-���ã�0-����',
   primary key (ID)
);

/*==============================================================*/
/* Table: T_COMM_CODEGEN                                        */
/*==============================================================*/
create table T_COMM_CODEGEN
(
   ID                   bigint not null auto_increment comment '����',
   CODE_TYPE            varchar(50) not null comment '��������',
   GEN_TPL              varchar(50) not null comment '����ģ��',
   CUR_VALUE            bigint not null default 0 comment '��ǰ��ˮ��ֵ',
   CODE_DESCRIBE        varchar(255) not null comment '��������',
   CREATE_TIME          datetime not null comment '����ʱ��',
   LAST_MODIFIED        datetime comment '�ϴθ���ʱ��',
   STATU                varchar(2) not null default '-1' comment '״̬��-1-���ã�0-����',
   primary key (ID)
);

/*==============================================================*/
/* Table: T_COMM_LOCATION                                       */
/*==============================================================*/
create table T_COMM_LOCATION
(
   ID                   bigint not null auto_increment comment '����',
   PROV_ID              bigint not null comment 'ʡ��ID',
   PROV_NAME            varchar(50) not null comment 'ʡ������',
   CITY_ID              bigint not null comment '����ID',
   CITY_NAME            varchar(50) not null comment '��������',
   COUNTY_ID            bigint not null comment '����ID',
   COUNTY_NAME          varchar(50) not null comment '��������',
   CREATE_TIME          datetime not null comment '����ʱ��',
   LAST_MODIFIED        datetime comment '�ϴθ���ʱ��',
   STATU                varchar(2) not null default '-1' comment '״̬��-1-���ã�0-����',
   primary key (ID)
);

/*==============================================================*/
/* Table: T_MEMBER_MEMBERINFO                                   */
/*==============================================================*/
create table T_MEMBER_MEMBERINFO
(
   ID                   bigint not null auto_increment comment '����',
   MEMBER_NO            varchar(20) not null comment '��Ա��',
   PASSWORD             varchar(50) not null comment '����',
   REAL_NAME            varchar(50) comment '����',
   SEX                  varchar(1) default '1' comment '�Ա�0-Ů��1-��',
   BIRTHDAY             date comment '����',
   MOBILE               varchar(20) not null comment '�ֻ�',
   EMAIL                varchar(50),
   LAST_LOGIN_TIME      datetime comment '�ϴε�¼ʱ��',
   LAST_LOGIN_IP        varchar(20) comment '�ϴε�¼ip',
   CREATE_TIME          datetime not null comment 'ע��ʱ��',
   LAST_MODIFIED        datetime comment '�ϴθ���ʱ��',
   PROVINCE_ID         bigint comment 'ʡ��',
   CITY_ID              bigint comment '����',
   COUNTY_ID            bigint comment '����',
   ADDRESS              varchar(256) comment '��ַ',
   STATU                varchar(2) not null default '-1' comment '״̬��-1-���ã�0-����',
   primary key (ID)
);

/*==============================================================*/
/* Table: T_ORDER_COMMO                                         */
/*==============================================================*/
create table T_ORDER_COMMO
(
   ID                   bigint not null auto_increment comment '����',
   ORDER_ID             bigint not null comment '����ID',
   COMMO_ID             bigint not null comment '��ƷID',
   COMMO_NAME           varchar(50) not null comment '��Ʒ����',
   SETTLE_PRICE         decimal(8,4) not null comment '�����',
   SELL_PRICE           decimal(8,4) not null comment '�ۼ�',
   COMMO_AMOUNT         int not null default 1 comment '��Ʒ����',
   CREATE_TIME          datetime not null comment '����ʱ��',
   LAST_MODIFIED        datetime comment '�ϴθ���ʱ��',
   STATU                varchar(2) not null default '-1' comment '״̬��-1-���ã�0-����',
   primary key (ID)
);

/*==============================================================*/
/* Table: T_ORDER_ORDERINFO                                     */
/*==============================================================*/
create table T_ORDER_ORDERINFO
(
   ID                   bigint not null auto_increment comment '����',
   MEMBER_ID            bigint not null comment '��ԱID',
   ORDER_NO             varchar(20) not null comment '�������',
   CONTACT_NAME         varchar(50) not null comment '����',
   MOBILE            varchar(20) not null comment '�ֻ�',
   EMAIL                varchar(50) comment 'EMAIL',
   CREATE_TIME          datetime not null comment '�µ�ʱ��',
   LAST_MODIFIED        datetime comment '�ϴθ���ʱ��',
   PROVINCE_ID         bigint not null comment 'ʡ��',
   CITY_ID              bigint not null comment '����',
   COUNTY_ID            bigint not null comment '����',
   ADDRESS              varchar(255) not null comment '��ַ',
   SELL_AMOUNT          decimal(8,4) not null comment '�������',
   SETTLE_AMOUNT        decimal(8,4) comment '������',
   STATU                varchar(2) not null default '-1' comment '״̬��-1-���ϣ�0-�����֧����1-֧����ȷ�ϣ�2-ȷ�ϴ�������3-������ǩ�գ�4-ǩ��',
   primary key (ID)
);

/*==============================================================*/
/* Table: T_ORDER_SHOPPINGCART                                  */
/*==============================================================*/
create table T_ORDER_SHOPPINGCART
(
   ID                   bigint not null auto_increment comment '����',
   MEMBER_ID            bigint not null comment '����ID',
   COMMO_ID             bigint not null comment '��ƷID',
   COMMO_NAME           varchar(50) not null comment '��Ʒ����',
   SETTLE_PRICE         decimal(8,4) not null comment '�����',
   SELL_PRICE           decimal(8,4) not null comment '�ۼ�',
   COMMO_AMOUNT         int not null default 1 comment '��Ʒ����',
   CREATE_TIME          datetime not null comment '����ʱ��',
   LAST_MODIFIED        datetime comment '�ϴθ���ʱ��',
   STATU                varchar(2) not null default '-1' comment '״̬��-1-���ã�0-����',
   primary key (ID)
);

/*==============================================================*/
/* Table: T_SYS_OPLOG                                           */
/*==============================================================*/
create table T_SYS_OPLOG
(
   ID                   bigint not null auto_increment comment '����',
   USER_NAME            varchar(20) not null comment '�û���',
   OP_TYPE              varchar(50) not null comment '��������',
   OP_DESCRIBE          varchar(255) not null comment '��������',
   CREATE_TIME          date not null comment '��־ʱ��',
   primary key (ID)
);

/*==============================================================*/
/* Table: T_SYS_USER                                            */
/*==============================================================*/
create table T_SYS_USER
(
   ID                   bigint not null auto_increment comment '����',
   USER_NAME            varchar(20) not null comment '��Ա��',
   PASSWORD             varchar(50) not null comment '����',
   REAL_NAME            varchar(50) comment '����',
   SEX                  varchar(1) default '1' comment '�Ա�0-Ů��1-��',
   BIRTHDAY             date comment '����',
   TELEPHONE            varchar(20) not null comment '�ֻ�',
   LAST_LOGIN_TIME      datetime comment '�ϴε�¼ʱ��',
   LAST_LOGIN_IP        varchar(20) comment '�ϴε�¼ip',
   CREATE_TIME          datetime not null comment 'ע��ʱ��',
   LAST_MODIFIED        datetime comment '�ϴθ���ʱ��',
   STATU                varchar(2) not null default '-1' comment '״̬��-1-���ã�0-����',
   primary key (ID)
);
