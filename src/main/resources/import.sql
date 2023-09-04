
/* Crear rankings */
INSERT INTO ufc.ranking VALUES (1, "Flyweight ", 125);
INSERT INTO ufc.ranking VALUES (2, "Bantamweight", 135);
INSERT INTO ufc.ranking VALUES (3, "Featherweight", 145);
INSERT INTO ufc.ranking VALUES (4, "Lightweight", 155);
INSERT INTO ufc.ranking VALUES (5, "Welterweight", 170);
INSERT INTO ufc.ranking VALUES (6, "Middleweight", 185);
INSERT INTO ufc.ranking VALUES (7, "Light heavyweight", 205);
INSERT INTO ufc.ranking VALUES (8, "Heavyweight", 265);

/* Peleadores de Flyweight */
INSERT INTO ufc.fighter (id, name, nickname, surname, weight, height, date_of_birth, age, reach, leg_reach, nationality, win_fights, lost_fights, draw_fights, record, ranking_id, ranking_number) VALUES (1, "Alexandre", "THE CANNIBAL", "Pantoja", 125, 65, "1990-05-16", 33, 67, 36.5, "RIO DE JANEIRO, BRASIL", 26, 5, 0, "26-5-0", "1", "0");
INSERT INTO ufc.fighter (id, name, nickname, surname, weight, height, date_of_birth, age, reach, leg_reach, nationality, win_fights, lost_fights, draw_fights, record, ranking_id, ranking_number) VALUES (2, "Brandon", "THE ASSASSIN BABY", "Moreno", 125, 67, "1993-12-07", 29, 70, 38, "TIJUANA, MÉXICO", 21, 7, 2, "21-7-2", "1", "1");
INSERT INTO ufc.fighter (id, name, nickname, surname, weight, height, date_of_birth, age, reach, leg_reach, nationality, win_fights, lost_fights, draw_fights, record, ranking_id, ranking_number) VALUES (3, "Deiveson", "DEUS DA GUERRA", "Figueiredo", 125, 65, "1987-12-18", 35, 68, 38, "SOURE, BRASIL", 21, 3, 1, "21-3-1", "1", "2");
INSERT INTO ufc.fighter (id, name, nickname, surname, weight, height, date_of_birth, age, reach, leg_reach, nationality, win_fights, lost_fights, draw_fights, record, ranking_id, ranking_number) VALUES (4, "Amir", "THE PRINCE", "Albazi", 125, 65, "1993-09-27", 29, 68, 38, "BAGHDAD, IRAK", 17, 1, 0, "17-1-0", "1", "3");
INSERT INTO ufc.fighter (id, name, nickname, surname, weight, height, date_of_birth, age, reach, leg_reach, nationality, win_fights, lost_fights, draw_fights, record, ranking_id, ranking_number) VALUES (5, "Brandon", "RAW DAWG", "Royval", 125, 69, "1992-08-06", 30, 68, 38.5, "DENVER, ESTADOS UNIDOS", 15, 6, 0, "15-6-0", "1", "4");
INSERT INTO ufc.fighter (id, name, nickname, surname, weight, height, date_of_birth, age, reach, leg_reach, nationality, win_fights, lost_fights, draw_fights, record, ranking_id, ranking_number) VALUES (6, "Kai Kara-France", "DON'T BLINK", "", 125, 64, "1993-03-26", 30, 69, 37, "AUCKLAND, NUEVA ZELANDA", 24, 11, 0, "24-11-0", "1", "5");

/* Peleadores de Bantamweight */
INSERT INTO ufc.fighter (id, name, nickname, surname, weight, height, date_of_birth, age, reach, leg_reach, nationality, win_fights, lost_fights, draw_fights, record, ranking_id, ranking_number) VALUES (7, "Sean", "SUGAR", "O'Malley", 135, 71, "1994-09-24", 28, 72, 40, "HELENA, ESTADOS UNIDOS", 17, 1, 0, "17-1-0", "2", "0");
INSERT INTO ufc.fighter (id, name, nickname, surname, weight, height, date_of_birth, age, reach, leg_reach, nationality, win_fights, lost_fights, draw_fights, record, ranking_id, ranking_number) VALUES (8, "Aljamain", "FUNK MASTER", "Sterling", 125, 67, "1989-07-31", 34, 71, 39, "ESTADOS UNIDOS", 23, 4, 0, "23-4-0", "2", "1");
INSERT INTO ufc.fighter (id, name, nickname, surname, weight, height, date_of_birth, age, reach, leg_reach, nationality, win_fights, lost_fights, draw_fights, record, ranking_id, ranking_number) VALUES (9, "Merab", "THE MACHINE", "Dvalishvili", 125, 66, "1991-01-10", 32, 68, 38, "TBILISI, GEORGIA", 16, 4, 0, "16-4-0", "2", "2");