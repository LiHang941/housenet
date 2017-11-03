
DROP TABLE house;
DROP TABLE type;
DROP TABLE street;
DROP TABLE district;
DROP TABLE users;


create table users
(
  id        int not null identity(1,1) primary key ,
  name      varchar(50),
  password  varchar(50),
  telephone varchar(15),
  username  varchar(50),
  isadmin   varchar(5)
);

create table type
(
  id   int not null identity(1,1) primary key ,
  money int ,
  name varchar(10) not null
)

create table district
(
  id   int not null identity(1,1) primary key ,
  name varchar(50) not null
);

create table street
(
  id          int not null identity(1,1) primary key ,
  name        varchar(50),
  district_id int,
  foreign key(district_id) references district(id)
);
create table house
(
  id          int not null identity(1,1) primary key ,
  user_id     int,
  type_id     int,
  title       nvarchar(50),
  description nvarchar(2000),
  price       int,
  pubdate     date,
  floorage    int,
  contact     varchar(100),
  street_id   int,
  foreign key(user_id) references users(id),
  foreign key(type_id) references type(id),
  foreign key(street_id) references street(id)
);



--用户
INSERT INTO users (name, password, telephone, username, isadmin) VALUES ('admin','admin','110','admin','1');


--类型
INSERT INTO type (money, name) VALUES (1000,'一室一厅');
INSERT INTO type (money, name) VALUES (2000,'一室二厅');
INSERT INTO type (money, name) VALUES (3000,'二室一厅');
INSERT INTO type (money, name) VALUES (4000,'二室二厅');


