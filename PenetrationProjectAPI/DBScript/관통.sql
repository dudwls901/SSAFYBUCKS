drop database if exists ssafy_mobile_cafe;
select @@global.transaction_isolation, @@transaction_isolation;
set @@transaction_isolation="read-committed";

create database ssafy_mobile_cafe;
use ssafy_mobile_cafe;

create table t_user(
	id varchar(100) primary key,
    name varchar(100) not null,
    pass varchar(100) not null,
    stamps integer default 0
);
create table t_product(
	id integer auto_increment primary key,
    name varchar(100) not null,
    type varchar(20) not null,
    price integer not null,
    img varchar(100) not null
);


create  table t_order(
	o_id integer auto_increment primary key,
    user_id varchar(100) not null,
    order_table varchar(20),
    order_time timestamp default CURRENT_TIMESTAMP,    
    completed char(1) default 'N',
    constraint fk_order_user foreign key (user_id) references t_user(id) on delete cascade
);

create table t_order_detail(
	d_id integer auto_increment primary key,
    order_id integer not null,
    product_id integer not null,
    quantity integer not null default 1,
    constraint fk_order_detail_product foreign key (product_id) references t_product(id) on delete cascade,
    constraint fk_order_detail_order foreign key(order_id) references t_order(o_id) on delete cascade
);                                                 

create table t_stamp(
	id integer auto_increment primary key,
    user_id varchar(100) not null,
    order_id integer not null,
    quantity integer not null default 1,
    constraint fk_stamp_user foreign key (user_id) references t_user(id) on delete cascade,
    constraint fk_stamp_order foreign key (order_id) references t_order(o_id) on delete cascade
);

create table t_comment(
	id integer auto_increment primary key,
    user_id varchar(100) not null,
    product_id integer not null,
    rating float not null default 1,
    comment varchar(200),
    constraint fk_comment_user foreign key(user_id) references t_user(id) on delete cascade,
    constraint fk_comment_product foreign key(product_id) references t_product(id) on delete cascade
);

create table t_user_token(
    user_id varchar(100) primary key,
    token varchar(300) not null,
	constraint fk_token_user foreign key(user_id) references t_user(id) on delete cascade
);

create table t_shopping_list(
    id integer auto_increment primary key,
    user_id varchar(100) not null,
    product_id integer not null,
    quantity integer not null default 1,
	constraint fk_shopping_list_user foreign key(user_id) references t_user(id) on delete cascade,
    constraint fk_shopping_list_product foreign key(product_id) references t_product(id) on delete cascade
);

create table t_order_type(
	order_id integer primary key,
    type varchar(20) default 'out',
    constraint fk_order_type_order foreign key(order_id) references t_order(o_id) on delete cascade
);

INSERT INTO t_user (id, name, pass, stamps) VALUES ('admin', '관리자', 'admin', 0);
INSERT INTO t_user (id, name, pass, stamps) VALUES ('ssafy01', '김싸피', 'pass01', 26);
INSERT INTO t_user (id, name, pass, stamps) VALUES ('ssafy02', '황원태', 'pass02', 9);
INSERT INTO t_user (id, name, pass, stamps) VALUES ('ssafy03', '한정일', 'pass03', 26);
INSERT INTO t_user (id, name, pass, stamps) VALUES ('ssafy04', '반장운', 'pass04', 4);
INSERT INTO t_user (id, name, pass, stamps) VALUES ('ssafy05', '박하윤', 'pass05', 5);
INSERT INTO t_user (id, name, pass, stamps) VALUES ('ssafy06', '정비선', 'pass06', 6);
INSERT INTO t_user (id, name, pass, stamps) VALUES ('ssafy07', '김병관', 'pass07', 7);
INSERT INTO t_user (id, name, pass, stamps) VALUES ('ssafy08', '강석우', 'pass08', 8);
INSERT INTO t_user (id, name, pass, stamps) VALUES ('ssafy09', '견본무', 'pass09', 9);
INSERT INTO t_user (id, name, pass, stamps) VALUES ('ssafy10', '전인성', 'pass10', 20);

