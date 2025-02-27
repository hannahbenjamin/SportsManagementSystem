
--INSERT INTO departments (code, name, contactEmail) VALUES ('MIE', 'Mechanical and Industrial Engineering', 'reception@mie.utoronto.ca');
--INSERT INTO departments (code, name, contactEmail) VALUES ('ECE', 'Electrical and Computer Engineering', 'eceinquiry@utoronto.ca');
--INSERT INTO departments (code, name, contactEmail) VALUES ('MSE', 'Materials Science and Engineering', 'materials.engineering@utoronto.ca');
--
--INSERT INTO students (id, firstName, lastName, email, initials) VALUES (1111, 'Tyrion', 'Lannister', 'tyrion.lannister@mail.univ.ca', 'T.L.');
--INSERT INTO students (id, firstName, lastName, email, initials) VALUES (2222, 'Cersei', 'Lannister', 'cersei.lannister@mail.univ.ca', 'C.L.');
--INSERT INTO students (id, firstName, lastName, email) VALUES (3333, 'Jaime', 'Lannister', 'jaime.lannister@mail.univ.ca');
--INSERT INTO students (id, firstName, lastName, email) VALUES (4444, 'Daenerys', 'Targaryen', 'jaime.targaryen@mail.univ.ca');
--INSERT INTO students (id, firstName, lastName, email) VALUES (5555, 'Jon', 'Snow', 'jon.snow@mail.univ.ca');
--
--INSERT INTO professors (id, firstName, lastName, email, office, salary) VALUES (1122, 'Sansa', 'Stark', 'sansa.stark@univ.ca', 'BA1234', 50000);
--INSERT INTO professors (id, firstName, lastName, email, office, salary) VALUES (3344, 'Arya', 'Stark', 'arya.stark@univ.ca', 'MC1234', 70000);
--INSERT INTO professors (id, firstName, lastName, email, office, salary) VALUES (5566, 'Jorah', 'Mormont', 'jorah.mormont@univ.ca', 'MY1234', 60000);
--
--INSERT INTO courses (code, name, professorId) VALUES ('GOT123', 'A Game of Thrones', 1122);
--INSERT INTO courses (code, name, professorId) VALUES ('GOT456', 'A Clash of Kings', 3344);
--INSERT INTO courses (code, name, professorId) VALUES ('GOT789', 'A Storm of Swords', 5566);
--
--INSERT INTO marks(studentId, courseCode, mark) VALUES(1111, 'GOT123', 80);
--INSERT INTO marks(studentId, courseCode, mark) VALUES(2222, 'GOT123', 85);
--INSERT INTO marks(studentId, courseCode, mark) VALUES(3333, 'GOT456', 90);
--INSERT INTO marks(studentId, courseCode, mark) VALUES(4444, 'GOT456', 95);
--INSERT INTO marks(studentId, courseCode, mark) VALUES(5555, 'GOT789', 100);
--INSERT INTO marks(studentId, courseCode, mark) VALUES(5555, 'GOT123', 80);
--INSERT INTO marks(studentId, courseCode, mark) VALUES(5555, 'GOT456', 90);

-- Users (Players by default)
INSERT INTO users (userID, firstName, lastName, email, password, role) VALUES
(1, 'John', 'Doe', 'john.doe@email.com', 'hashed_password', 'player'),
(2, 'Jane', 'Smith', 'jane.smith@email.com', 'hashed_password', 'player');

-- Captains
INSERT INTO captains (captainID) VALUES (1);

-- Admins
INSERT INTO admins (adminID) VALUES (2);

-- Sports
INSERT INTO sports (sportID, sportName, teamSize) VALUES
(1, 'Basketball', 5),
(2, 'Soccer', 11);

-- Divisions
INSERT INTO divisions (divisionID, divisionName) VALUES
(1, 'Division A'),
(2, 'Division B');

-- Teams
INSERT INTO teams (teamID, teamName, teamCapacity, sportID, divisionID, ranking) VALUES
('T001', 'Eagles', 10, 1, 1, '1st'),
('T002', 'Tigers', 10, 1, 1, '2nd');

-- Games
INSERT INTO games (gameID, datetime, location, teamID1, teamID2, team1score, team2score, gameStatus, sportID, divisionID) VALUES
(101, '2025-03-15 18:00:00', 'Gym A', 'T001', 'T002', 50, 45, 'Completed', 1, 1);
