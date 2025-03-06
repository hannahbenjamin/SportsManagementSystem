
INSERT INTO captains (userID, firstName, lastName, email, password, role)
VALUES (1, 'John', 'Doe', 'john.doe@example.com', 'password123', 'captain'),
       (2, 'Jane', 'Smith', 'jane.smith@example.com', 'securepass', 'captain'),
       (3, 'Alice', 'Johnson', 'alice.johnson@example.com', 'referee456', 'captain'),
       (4, 'Bob', 'Williams', 'bob.williams@example.com', 'adminpass', 'captain'),
       (5, 'Charlie', 'Brown', 'charlie.brown@example.com', 'playerpass', 'captain');

INSERT INTO admins (userID, firstName, lastName, email, password, role)
VALUES (6, 'Admin', 'User', 'admin@example.com', 'adminpassword', 'admin'),
       (7, 'Super', 'Admin', 'superadmin@example.com', 'superadminpass', 'admin');

INSERT INTO players (userID, firstName, lastName, email, password, role)
VALUES (8, 'Player', 'One', 'player1@example.com', 'player1pass', 'player'),
       (9, 'Player', 'Two', 'player2@example.com', 'player2pass', 'player'),
       (10, 'Player', 'Three', 'player3@example.com', 'player3pass', 'player');

INSERT INTO referees (userID, firstName, lastName, email, password, role)
VALUES (11, 'Referee', 'One', 'ref1@example.com', 'ref1pass', 'referee'),
       (12, 'Referee', 'Two', 'ref2@example.com', 'ref2pass', 'referee'),
       (13, 'Referee', 'Three', 'ref3@example.com', 'ref3pass', 'referee');