-- 创建用户表
CREATE TABLE tb_user (
id INT PRIMARY KEY AUTO_INCREMENT,
username VARCHAR(18),
loginname VARCHAR(18),
PASSWORD VARCHAR (18),
phone VARCHAR (18),
address VARCHAR (18)
);
-- 插入用户表测试数据
INSERT INTO tb_user (username,loginname,PASSWORD,phone,address)
VALUES('马云','jack','123456','13600000000','杭州');
-- 创建商品表
CREATE TABLE tb_article(
id INT PRIMARY KEY AUTO_INCREMENT,
NAME VARCHAR (18),
price DOUBLE,
remark VARCHAR (18)
);
-- 插入商品表测试数据
INSERT INTO tb_article(NAME,price,remark)
VALUES('精通Python自然语言处理',108.9,'经典著作');
INSERT INTO tb_article(NAME,price,remark)
VALUES('自然语言处理原理与实践',99.9,'经典著作');
INSERT INTO tb_article(NAME,price,remark)
VALUES('大数据架构详解',89.9,'经典著作');
INSERT INTO tb_article(NAME,price,remark)
VALUES('推荐系统实践',69.9,'经典著作');
-- 创建订单表
CREATE TABLE tb_order(
id INT PRIMARY KEY AUTO_INCREMENT,
CODE VARCHAR(32),
total DOUBLE,
user_id INT,
FOREIGN KEY (user_id) REFERENCES tb_user(id)
);
-- 插入订单表测试数据
INSERT INTO tb_order (CODE,total,user_id)
VALUES('20180315ORDER1212',388.6,1);
INSERT INTO tb_order(CODE,total,user_id)
VALUES('20180315ORDER1213',217.8,1);
-- 创建中间表
CREATE TABLE tb_item(
order_id INT,
article_id INT,
amount INT,
PRIMARY KEY (order_id,article_id),
FOREIGN KEY (order_id) REFERENCES tb_order(id),
FOREIGN KEY (article_id) REFERENCES tb_article(id)
);
-- 创建插入中间表数据
INSERT INTO tb_item(order_id,article_id,amount)
VALUES(1,1,1);
INSERT INTO tb_item(order_id,article_id,amount)
VALUES(1,2,1);
INSERT INTO tb_item(order_id,article_id,amount)
VALUES(1,3,2);
INSERT INTO tb_item(order_id,article_id,amount)
VALUES(2,4,2);
INSERT INTO tb_item(order_id,article_id,amount)
VALUES(2,1,1);