INSERT INTO COLOR (id, name) VALUES (1, 'orange');
INSERT INTO COLOR (id, name) VALUES (2, 'black');
INSERT INTO COLOR (id, name) VALUES (3, 'white');
INSERT INTO COLOR (id, name) VALUES (4, 'blue');
INSERT INTO COLOR (id, name) VALUES (5, 'red');
INSERT INTO COLOR (id, name) VALUES (6, 'navy');

INSERT INTO HEAD_COACH (id, first_name, last_name, wins, losses, ties)
VALUES (1, 'zac', 'taylor', 33, 38, 1);
INSERT INTO HEAD_COACH (id, first_name, last_name, wins, losses, ties)
VALUES (2, 'sean', 'mcdermott', 66, 40, 0);
INSERT INTO HEAD_COACH (id, first_name, last_name, wins, losses, ties)
VALUES (3, 'bill', 'belichick', 329, 165, 0);

INSERT INTO LOCATION (id, city, state, state_code, zip_code)
VALUES (1, 'cincinnati', 'ohio', 'oh', '45202');
INSERT INTO LOCATION (id, city, state, state_code, zip_code)
VALUES (2, 'buffalo', 'new york', 'ny', '14127');
INSERT INTO LOCATION (id, city, state, state_code, zip_code)
VALUES (3, 'new england', 'massachusetts', 'ma', '02035');

INSERT INTO TEAM (id, name, established_date, stadium, fight_song, mascot, location_id, head_coach_id)
VALUES (1, 'bengals', '1967-05-23', 'paycor stadium', 'the bengals growl', 'who dey', 1, 1);
INSERT INTO TEAM (id, name, established_date, stadium, fight_song, mascot, location_id, head_coach_id)
VALUES (2, 'bills', '1959-10-28', 'highmark stadium', 'shout', 'billy buffalo', 2, 2);
INSERT INTO TEAM (id, name, established_date, stadium, fight_song, mascot, location_id, head_coach_id)
VALUES (3, 'patriots', '1959-11-16', 'gillette stadium', 'i''m shipping up to boston', 'pat patriot', 3, 3);

INSERT INTO TEAM_COLORS (team_id, colors_id)
VALUES  (1, 1);
INSERT INTO TEAM_COLORS (team_id, colors_id)
VALUES  (1, 2);
INSERT INTO TEAM_COLORS (team_id, colors_id)
VALUES  (1, 3);
INSERT INTO TEAM_COLORS (team_id, colors_id)
VALUES  (2, 3);
INSERT INTO TEAM_COLORS (team_id, colors_id)
VALUES  (2, 4);
INSERT INTO TEAM_COLORS (team_id, colors_id)
VALUES  (2, 5);
INSERT INTO TEAM_COLORS (team_id, colors_id)
VALUES  (3, 3);
INSERT INTO TEAM_COLORS (team_id, colors_id)
VALUES  (3, 5);
INSERT INTO TEAM_COLORS (team_id, colors_id)
VALUES  (3, 6);






