/** Cafe Category **/
INSERT INTO cafe_category (id, name) VALUES (1,'게임'),(2,'만화/애니메이션'),(3,'방송/연예'),(4,'문화/예술'),(5,'영화'),(6,'음악'),(7,'팬카페'),(8,'여행'),(9,'스포츠/레저'),(10,'애완동물'),(11,'취미'),(12,'생활'),(13,'패션/미용'),(14,'건강/다이어트'),(15,'가족/육아'),(16,'컴퓨터/통신'),(17,'교육'),(18,'외국어'),(19,'인문/과학'),(20,'경제/금융'),(21,'정치/사회'),(22,'문학/창작'),(23,'동창/동문'),(24,'친목/모임'),(25,'종교/봉사');

/** Cafe **/
INSERT INTO cafe (id, category_id, domain, name, description, create_datetime, update_datetime) VALUES (1, 1, 'first', 'first test', 'first test desc', '2014-11-10 00:00:00', CURRENT_TIMESTAMP);
INSERT INTO cafe (id, category_id, domain, name, description, create_datetime, update_datetime) VALUES (2, 1, 'next', 'next test', 'next test desc', '2014-11-11 00:00:00', CURRENT_TIMESTAMP);
INSERT INTO cafe (id, category_id, domain, name, description, create_datetime, update_datetime) VALUES (3, 2, 'comics', 'comicbook cafe', 'comics', '2015-03-16 11:01:21', CURRENT_TIMESTAMP);

/** User **/
INSERT INTO user (id, username, password, enabled) VALUES (1, 'member', 'testtest', 1);
INSERT INTO user_role(username, role) VALUES ('member', 'ROLE_USER');
INSERT INTO user (id, username, password, enabled) VALUES (2, 'user', '1234', 1);
INSERT INTO user_role(username, role) VALUES ('user', 'ROLE_USER');

/** Cafe User **/
INSERT INTO cafe_user (cafe_id, user_id, create_datetime, role) VALUES (1, 1, '2011-11-21 00:00:00', 'MANAGER');
INSERT INTO cafe_user (cafe_id, user_id, create_datetime, role) VALUES (2, 1, '2011-11-21 00:00:00', 'MANAGER');
INSERT INTO cafe_user (cafe_id, user_id, create_datetime, role) VALUES (3, 1, '2015-03-21 00:00:00', 'MANAGER');

/** Board **/
INSERT INTO board (id, cafe_id, title, description, type, create_datetime) VALUES (1, 1, 'test board', 'test board', 'GENERAL', '2014-11-10 00:00:00');
INSERT INTO board (cafe_id, title, description, type, create_datetime) VALUES (1, 'test board 2', 'test board 2', 'GENERAL', '2015-01-10 00:00:00');
INSERT INTO board (cafe_id, title, description, type, create_datetime) VALUES (1, 'test board 3', 'test board 3', 'GENERAL', '2015-02-10 00:00:00');
INSERT INTO board (cafe_id, title, description, type, create_datetime) VALUES (1, 'test board 4', 'test board 4', 'GENERAL', '2015-03-10 00:00:00');
INSERT INTO board (id, cafe_id, title, description, type, create_datetime) VALUES (10, 2, 'test board 4', 'test board 4', 'GENERAL', '2015-03-10 00:00:00');


