select * from dadmin;
insert into dadmin  values('1','李总','123456');
select a.id,a.username,a.password from dadmin a where password='123456'
select * from dCateGroy;
insert into dCateGroy values('4','科技',null,2)
select c.id cid ,c.name cname , c.parentId parentId ,c.levels cLevels,
        s.id sid ,s.name sname , s.parentId sParentId ,s.levels sLevels
        from dCateGroy c left join dCateGroy s on c.parentId=s.id
 select d.id did,d.name dname,d.parantId dparantId,d.levels dlevels,
 e.id eid,e.name ename,e.parantId eparantId,e.levels elevels from dCateGroy d left join
 dCateGroy e on d.parantId=e.id 
 
 
 select d.id did,d.name dname,e.id eid,e.name ename,salary 
	from dept d left join emp e on d.id=e.tid
	
	
	
	 select * from dCateGroy;
	 
select id,name,parantId,levels from dCateGroy where levels=1; 	 
	  select * from dCateGroy;
	  //图书表	
create table dBook(
   id                   varchar2(40)                 not null,
   dname                 varchar2(50),
   author               varchar2(50),
   cover                varchar2(100),
   press                varchar2(50),
   pressdate            date,
   edition              number(3),
   printdate            date,
   impression           number(3),
   isbn                 varchar2(50),
   wordNum              number(10),
   pageNum              number(4),
   dsize               	varchar2(50),
   paper                varchar2(50),
   pack                 varchar2(50),
   price                number(5,2),
   dPrice               number(5,2),
   createdate           date,
   editorRecommend      varchar2(1000),
   contentAbstract      varchar2(1000),
   authorAbstract       varchar2(1000),
   director             varchar2(500),
   mediaCommentary      varchar2(100),
   sale                 number(5),
   stock                number(5),
   categoryId           varchar2(50),
   constraint PK_DBOOK primary key (id)
);

insert into dbook values(1,'黄','黄','黄','黄',sysdate,2,sysdate,
3,'黄',4,5,'皇','磺','煌',1.2,1.3,sysdate,'仗','张','张','四张','五张',
6,7,'巴掌'
);
    //类别表
create table dCateGroy  (
   id                   VARCHAR2(50)                    not null,
   name                 VARCHAR2(50),
   parantId             VARCHAR2(50),
   levels               NUMBER(3),
   constraint PK_DCATEGROY primary key (id)
);	
      //用户表
create table dUser  (
   id                   VARCHAR2(50)                    not null,
   email                VARCHAR2(50),
   password             VARCHAR2(50),
   salt                 VARCHAR2(50),
   nickname             VARCHAR2(50),
   status               VARCHAR2(50),
   code                 VARCHAR2(50),
   createDate           DATE,
   constraint PK_DUSER primary key (id)
);
select * from duser;



      地址表
create table dAddress  (
   id                   VARCHAR2(50)                    not null,
   name                 VARCHAR2(50),
   local                VARCHAR2(50),
   zipCode              VARCHAR2(50),
   phone                VARCHAR2(50),
   userId               VARCHAR2(50),
   constraint PK_DADDRESS primary key (id)
);
drop table daddress
select * from daddress
select * from duser;
insert into daddress values('1','李传鑫','河南省','476800','15139101825','06463c6c-d2bb-4704-8f81-595dbcccde22')
insert into daddress values('2','李飞羽','商丘市','476800','15139101825','06463c6c-d2bb-4704-8f81-595dbcccde22')


	select * from daddress where userId='06463c6c-d2bb-4704-8f81-595dbcccde22'



select * from daddress


    订单表
fd4879bc-0192-4dba-9d50-809326fbabbe
create table dOrder  (
   id                   VARCHAR2(50)                    not null,
   orderNo 				 VARCHAR2(50),
   name					VARCHAR2(50),
   local				VARCHAR2(50),
   total                NUMBER(10,2),
   createDate           DATE,
   status               VARCHAR2(50),
   addressId            VARCHAR2(50),      
   userId               VARCHAR2(50),
   constraint PK_DORDER primary key (id)
);

select * from dorder
    订单项表
    create table dItem  (
   id                   VARCHAR2(50)                    not null,
   bookId               VARCHAR2(50),
  	name				VARCHAR2(50),
  	price                number(5,2),
   dPrice               number(5,2),
    cover                varchar2(100),
   count                NUMBER(5),
   createDate           DATE,
   orderId              VARCHAR2(50),
   constraint PK_DITEM primary key (id)
);

select * from ditem

d9dccef6-ca92-464a-8e4e-6d0a7db8d0a8
select * from ditem where orderid='b040b55c-8613-458e-a321-be972e9748af'
select * from dbook;
select * from left


