/** Cafe Category **/
INSERT INTO cafe_category (id, name) VALUES (1,'게임'),(2,'만화/애니메이션'),(3,'방송/연예'),(4,'문화/예술'),(5,'영화'),(6,'음악'),(7,'팬카페'),(8,'여행'),(9,'스포츠/레저'),(10,'애완동물'),(11,'취미'),(12,'생활'),(13,'패션/미용'),(14,'건강/다이어트'),(15,'가족/육아'),(16,'컴퓨터/통신'),(17,'교육'),(18,'외국어'),(19,'인문/과학'),(20,'경제/금융'),(21,'정치/사회'),(22,'문학/창작'),(23,'동창/동문'),(24,'친목/모임'),(25,'종교/봉사');

/** Cafe **/
INSERT INTO cafe (id, category_id, domain, name, description, created_at) VALUES (1, 1, 'first', 'first test', 'first test desc', '2014-11-10 00:00:00');
INSERT INTO cafe (id, category_id, domain, name, description, created_at) VALUES (2, 1, 'next', 'next test', 'next test desc', '2014-11-11 00:00:00');

/** Member **/
INSERT INTO member (id, nickname) VALUES (1, 'CafeOne');

/** Role **/
INSERT INTO role (id, cafe_id, role) VALUES (1,1,0),(2,1,1),(3,1,2);
/** Cafe Member **/
INSERT INTO cafe_member (member_id, cafe_id, joined_at, role_id) VALUES (1, 1, '2011-11-21 00:00:00', 1);

/** Board **/
INSERT INTO board (id, cafe_id, title, description, type, created_at) VALUES (1, 1, 'test board', 'test board', 'GENERAL', '2014-11-10 00:00:00');

/** Article **/
INSERT INTO article (id, board_id, member_id, title, content, created_at, read_count, recommend_count) VALUES (1, 1, 1, 'test article', 'test content', '2014-11-10 00:00:00', 60, 61);