--区街
INSERT  INTO  district (name) VALUES ('台江区');
INSERT INTO street (name, district_id) VALUES ('瀛洲街道',1);
INSERT INTO street (name, district_id) VALUES ('后洲街道',1);
INSERT INTO street (name, district_id) VALUES ('义洲街道',1);
INSERT INTO street (name, district_id) VALUES ('新港街道',1);
INSERT INTO street (name, district_id) VALUES ('上海街道',1);
INSERT INTO street (name, district_id) VALUES ('苍霞街道',1);
INSERT INTO street (name, district_id) VALUES ('茶亭街道',1);
INSERT INTO street (name, district_id) VALUES ('宁化街道',1);
INSERT INTO street (name, district_id) VALUES ('鳌峰街道',1);
INSERT  INTO  district (name) VALUES ('岳池县');
INSERT INTO street (name, district_id) VALUES ('九龙镇',2);
INSERT INTO street (name, district_id) VALUES ('花园镇',2);
INSERT INTO street (name, district_id) VALUES ('坪滩镇',2);
INSERT INTO street (name, district_id) VALUES ('龙孔镇',2);
INSERT INTO street (name, district_id) VALUES ('镇裕镇',2);
INSERT INTO street (name, district_id) VALUES ('白庙镇',2);
INSERT INTO street (name, district_id) VALUES ('酉溪镇',2);
INSERT INTO street (name, district_id) VALUES ('同兴镇',2);
INSERT INTO street (name, district_id) VALUES ('兴隆镇',2);
INSERT INTO street (name, district_id) VALUES ('秦溪镇',2);
INSERT INTO street (name, district_id) VALUES ('顾县镇',2);
INSERT INTO street (name, district_id) VALUES ('苟角镇',2);
INSERT INTO street (name, district_id) VALUES ('天平镇',2);
INSERT INTO street (name, district_id) VALUES ('石垭镇',2);
INSERT INTO street (name, district_id) VALUES ('乔家镇',2);
INSERT INTO street (name, district_id) VALUES ('罗渡镇',2);
INSERT INTO street (name, district_id) VALUES ('裕民镇',2);
INSERT INTO street (name, district_id) VALUES ('中和镇',2);
INSERT INTO street (name, district_id) VALUES ('新场镇',2);
INSERT INTO street (name, district_id) VALUES ('普安镇',2);
INSERT INTO street (name, district_id) VALUES ('赛龙镇',2);
INSERT INTO street (name, district_id) VALUES ('临溪镇',2);
INSERT INTO street (name, district_id) VALUES ('朝阳乡',2);
INSERT INTO street (name, district_id) VALUES ('北城乡',2);
INSERT INTO street (name, district_id) VALUES ('镇龙乡',2);
INSERT INTO street (name, district_id) VALUES ('粽粑乡',2);
INSERT INTO street (name, district_id) VALUES ('排楼乡',2);
INSERT INTO street (name, district_id) VALUES ('西板乡',2);
INSERT INTO street (name, district_id) VALUES ('嘉陵乡',2);
INSERT INTO street (name, district_id) VALUES ('石鼓乡',2);
INSERT INTO street (name, district_id) VALUES ('平安乡',2);
INSERT INTO street (name, district_id) VALUES ('恐龙乡',2);
INSERT INTO street (name, district_id) VALUES ('团结乡',2);
INSERT INTO street (name, district_id) VALUES ('黄龙乡',2);
INSERT INTO street (name, district_id) VALUES ('双鄢乡',2);
INSERT INTO street (name, district_id) VALUES ('东板乡',2);
INSERT INTO street (name, district_id) VALUES ('长田乡',2);
INSERT INTO street (name, district_id) VALUES ('鱼峰乡',2);
INSERT INTO street (name, district_id) VALUES ('大石乡',2);
INSERT INTO street (name, district_id) VALUES ('花板乡',2);
INSERT INTO street (name, district_id) VALUES ('大佛乡',2);
INSERT INTO street (name, district_id) VALUES ('齐福乡',2);
INSERT INTO street (name, district_id) VALUES ('伏龙乡',2);
INSERT  INTO  district (name) VALUES ('广安区');
INSERT INTO street (name, district_id) VALUES ('浓洄街道',3);
INSERT INTO street (name, district_id) VALUES ('北辰街道',3);
INSERT INTO street (name, district_id) VALUES ('广福街道',3);
INSERT INTO street (name, district_id) VALUES ('万盛街道',3);
INSERT INTO street (name, district_id) VALUES ('中桥街道',3);
INSERT INTO street (name, district_id) VALUES ('枣山镇',3);
INSERT INTO street (name, district_id) VALUES ('官盛镇',3);
INSERT INTO street (name, district_id) VALUES ('协兴镇',3);
INSERT INTO street (name, district_id) VALUES ('浓溪镇',3);
INSERT INTO street (name, district_id) VALUES ('悦来镇',3);
INSERT INTO street (name, district_id) VALUES ('兴平镇',3);
INSERT INTO street (name, district_id) VALUES ('井河镇',3);
INSERT INTO street (name, district_id) VALUES ('花桥镇',3);
INSERT INTO street (name, district_id) VALUES ('龙台镇',3);
INSERT INTO street (name, district_id) VALUES ('肖溪镇',3);
INSERT INTO street (name, district_id) VALUES ('恒升镇',3);
INSERT INTO street (name, district_id) VALUES ('石笋镇',3);
INSERT INTO street (name, district_id) VALUES ('白市镇',3);
INSERT INTO street (name, district_id) VALUES ('大安镇',3);
INSERT INTO street (name, district_id) VALUES ('穿石乡',3);
INSERT INTO street (name, district_id) VALUES ('广门乡',3);
INSERT INTO street (name, district_id) VALUES ('广罗乡',3);
INSERT INTO street (name, district_id) VALUES ('方坪乡',3);
INSERT INTO street (name, district_id) VALUES ('化龙乡',3);
INSERT INTO street (name, district_id) VALUES ('大龙乡',3);
INSERT INTO street (name, district_id) VALUES ('崇望乡',3);
INSERT INTO street (name, district_id) VALUES ('龙安乡',3);
INSERT INTO street (name, district_id) VALUES ('彭家乡',3);
INSERT INTO street (name, district_id) VALUES ('杨坪乡',3);
INSERT INTO street (name, district_id) VALUES ('郑山乡',3);
INSERT INTO street (name, district_id) VALUES ('蒲莲乡',3);
INSERT INTO street (name, district_id) VALUES ('大有乡',3);
INSERT INTO street (name, district_id) VALUES ('消河乡',3);
INSERT INTO street (name, district_id) VALUES ('东岳乡',3);
INSERT INTO street (name, district_id) VALUES ('苏溪乡',3);
INSERT INTO street (name, district_id) VALUES ('白马乡',3);
INSERT  INTO  district (name) VALUES ('前锋区');
INSERT INTO street (name, district_id) VALUES ('奎阁街道',4);
INSERT INTO street (name, district_id) VALUES ('大佛寺街道',4);
INSERT INTO street (name, district_id) VALUES ('龙塘街道',4);
INSERT INTO street (name, district_id) VALUES ('桂兴镇',4);
INSERT INTO street (name, district_id) VALUES ('观阁镇',4);
INSERT INTO street (name, district_id) VALUES ('广兴镇',4);
INSERT INTO street (name, district_id) VALUES ('代市镇',4);
INSERT INTO street (name, district_id) VALUES ('观塘镇',4);
INSERT INTO street (name, district_id) VALUES ('护安镇',4);
INSERT INTO street (name, district_id) VALUES ('龙滩镇',4);
INSERT INTO street (name, district_id) VALUES ('虎城镇',4);
INSERT INTO street (name, district_id) VALUES ('小井乡',4);
INSERT INTO street (name, district_id) VALUES ('光辉乡',4);
INSERT INTO street (name, district_id) VALUES ('新桥乡',4);
