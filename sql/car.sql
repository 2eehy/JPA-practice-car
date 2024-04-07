CREATE TABLE IF NOT EXISTS car
(
    car_code    INT AUTO_INCREMENT COMMENT '차량코드',
    car_name    VARCHAR(30) NOT NULL COMMENT '차량명',
    car_price    INT NOT NULL COMMENT '차량가격',
    category_code    INT NOT NULL COMMENT '카테고리코드',
    orderable_status    CHAR(1) NOT NULL COMMENT '주문가능상태',
    PRIMARY KEY (car_code),
    FOREIGN KEY (category_code) REFERENCES car_category (category_code)
    ) ENGINE=INNODB COMMENT '차량';

INSERT INTO car VALUES (null, '아반떼',3000 ,1 , 'Y');
INSERT INTO car VALUES (null, '소나타', 4000, 1, 'Y');
INSERT INTO car VALUES (null, '그랜져', 5000, 1, 'Y');

INSERT INTO car VALUES (null, '투싼', 3000, 2, 'Y');
INSERT INTO car VALUES (null, '싼타페', 4000, 2, 'Y');
INSERT INTO car VALUES (null, '펠리세이드', 4500, 2, 'Y');
INSERT INTO car VALUES (null, '포터', 2000, 3, 'Y');

select*from car;
select * from car_category;