/** Article **/
INSERT INTO article (id, board_id, user_id, title, content, create_datetime, read_count, recommend_count) VALUES (1, 1, 1, 'test article', 'test content', '2014-11-10 00:00:00', 60, 61);
INSERT INTO article (id, board_id, user_id, title, content, create_datetime, read_count, recommend_count) VALUES (2, 1, 1, 'test article 2', 'test content very short', '2015-03-10 00:00:00', 0, 0);
INSERT INTO article (board_id, user_id, title, content, create_datetime, read_count, recommend_count) VALUES (1, 1, 'test article 2', 'test content very short', CURRENT_TIMESTAMP, 0, 0);
INSERT INTO article (board_id, user_id, title, content, create_datetime, read_count, recommend_count) VALUES (1, 1, 'test article 2', 'test content very short', CURRENT_TIMESTAMP, 0, 0);
INSERT INTO article (board_id, user_id, title, content, create_datetime, read_count, recommend_count) VALUES (1, 1, 'test article 2', 'test content very short', CURRENT_TIMESTAMP, 0, 0);
INSERT INTO article (board_id, user_id, title, content, create_datetime, read_count, recommend_count) VALUES (1, 1, 'test article 2', 'test content very short', CURRENT_TIMESTAMP, 0, 0);
INSERT INTO article (board_id, user_id, title, content, create_datetime, read_count, recommend_count) VALUES (1, 1, 'test article 2', 'test content very short', CURRENT_TIMESTAMP, 0, 0);
INSERT INTO article (board_id, user_id, title, content, create_datetime, read_count, recommend_count) VALUES (1, 1, 'test article 2', 'test content very short', CURRENT_TIMESTAMP, 0, 0);
INSERT INTO article (board_id, user_id, title, content, create_datetime, read_count, recommend_count) VALUES (1, 1, 'test article 2', 'test content very short', CURRENT_TIMESTAMP, 0, 0);
INSERT INTO article (board_id, user_id, title, content, create_datetime, read_count, recommend_count) VALUES (1, 1, 'test article 2', 'test content very short', CURRENT_TIMESTAMP, 0, 0);
INSERT INTO article (board_id, user_id, title, content, create_datetime, read_count, recommend_count) VALUES (1, 1, 'test article 2', 'test content very short', CURRENT_TIMESTAMP, 0, 0);
INSERT INTO article (board_id, user_id, title, content, create_datetime, read_count, recommend_count) VALUES (1, 1, 'test article 2', 'test content very short', CURRENT_TIMESTAMP, 0, 0);
INSERT INTO article (board_id, user_id, title, content, create_datetime, read_count, recommend_count) VALUES (1, 1, 'test article 2', 'test content very short', CURRENT_TIMESTAMP, 0, 0);
INSERT INTO article (board_id, user_id, title, content, create_datetime, read_count, recommend_count) VALUES (1, 1, 'test article 2', 'test content very short', CURRENT_TIMESTAMP, 0, 0);
INSERT INTO article (board_id, user_id, title, content, create_datetime, read_count, recommend_count) VALUES (1, 1, 'test article 2', 'test content very short', CURRENT_TIMESTAMP, 0, 0);
INSERT INTO article (board_id, user_id, title, content, create_datetime, read_count, recommend_count) VALUES (1, 1, 'test article 2', 'test content very short', CURRENT_TIMESTAMP, 0, 0);
INSERT INTO article (board_id, user_id, title, content, create_datetime, read_count, recommend_count) VALUES (1, 1, 'test article 2', 'test content very short', CURRENT_TIMESTAMP, 0, 0);
INSERT INTO article (board_id, user_id, title, content, create_datetime, read_count, recommend_count) VALUES (1, 1, 'test article 2', 'test content very short', CURRENT_TIMESTAMP, 0, 0);
INSERT INTO article (board_id, user_id, title, content, create_datetime, read_count, recommend_count) VALUES (1, 1, 'test article 2', 'test content very short', CURRENT_TIMESTAMP, 0, 0);
INSERT INTO article (board_id, user_id, title, content, create_datetime, read_count, recommend_count) VALUES (1, 1, 'test article 2', 'test content very short', CURRENT_TIMESTAMP, 0, 0);
INSERT INTO article (board_id, user_id, title, content, create_datetime, read_count, recommend_count) VALUES (1, 1, 'test article 2', 'test content very short', CURRENT_TIMESTAMP, 0, 0);
INSERT INTO article (board_id, user_id, title, content, create_datetime, read_count, recommend_count) VALUES (1, 1, 'test article 2', 'test content very short', CURRENT_TIMESTAMP, 0, 0);
INSERT INTO article (board_id, user_id, title, content, create_datetime, read_count, recommend_count) VALUES (1, 1, 'test article 2', 'test content very short', CURRENT_TIMESTAMP, 0, 0);
INSERT INTO article (board_id, user_id, title, content, create_datetime, read_count, recommend_count) VALUES (1, 1, 'test article 2', 'test content very short', CURRENT_TIMESTAMP, 0, 0);
INSERT INTO article (board_id, user_id, title, content, create_datetime, read_count, recommend_count) VALUES (1, 1, 'test article 2', 'test content very short', CURRENT_TIMESTAMP, 0, 0);
INSERT INTO article (board_id, user_id, title, content, create_datetime, read_count, recommend_count) VALUES (10, 1, 'cafe 2.test article 1', 'test content very short', CURRENT_TIMESTAMP, 0, 0);

/** Comment **/
INSERT INTO comment (content, article_id, user_id, create_date) VALUES ('test comment', 1, 1, '2014-11-21 00:00:00'),('test comment22', 1, 1, '2014-11-21 01:00:00'),('test comment333', 1, 1, '2014-11-21 02:00:00'),('test comment44', 1, 1, '2014-11-21 00:00:00'),('test comment54', 1, 1, '2014-11-21 00:00:00'),('test comment6', 1, 1, '2014-11-21 00:00:00'),('test comment7', 1, 1, '2014-11-21 00:00:00'),('test comment8', 1, 1, '2014-11-21 00:00:00'),('test comment9', 1, 1, '2014-11-21 00:00:00'),('test comment10', 1, 1, '2014-11-21 00:00:00'),('test comment11', 1, 1, '2014-11-21 00:00:00')