INSERT INTO t_product (name, type, price, img) VALUES ('아메리카노', 'coffee', 4100, 'coffee1.png');
INSERT INTO t_product (name, type, price, img) VALUES ('카페라떼', 'coffee', 4500, 'coffee2.png');
INSERT INTO t_product (name, type, price, img) VALUES ('카라멜 마끼아또', 'coffee', 4800, 'coffee3.png');
INSERT INTO t_product (name, type, price, img) VALUES ('카푸치노', 'coffee', 4800, 'coffee4.png');
INSERT INTO t_product (name, type, price, img) VALUES ('모카라떼', 'coffee', 4800, 'coffee5.png');
INSERT INTO t_product (name, type, price, img) VALUES ('민트라떼', 'coffee', 4300, 'coffee6.png');
INSERT INTO t_product (name, type, price, img) VALUES ('화이트 모카라떼', 'coffee', 4800, 'coffee7.png');
INSERT INTO t_product (name, type, price, img) VALUES ('자몽에이드', 'coffee', 5100, 'coffee8.png');
INSERT INTO t_product (name, type, price, img) VALUES ('레몬에이드', 'coffee', 5100, 'coffee9.png');
INSERT INTO t_product (name, type, price, img) VALUES ('초코칩 쿠키', 'cookie', 1500, 'cookie.png');
commit;
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy01', 1, 1.2, '신맛 강한 커피는 좀 별루네요.');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy02', 1, 2, '커피 맛을 좀 신경 써야 할 것 같네요.');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy03', 1, 3, '그냥 저냥');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy04', 4, 4, '갠춘한 맛');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy05', 5, 5, 'SoSSo');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy06', 6, 6, '그냥 저냥 먹을만함');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy07', 7, 10, '이집 화이트 모카라떼가 젤 나은듯');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy08', 8, 8, '자몽 특유의 맛이 살아있네요.');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy09', 8, 9, '수제 자몽에이드라 그런지 맛나요.');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy10', 10, 10, '초코칩 쿠키 먹으로 여기 옵니다.');
 
INSERT INTO t_order (user_id, order_table, order_time, completed) VALUES ('ssafy01', 'order_table 01', '2022-05-22', 'Y');
INSERT INTO t_order (user_id, order_table, order_time, completed) VALUES ('ssafy01', 'order_table 02', '2022-05-23', 'Y');
INSERT INTO t_order (user_id, order_table, order_time, completed) VALUES ('ssafy03', 'order_table 03', '2022-05-23', 'Y');
INSERT INTO t_order (user_id, order_table, order_time, completed) VALUES ('ssafy04', 'order_table 04', '2022-05-22', 'Y');
INSERT INTO t_order (user_id, order_table, order_time, completed) VALUES ('ssafy05', 'order_table 05', '2022-05-21', 'Y');
INSERT INTO t_order (user_id, order_table, order_time, completed) VALUES ('ssafy06', 'order_table 06', '2022-05-24', 'Y');
INSERT INTO t_order (user_id, order_table, order_time, completed) VALUES ('ssafy07', 'order_table 07', '2022-05-24', 'Y');
INSERT INTO t_order (user_id, order_table, order_time, completed) VALUES ('ssafy08', 'order_table 08', '2022-05-24', 'Y');
INSERT INTO t_order (user_id, order_table, order_time, completed) VALUES ('ssafy09', 'order_table 09', '2022-05-23', 'Y');
INSERT INTO t_order (user_id, order_table, order_time, completed) VALUES ('ssafy10', 'order_table 10', '2022-05-22', 'Y');

INSERT INTO t_order_detail (order_id, product_id, quantity) VALUES (1, 1, 1);
INSERT INTO t_order_detail (order_id, product_id, quantity) VALUES (1, 2, 3);
INSERT INTO t_order_detail (order_id, product_id, quantity) VALUES (2, 8, 1);
INSERT INTO t_order_detail (order_id, product_id, quantity) VALUES (3, 3, 3);
INSERT INTO t_order_detail (order_id, product_id, quantity) VALUES (4, 4, 4);
INSERT INTO t_order_detail (order_id, product_id, quantity) VALUES (5, 5, 5);
INSERT INTO t_order_detail (order_id, product_id, quantity) VALUES (6, 6, 6);
INSERT INTO t_order_detail (order_id, product_id, quantity) VALUES (7, 7, 7);
INSERT INTO t_order_detail (order_id, product_id, quantity) VALUES (8, 8, 8);
INSERT INTO t_order_detail (order_id, product_id, quantity) VALUES (9, 9, 9);
INSERT INTO t_order_detail (order_id, product_id, quantity) VALUES (10, 8, 10);
INSERT INTO t_order_detail (order_id, product_id, quantity) VALUES (10, 10, 10);

