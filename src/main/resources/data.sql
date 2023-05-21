INSERT INTO authorities(id, authority) VALUES (1, 'ADMIN');
INSERT INTO authorities(id, authority) VALUES (2, 'USER');

INSERT INTO users(personnel_number, enabled, first_name, last_name, password) VALUES ('451234', 1, 'James', 'Hetfield', '$2a$10$yoSiCKt7y4A5Eo.epwWV5ubWseP.pzwg5mSp7nmMmqNHwO1cIdy4m');
INSERT INTO users(personnel_number, enabled, first_name, last_name, password) VALUES ('123456', 1, 'Kirk', 'Hammet', '$2a$10$yoSiCKt7y4A5Eo.epwWV5ubWseP.pzwg5mSp7nmMmqNHwO1cIdy4m');

INSERT INTO user_authority(user_id, authority_id) VALUES ('451234', (SELECT id FROM authorities WHERE authority = 'ADMIN'));
INSERT INTO user_authority(user_id, authority_id) VALUES ('451234', (SELECT id FROM authorities WHERE authority = 'USER'));
