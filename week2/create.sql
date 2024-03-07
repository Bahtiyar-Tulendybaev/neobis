CREATE DATABASE week2;
USE week2;
CREATE TABLE "category" (
                              "id" BIGSERIAL NOT NULL,
                              "name" varchar(128) NOT NULL,
                              PRIMARY KEY ("id")
);

CREATE TABLE "product" (
                            "id" BIGSERIAL NOT NULL,
                            "name" varchar(128) NOT NULL,
                            "image" varchar(128) NOT NULL,
                            "description" varchar NOT NULL,
                            "price" int NOT NULL,
                            "category_id" BIGSERIAL NOT NULL ,
                            PRIMARY KEY ("id"),
                            CONSTRAINT "fk_product_category"
                                FOREIGN KEY ("category_id")
                                    REFERENCES "category" ("id")
);

CREATE TABLE "customer" (
                             "id" BIGSERIAL NOT NULL,
                             "name" varchar NOT NULL,
                             PRIMARY KEY ("id")

);

CREATE TABLE "order"(
                         "id" BIGSERIAL NOT NULL,
                         PRIMARY KEY ("id"),
                         "quantity" int NOT NULL,
                         "price" int NOT NULL ,
                         "customer_id" BIGSERIAL NOT NULL ,
                         CONSTRAINT "fk_orders_customers"
                             FOREIGN KEY ("customer_id")
                                 REFERENCES "customer" ("id"),
                         "product_id" BIGSERIAL NOT NULL ,
                         CONSTRAINT "fk_orders_products"
                             FOREIGN KEY ("product_id")
                                 REFERENCES "product" ("id")

);

INSERT INTO "category" ("name")
VALUES
    ('Smartphones'),
    ('Laptops')

;

INSERT INTO "product" ("name", "image", "description","price", "category_id")
values ('Iphone 14 Pro Max', '14 pro .jpg',  'Чип A16 Bionic — сверхбыстрый и сверхэффективный, обеспечивающий удивительное время автономной работы в течение всего дня.', 1500, 1),
       ('Iphone 14 Plus','14Plus.jpg','Великолепное время автономной работы в течение всего дня с возможностью воспроизведения видео до 20 часов.',1100,1),
       ('Iphone 14 Pro','14 pro Max.jpg','Основная камера 48 МП с усовершенствованным четырехпиксельным сенсором для увеличения разрешения до 4 раз.',950,1),
       ('Ноутбук Asus ROG Strix G15','10.jpg', 'Asus N7600PC-KV116W — ноутбук из серии Vivabook Pro. Его характерная особенность — 16-дюймовый экран, созданный на базе матрицы OLED. ', 1500,2),
       ('Ноутбук Asus TUF Gaming F15', '12.jpg', 'Лэптоп использует шестиядерный процессор Intel Core i5 11400H, видеокарту GeForce RTX 3060 с 6 Гб памяти, а также 16 Гб оперативной памяти DDR4.', 1100,2),
       ('Ноутбук Asus X409F', '17.jpeg', 'Диагональ экрана, выполненного по технологии IPS, составляет 17,3 дюйма. Его разрешение — 1920 х 1080 пикселей, частота обновления — 144 Гц.', 900,2);

INSERT INTO "customer" ("name")
VALUES
    ('John'),
    ('Aybek'),
    ('Bahtiyar')
;

INSERT INTO "order"("quantity", "price", "customer_id","product_id")
VALUES
     (20,1500,1,2),
     (10,1300,2,1),
     (10,1000,5,3)
;