INSERT INTO t_stamp (user_id, order_id, quantity) VALUES ('ssafy01', 1, 4);
INSERT INTO t_stamp (user_id, order_id, quantity) VALUES ('ssafy01', 2, 1);
INSERT INTO t_stamp (user_id, order_id, quantity) VALUES ('ssafy03', 3, 3);
INSERT INTO t_stamp (user_id, order_id, quantity) VALUES ('ssafy04', 4, 4);
INSERT INTO t_stamp (user_id, order_id, quantity) VALUES ('ssafy05', 5, 5);
INSERT INTO t_stamp (user_id, order_id, quantity) VALUES ('ssafy06', 6, 6);
INSERT INTO t_stamp (user_id, order_id, quantity) VALUES ('ssafy07', 7, 7);
INSERT INTO t_stamp (user_id, order_id, quantity) VALUES ('ssafy08', 8, 8);
INSERT INTO t_stamp (user_id, order_id, quantity) VALUES ('ssafy09', 9, 9);
INSERT INTO t_stamp (user_id, order_id, quantity) VALUES ('ssafy10', 10, 20);

INSERT INTO t_user_token (user_id, token) VALUES ('ssafy01', ' ');
INSERT INTO t_user_token (user_id, token) VALUES ('ssafy02', ' ');
INSERT INTO t_user_token (user_id, token) VALUES ('ssafy03', ' ');
INSERT INTO t_user_token (user_id, token) VALUES ('ssafy04', ' ');
INSERT INTO t_user_token (user_id, token) VALUES ('ssafy05', ' ');
INSERT INTO t_user_token (user_id, token) VALUES ('ssafy06', ' ');
INSERT INTO t_user_token (user_id, token) VALUES ('ssafy07', ' ');
INSERT INTO t_user_token (user_id, token) VALUES ('ssafy08', ' ');
INSERT INTO t_user_token (user_id, token) VALUES ('ssafy09', ' ');
INSERT INTO t_user_token (user_id, token) VALUES ('ssafy10', ' ');

INSERT INTO t_shopping_list (user_id, product_id, quantity) VALUES ('ssafy01', 1 ,1);
INSERT INTO t_shopping_list (user_id, product_id, quantity) VALUES ('ssafy01', 2 ,1);
INSERT INTO t_shopping_list (user_id, product_id, quantity) VALUES ('ssafy01', 3 ,1);

INSERT INTO t_order_type (order_id, type) VALUES (1 ,'in');
INSERT INTO t_order_type (order_id) VALUES (2);
INSERT INTO t_order_type (order_id, type) VALUES (3 ,'in');
INSERT INTO t_order_type (order_id, type) VALUES (4 ,'in');
INSERT INTO t_order_type (order_id, type) VALUES (5 ,'in');
INSERT INTO t_order_type (order_id, type) VALUES (6 ,'in');
INSERT INTO t_order_type (order_id, type) VALUES (7 ,'in');
INSERT INTO t_order_type (order_id, type) VALUES (8 ,'in');
INSERT INTO t_order_type (order_id) VALUES (9);
INSERT INTO t_order_type (order_id) VALUES (10);



INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy01', 2, 5, '평범한 카페라떼');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy01', 3, 8.8, '마끼야또');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy01', 4, 10, '최고의 맛');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy01', 5, 5, '그럭저럭');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy01', 6, 5, '민초단에게 평범함');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy01', 7, 7.8, '모카라떼 JMT');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy01', 8, 8, '좋아요');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy01', 9, 6, '안뇽하세요');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy01', 10, 3, '쿠키 맛없어요');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy02', 1, 9.2, '굳');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy02', 2, 10, '너무 맛있어');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy02', 3, 4.2, '맛이 좋아');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy02', 4, 5.2, '아주 맛이 좋아');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy02', 5, 4.2, '엑 맛없어~');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy02', 6, 9.2, '으으 졸려');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy02', 7, 8.8, '너무 맛있는데?');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy02', 8, 9.2, '굳~.~');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy02', 9, 9.2, '굳뜨!!');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy02', 10, 9.2, '난 이게 좋아');

INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy03', 1, 9.2, '굳');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy03', 2, 10, '맛이 있어유!');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy03', 3, 4.2, '맛이 좋아');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy03', 4, 6.2, '알라뷰');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy03', 5, 4.2, '엑 맛없어~');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy03', 6, 9.2, '으으 졸려');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy03', 7, 8.8, '시원하니 좋구만');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy03', 8, 9.2, '굳~.~');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy03', 9, 2.2, '굳뜨!!');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy03', 10, 4.4, '난 이게 좋아');

INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy04', 1, 9.2, '굳');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy04', 2, 10, '맛이 있어유!');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy04', 3, 4.2, '맛이 좋아');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy04', 4, 6.2, '알라뷰');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy04', 5, 4.2, '엑 맛없어~');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy04', 6, 9.2, '으으 졸려');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy04', 7, 8.8, '시원하니 좋구만');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy04', 8, 9.2, '굳~.~');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy04', 9, 2.2, '굳뜨!!');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy04', 10, 4.4, '난 이게 좋아');

INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy05', 1, 1.2, '굳');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy05', 2, 2.2, '맛이 있어유!');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy05', 3, 10, '맛이 좋아');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy05', 4, 4.4, '맛있어요!');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy05', 5, 5.6, '오늘 같은 날에는 최고지');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy05', 6, 2.2, '으으 졸려');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy05', 7, 9, '시원하니 좋구만');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy05', 8, 9.2, '굳~.~');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy05', 9, 2.2, '굳뜨!!');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy05', 10, 10, '난 이게 좋아');

INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy06', 1, 9.2, '굳');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy06', 2, 10, '싸벅 최고..');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy06', 3, 4.2, '맛이 좋아');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy06', 4, 6.2, '알라뷰');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy06', 5, 4.2, '맛만 좋구만');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy06', 6, 9.2, '나른하네~');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy06', 7, 8.8, '시원하니 좋구만');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy06', 8, 9.2, '싸피벅스 좋아요!');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy06', 9, 2.2, '싸피벅스 최고');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy06', 10, 4.4, '난 이게 좋아');

INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy07', 1, 9.2, '굳');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy07', 2, 10, '후 잠 깬다.!');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy07', 3, 4.2, '맛이 좋아');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy07', 4, 6.2, '알라뷰');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy07', 5, 4.2, '맛이 좀 그래~');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy07', 6, 9.2, '으으 졸려');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy07', 7, 8.8, '시원하니 최고!!');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy07', 8, 9.2, '맛있어!');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy07', 9, 2.2, '엑 별로');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy07', 10, 2.4, '난 이거 별로');

INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy08', 1, 9.2, '마이 페이보릿');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy08', 2, 10, '이거 맛있어요 여러분');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy08', 3, 4.2, '맛이 좋아');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy08', 4, 6.2, '알라뷰');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy08', 5, 4.2, '헐 맛있어..');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy08', 6, 9.2, '으으 졸려');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy08', 7, 8.8, '시원하니 좋구만');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy08', 8, 9.2, '알라뷰 쏘마치');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy08', 9, 2.2, '굳뜨!!');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy08', 10, 4.4, '난 이게 좋아');

INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy09', 1, 9.2, '굳');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy09', 2, 10, '감사합니다!');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy09', 3, 4.2, '맛이 좋아');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy09', 4, 6.2, '알라뷰');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy09', 5, 4.2, '난 맛있는데');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy09', 6, 9.2, '오늘 날씨 좋네');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy09', 7, 8.8, '음료 맛이 끝내줘요');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy09', 8, 9.2, '굳~.~');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy09', 9, 2.2, '굳뜨!!');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy09', 10, 4.4, '맛있다...');

INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy10', 1, 1.2, '별로..');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy10', 2, 2, '별로예요!!');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy10', 3, 1.2, '맛이 좋아');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy10', 4, 6.2, '먹을만 하네');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy10', 5, 7.2, '맛있는데??');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy10', 6, 2.2, '에에엑 안 먹어');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy10', 7, 9.8, '이게 제일 맛있어');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy10', 8, 4.2, '오우예~');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy10', 9, 5.2, '맛은 있네~');
INSERT INTO t_comment (user_id, product_id, rating, comment) VALUES ('ssafy10', 10, 2.8, '난 이게 좋당게');






