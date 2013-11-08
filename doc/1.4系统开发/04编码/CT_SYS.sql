drop index SNVGSUSR."Index_2";

drop table SNVGSUSR.T_SYS_ROLE;

--==============================================================
-- Table: T_SYS_ROLE
--==============================================================
create table SNVGSUSR.T_SYS_ROLE (
   ID                   BIGINT                 not null
    generated always as identity,
   ROLE_NAME            VARCHAR(60)            not null,
   DESCRIB              VARCHAR(100)           not null,
   LAST_MODIFIER        VARCHAR(20)            not null,
   LAST_MODIFIED        TIMESTAMP              not null default 
'CURRENT_TIMESTAMP',
   constraint SQL130517212014850 primary key (ID)
);

comment on table SNVGSUSR.T_SYS_ROLE is
'酒店后台角色表';

comment on column SNVGSUSR.T_SYS_ROLE.ID is
'主键';

comment on column SNVGSUSR.T_SYS_ROLE.ROLE_NAME is
'角色名';

comment on column SNVGSUSR.T_SYS_ROLE.DESCRIB is
'角色描述';

comment on column SNVGSUSR.T_SYS_ROLE.LAST_MODIFIER is
'最后修改人员';

comment on column SNVGSUSR.T_SYS_ROLE.LAST_MODIFIED is
'最后修改时间';

--==============================================================
-- Index: "Index_2"
--==============================================================
create index SNVGSUSR."Index_2" on SNVGSUSR.T_SYS_ROLE (
   ID                   ASC
);

drop index SNVGSUSR."Index_4";

drop table SNVGSUSR.T_SYS_USER;

--==============================================================
-- Table: T_SYS_USER
--==============================================================
create table SNVGSUSR.T_SYS_USER (
   ID                   BIGINT                 not null
    generated always as identity,
   USER_NAME            VARCHAR(20)            not null,
   PASSWORD             VARCHAR(20)            not null,
   REALNAME             VARCHAR(20)            not null,
   TELEPHONE            VARCHAR(20),
   LAST_LOGINTIME       TIMESTAMP,
   LAST_LOGINIP         VARCHAR(20),
   LAST_MODIFIER        VARCHAR(20)            not null,
   LAST_MODIFIED        TIMESTAMP              not null default 
'CURRENT_TIMESTAMP',
   STATUS               VARCHAR(2)             default '1',
   constraint "P_Key_1" primary key (ID)
);

comment on table SNVGSUSR.T_SYS_USER is
'描述：酒店后台用户表
用途：用于保存酒店后台用户信息';

comment on column SNVGSUSR.T_SYS_USER.USER_NAME is
'用户名';

comment on column SNVGSUSR.T_SYS_USER.PASSWORD is
'密码';

comment on column SNVGSUSR.T_SYS_USER.REALNAME is
'姓名';

comment on column SNVGSUSR.T_SYS_USER.TELEPHONE is
'联系电话';

comment on column SNVGSUSR.T_SYS_USER.LAST_LOGINTIME is
'上次登录时间';

comment on column SNVGSUSR.T_SYS_USER.LAST_LOGINIP is
'上次登录IP';

comment on column SNVGSUSR.T_SYS_USER.LAST_MODIFIER is
'最后修改人员';

comment on column SNVGSUSR.T_SYS_USER.LAST_MODIFIED is
'最后修改时间';

comment on column SNVGSUSR.T_SYS_USER.STATUS is
'状态（0：禁用，1：启用）';

--==============================================================
-- Index: "Index_4"
--==============================================================
create index SNVGSUSR."Index_4" on SNVGSUSR.T_SYS_USER (
   ID                   ASC,
   USER_NAME            ASC,
   STATUS               ASC
);

drop index SNVGSUSR."Index_5";

drop table SNVGSUSR.T_SYS_MENU;

--==============================================================
-- Table: T_SYS_MENU
--==============================================================
create table SNVGSUSR.T_SYS_MENU (
   ID                   BIGINT                 not null
    generated always as identity,
   P_ID                 BIGINT                 not null default -1,
   MENU_NAME            VARCHAR(50),
   HREF                 VARCHAR(100),
   DESCRIB              VARCHAR(100)           not null,
   SEQ_NUM              BIGINT                 default 0,
   LAST_MODIFIER        VARCHAR(20)            not null,
   LAST_MODIFIED        TIMESTAMP              default 
'CURRENT_TIMESTAMP',
   constraint SQL130517212014760 primary key (ID)
);