INSERT INTO t_order (user_id, order_table, order_time, completed) VALUES ('ssafy01', 'order_table 01', '2022-05-22', 'Y');
INSERT INTO t_order_detail (order_id, product_id, quantity) VALUES (11, 1, 2);
INSERT INTO t_order_detail (order_id, product_id, quantity) VALUES (11, 2, 4);
INSERT INTO t_order_detail (order_id, product_id, quantity) VALUES (11, 3, 5);
INSERT INTO t_stamp (user_id, order_id, quantity) VALUES ('ssafy01', 11, 11);
INSERT INTO t_order (user_id, order_table, order_time, completed) VALUES ('ssafy01', 'order_table 01', '2022-05-23', 'Y');
INSERT INTO t_order_detail (order_id, product_id, quantity) VALUES (12, 5, 1);
INSERT INTO t_order_detail (order_id, product_id, quantity) VALUES (12, 6, 5);
INSERT INTO t_stamp (user_id, order_id, quantity) VALUES ('ssafy01', 12, 6);
INSERT INTO t_order (user_id, order_table, order_time, completed) VALUES ('ssafy01', 'order_table 01', '2022-05-24', 'Y');
INSERT INTO t_order_detail (order_id, product_id, quantity) VALUES (13, 7, 2);
INSERT INTO t_order_detail (order_id, product_id, quantity) VALUES (13, 8, 2);
INSERT INTO t_stamp (user_id, order_id, quantity) VALUES ('ssafy01', 13, 4);

INSERT INTO t_order (user_id, order_table, order_time, completed) VALUES ('ssafy02', 'order_table 01', '2022-05-19', 'Y');
INSERT INTO t_order_detail (order_id, product_id, quantity) VALUES (14, 9, 1);
INSERT INTO t_order_detail (order_id, product_id, quantity) VALUES (14, 10, 1);
INSERT INTO t_order_detail (order_id, product_id, quantity) VALUES (14, 1, 1);
INSERT INTO t_stamp (user_id, order_id, quantity) VALUES ('ssafy02', 11, 3);
INSERT INTO t_order (user_id, order_table, order_time, completed) VALUES ('ssafy02', 'order_table 01', '2022-05-20', 'Y');
INSERT INTO t_order_detail (order_id, product_id, quantity) VALUES (15, 2, 3);
INSERT INTO t_order_detail (order_id, product_id, quantity) VALUES (15, 3, 1);
INSERT INTO t_stamp (user_id, order_id, quantity) VALUES ('ssafy02', 12, 4);
INSERT INTO t_order (user_id, order_table, order_time, completed) VALUES ('ssafy02', 'order_table 01', '2022-05-18', 'Y');
INSERT INTO t_order_detail (order_id, product_id, quantity) VALUES (16, 4, 2);
INSERT INTO t_stamp (user_id, order_id, quantity) VALUES ('ssafy02', 13, 2);

INSERT INTO t_order (user_id, order_table, order_time, completed) VALUES ('ssafy03', 'order_table 01', '2022-05-18', 'Y');
INSERT INTO t_order_detail (order_id, product_id, quantity) VALUES (17, 5, 1);
INSERT INTO t_order_detail (order_id, product_id, quantity) VALUES (17, 6, 1);
INSERT INTO t_order_detail (order_id, product_id, quantity) VALUES (17, 7, 1);
INSERT INTO t_stamp (user_id, order_id, quantity) VALUES ('ssafy03', 11, 3);
INSERT INTO t_order (user_id, order_table, order_time, completed) VALUES ('ssafy03', 'order_table 01', '2022-05-29', 'Y');
INSERT INTO t_order_detail (order_id, product_id, quantity) VALUES (18, 8, 5);
INSERT INTO t_order_detail (order_id, product_id, quantity) VALUES (18, 9, 10);
INSERT INTO t_stamp (user_id, order_id, quantity) VALUES ('ssafy03', 12, 15);
INSERT INTO t_order (user_id, order_table, order_time, completed) VALUES ('ssafy03', 'order_table 01', '2022-05-20', 'Y');
INSERT INTO t_order_detail (order_id, product_id, quantity) VALUES (19, 10, 5);
INSERT INTO t_stamp (user_id, order_id, quantity) VALUES ('ssafy03', 13, 5);

commit;