comment on table SNVGSUSR.T_SYS_MENU is
'酒店后台菜单表';

comment on column SNVGSUSR.T_SYS_MENU.ID is
'主键';

comment on column SNVGSUSR.T_SYS_MENU.P_ID is
'上级菜单（模块）ID';

comment on column SNVGSUSR.T_SYS_MENU.MENU_NAME is
'菜单名';

comment on column SNVGSUSR.T_SYS_MENU.HREF is
'菜单链接';

comment on column SNVGSUSR.T_SYS_MENU.DESCRIB is
'菜单描述';

comment on column SNVGSUSR.T_SYS_MENU.SEQ_NUM is
'菜单排列顺序';

comment on column SNVGSUSR.T_SYS_MENU.LAST_MODIFIER is
'最后修改人员';

comment on column SNVGSUSR.T_SYS_MENU.LAST_MODIFIED is
'最后修改时间';

--==============================================================
-- Index: "Index_5"
--==============================================================
create index SNVGSUSR."Index_5" on SNVGSUSR.T_SYS_MENU (
   ID                   ASC,
   P_ID                 ASC,
   SEQ_NUM              ASC
);

drop index SNVGSUSR."Index_6";

drop table SNVGSUSR.T_SYS_ROLEMENUREF;

--==============================================================
-- Table: T_SYS_ROLEMENUREF
--==============================================================
create table SNVGSUSR.T_SYS_ROLEMENUREF (
   ID                   BIGINT                 not null
    generated always as identity,
   ROLE_ID              BIGINT                 not null,
   MENU_ID              BIGINT,
   LAST_MODIFIER        VARCHAR(20)            not null,
   LAST_MODIFIED        TIMESTAMP              default 
'CURRENT_TIMESTAMP',
   constraint SQL130517212014920 primary key (ID)
);

comment on table SNVGSUSR.T_SYS_ROLEMENUREF is
'酒店后台角色菜单关联表';

comment on column SNVGSUSR.T_SYS_ROLEMENUREF.ID is
'主键';

comment on column SNVGSUSR.T_SYS_ROLEMENUREF.ROLE_ID is
'角色Id';

comment on column SNVGSUSR.T_SYS_ROLEMENUREF.MENU_ID is
'菜单Id';

comment on column SNVGSUSR.T_SYS_ROLEMENUREF.LAST_MODIFIER is
'最后修改人员';

comment on column SNVGSUSR.T_SYS_ROLEMENUREF.LAST_MODIFIED is
'最后修改时间';

--==============================================================
-- Index: "Index_6"
--==============================================================
create index SNVGSUSR."Index_6" on SNVGSUSR.T_SYS_ROLEMENUREF (
   ID                   ASC,
   ROLE_ID              ASC,
   MENU_ID              ASC
);

drop index SNVGSUSR."Index_3";

drop table SNVGSUSR.T_SYS_USERROLEREF;

--==============================================================
-- Table: T_SYS_USERROLEREF
--==============================================================
create table SNVGSUSR.T_SYS_USERROLEREF (
   ID                   BIGINT                 not null
    generated always as identity,
   USER_ID              BIGINT                 not null,
   ROLE_ID              BIGINT                 not null,
   LAST_MODIFIED        TIMESTAMP              default 
'CURRENT_TIMESTAMP',
   LAST_MODIFIER        VARCHAR(20)            not null,
   constraint SQL130517212015060 primary key (ID)
);

comment on table SNVGSUSR.T_SYS_USERROLEREF is
'酒店后台用户角色关联表';

comment on column SNVGSUSR.T_SYS_USERROLEREF.ID is
'主键';

comment on column SNVGSUSR.T_SYS_USERROLEREF.USER_ID is
'用户Id';

comment on column SNVGSUSR.T_SYS_USERROLEREF.ROLE_ID is
'角色Id';

comment on column SNVGSUSR.T_SYS_USERROLEREF.LAST_MODIFIED is
'最后修改时间';

comment on column SNVGSUSR.T_SYS_USERROLEREF.LAST_MODIFIER is
'最后修改人员';

--==============================================================
-- Index: "Index_3"
--==============================================================
create index SNVGSUSR."Index_3" on SNVGSUSR.T_SYS_USERROLEREF (
   ID                   ASC,
   USER_ID              ASC,
   ROLE_ID              ASC
);
