CREATE TABLE Users (
    User_ID INT AUTO_INCREMENT PRIMARY KEY,
    Username VARCHAR(255) NOT NULL,
    Password VARCHAR(255) NOT NULL,
    Email VARCHAR(255) NOT NULL,
    UserType ENUM('Student', 'Instructor', 'Admin') NOT NULL
);

--
-- Dumping data for table `Users`
--

INSERT INTO Users (Username, Password, Email, UserType)
VALUES
    ('user1', 'password1', 'user1@umd.edu', 'Admin'),
    ('user2', 'password2', 'user2@umd.edu', 'Admin'),
    ('user3', 'password3', 'user3@umd.edu', 'Instructor'),
    ('user4', 'password4', 'user4@umd.edu', 'Instructor'),
    ('user5', 'password5', 'user5@umd.edu', 'Instructor'),
    ('user6', 'password6', 'user6@umd.edu', 'Instructor'),
    ('user7', 'password7', 'user7@umd.edu', 'Instructor'),
    ('user8', 'password8', 'user8@umd.edu', 'Instructor'),
    ('user9', 'password9', 'user9@umd.edu', 'Instructor'),
    ('user10', 'password10', 'user10@umd.edu', 'Instructor'),
    ('user11', 'password11', 'user11@umd.edu', 'Student'),
    ('user12', 'password12', 'user12@umd.edu', 'Student'),
    ('user13', 'password13', 'user13@umd.edu', 'Student'),
    ('user14', 'password14', 'user14@umd.edu', 'Student'),
    ('user15', 'password15', 'user15@umd.edu', 'Student'),
    ('user16', 'password16', 'user16@umd.edu', 'Student'),
    ('user17', 'password17', 'user17@umd.edu', 'Student'),
    ('user18', 'password18', 'user18@umd.edu', 'Student'),
    ('user19', 'password19', 'user19@umd.edu', 'Student'),
    ('user20', 'password20', 'user20@umd.edu', 'Student'),
    ('user21', 'password21', 'user21@umd.edu', 'Student'),
    ('user22', 'password22', 'user22@umd.edu', 'Student'),
    ('user23', 'password23', 'user23@umd.edu', 'Student'),
    ('user24', 'password24', 'user24@umd.edu', 'Student'),
    ('user25', 'password25', 'user25@umd.edu', 'Student'),
    ('user26', 'password26', 'user26@umd.edu', 'Student'),
    ('user27', 'password27', 'user27@umd.edu', 'Student'),
    ('user28', 'password28', 'user28@umd.edu', 'Student'),
    ('user29', 'password29', 'user29@umd.edu', 'Student'),
    ('user30', 'password30', 'user30@umd.edu', 'Student'),
    ('user31', 'password31', 'user31@umd.edu', 'Student'),
    ('user32', 'password32', 'user32@umd.edu', 'Student'),
    ('user33', 'password33', 'user33@umd.edu', 'Student'),
    ('user34', 'password34', 'user34@umd.edu', 'Student'),
    ('user35', 'password35', 'user35@umd.edu', 'Student'),
    ('user36', 'password36', 'user36@umd.edu', 'Student'),
    ('user37', 'password37', 'user37@umd.edu', 'Student'),
    ('user38', 'password38', 'user38@umd.edu', 'Student'),
    ('user39', 'password39', 'user39@umd.edu', 'Student'),
    ('user40', 'password40', 'user40@umd.edu', 'Student'),
    ('user41', 'password41', 'user41@umd.edu', 'Student'),
    ('user42', 'password42', 'user42@umd.edu', 'Student'),
    ('user43', 'password43', 'user43@umd.edu', 'Student'),
    ('user44', 'password44', 'user44@umd.edu', 'Student'),
    ('user45', 'password45', 'user45@umd.edu', 'Student'),
    ('user46', 'password46', 'user46@umd.edu', 'Student'),
    ('user47', 'password47', 'user47@umd.edu', 'Student'),
    ('user48', 'password48', 'user48@umd.edu', 'Student'),
    ('user49', 'password49', 'user49@umd.edu', 'Student'),
    ('user50', 'password50', 'user50@umd.edu', 'Student'),
    ('user51', 'password51', 'user51@umd.edu', 'Student'),
    ('user52', 'password52', 'user52@umd.edu', 'Student'),
    ('user53', 'password53', 'user53@umd.edu', 'Student'),
    ('user54', 'password54', 'user54@umd.edu', 'Student'),
    ('user55', 'password55', 'user55@umd.edu', 'Student'),
    ('user56', 'password56', 'user56@umd.edu', 'Student'),
    ('user57', 'password57', 'user57@umd.edu', 'Student'),
    ('user58', 'password58', 'user58@umd.edu', 'Student'),
    ('user59', 'password59', 'user59@umd.edu', 'Student'),
    ('user60', 'password60', 'user60@umd.edu', 'Student'),
    ('user61', 'password61', 'user61@umd.edu', 'Student'),
    ('user62', 'password62', 'user62@umd.edu', 'Student'),
    ('user63', 'password63', 'user63@umd.edu', 'Student'),
    ('user64', 'password64', 'user64@umd.edu', 'Student'),
    ('user65', 'password65', 'user65@umd.edu', 'Student'),
    ('user66', 'password66', 'user66@umd.edu', 'Student'),
    ('user67', 'password67', 'user67@umd.edu', 'Student'),
    ('user68', 'password68', 'user68@umd.edu', 'Student'),
    ('user69', 'password69', 'user69@umd.edu', 'Student'),
    ('user70', 'password70', 'user70@umd.edu', 'Student'),
    ('user71', 'password71', 'user71@umd.edu', 'Student'),
    ('user72', 'password72', 'user72@umd.edu', 'Student'),
    ('user73', 'password73', 'user73@umd.edu', 'Student'),
    ('user74', 'password74', 'user74@umd.edu', 'Student'),
    ('user75', 'password75', 'user75@umd.edu', 'Student'),
    ('user76', 'password76', 'user76@umd.edu', 'Student'),
    ('user77', 'password77', 'user77@umd.edu', 'Student'),
    ('user78', 'password78', 'user78@umd.edu', 'Student'),
    ('user79', 'password79', 'user79@umd.edu', 'Student'),
    ('user80', 'password80', 'user80@umd.edu', 'Student'),
    ('user81', 'password81', 'user81@umd.edu', 'Student'),
    ('user82', 'password82', 'user82@umd.edu', 'Student'),
    ('user83', 'password83', 'user83@umd.edu', 'Student'),
    ('user84', 'password84', 'user84@umd.edu', 'Student'),
    ('user85', 'password85', 'user85@umd.edu', 'Student'),
    ('user86', 'password86', 'user86@umd.edu', 'Student'),
    ('user87', 'password87', 'user87@umd.edu', 'Student'),
    ('user88', 'password88', 'user88@umd.edu', 'Student'),
    ('user89', 'password89', 'user89@umd.edu', 'Student'),
    ('user90', 'password90', 'user90@umd.edu', 'Student'),
    ('user91', 'password91', 'user91@umd.edu', 'Student'),
    ('user92', 'password92', 'user92@umd.edu', 'Student'),
    ('user93', 'password93', 'user93@umd.edu', 'Student'),
    ('user94', 'password94', 'user94@umd.edu', 'Student'),
    ('user95', 'password95', 'user95@umd.edu', 'Student'),
    ('user96', 'password96', 'user96@umd.edu', 'Student'),
    ('user97', 'password97', 'user97@umd.edu', 'Student'),
    ('user98', 'password98', 'user98@umd.edu', 'Student'),
    ('user99', 'password99', 'user99@umd.edu', 'Student'),
    ('user100', 'password100', 'user100@umd.edu', 'Student'),
    ('user101', 'password101', 'user101@umd.edu', 'Student'),
    ('user102', 'password102', 'user102@umd.edu', 'Student'),
    ('user103', 'password103', 'user103@umd.edu', 'Student'),
    ('user104', 'password104', 'user104@umd.edu', 'Student'),
    ('user105', 'password105', 'user105@umd.edu', 'Student'),
    ('user106', 'password106', 'user106@umd.edu', 'Student'),
    ('user107', 'password107', 'user107@umd.edu', 'Student'),
    ('user108', 'password108', 'user108@umd.edu', 'Student'),
    ('user109', 'password109', 'user109@umd.edu', 'Student'),
    ('user110', 'password110', 'user110@umd.edu', 'Student'),
    ('user111', 'password111', 'user111@umd.edu', 'Student'),
    ('user112', 'password112', 'user112@umd.edu', 'Student'),
    ('user113', 'password113', 'user113@umd.edu', 'Student'),
    ('user114', 'password114', 'user114@umd.edu', 'Student'),
    ('user115', 'password115', 'user115@umd.edu', 'Student'),
    ('user116', 'password116', 'user116@umd.edu', 'Student'),
    ('user117', 'password117', 'user117@umd.edu', 'Student'),
    ('user118', 'password118', 'user118@umd.edu', 'Student'),
    ('user119', 'password119', 'user119@umd.edu', 'Student'),
    ('user120', 'password120', 'user120@umd.edu', 'Student'),
    ('user121', 'password121', 'user121@umd.edu', 'Student'),
    ('user122', 'password122', 'user122@umd.edu', 'Student'),
    ('user123', 'password123', 'user123@umd.edu', 'Student'),
    ('user124', 'password124', 'user124@umd.edu', 'Student'),
    ('user125', 'password125', 'user125@umd.edu', 'Student'),
    ('user126', 'password126', 'user126@umd.edu', 'Student'),
    ('user127', 'password127', 'user127@umd.edu', 'Student'),
    ('user128', 'password128', 'user128@umd.edu', 'Student'),
    ('user129', 'password129', 'user129@umd.edu', 'Student'),
    ('user130', 'password130', 'user130@umd.edu', 'Student'),
    ('user131', 'password131', 'user131@umd.edu', 'Student'),
    ('user132', 'password132', 'user132@umd.edu', 'Student'),
    ('user133', 'password133', 'user133@umd.edu', 'Student'),
    ('user134', 'password134', 'user134@umd.edu', 'Student'),
    ('user135', 'password135', 'user135@umd.edu', 'Student'),
    ('user136', 'password136', 'user136@umd.edu', 'Student'),
    ('user137', 'password137', 'user137@umd.edu', 'Student'),
    ('user138', 'password138', 'user138@umd.edu', 'Student'),
    ('user139', 'password139', 'user139@umd.edu', 'Student'),
    ('user140', 'password140', 'user140@umd.edu', 'Student'),
    ('user141', 'password141', 'user141@umd.edu', 'Student'),
    ('user142', 'password142', 'user142@umd.edu', 'Student'),
    ('user143', 'password143', 'user143@umd.edu', 'Student'),
    ('user144', 'password144', 'user144@umd.edu', 'Student'),
    ('user145', 'password145', 'user145@umd.edu', 'Student'),
    ('user146', 'password146', 'user146@umd.edu', 'Student'),
    ('user147', 'password147', 'user147@umd.edu', 'Student'),
    ('user148', 'password148', 'user148@umd.edu', 'Student'),
    ('user149', 'password149', 'user149@umd.edu', 'Student'),
    ('user150', 'password150', 'user150@umd.edu', 'Student'),
    ('user151', 'password151', 'user151@umd.edu', 'Student'),
    ('user152', 'password152', 'user152@umd.edu', 'Student');

CREATE TABLE Courses (
    Course_ID INT AUTO_INCREMENT PRIMARY KEY,
    Course_Name VARCHAR(255) NOT NULL,
    Instructor_ID INT,
    Description TEXT,
    FOREIGN KEY (Instructor_ID) REFERENCES Users(User_ID)
);

--
-- Dumping data for table `Course`
--

INSERT INTO Courses (Course_Name, Instructor_ID, Description)
VALUES
    ('Course 1', 3, 'Description for Course 1'),
    ('Course 2', 4, 'Description for Course 2'),
    ('Course 3', 5, 'Description for Course 3'),
    ('Course 4', 6, 'Description for Course 4'),
    ('Course 5', 7, 'Description for Course 5'),
    ('Course 6', 8, 'Description for Course 6'),
    ('Course 7', 9, 'Description for Course 7'),
    ('Course 8', 10, 'Description for Course 8');


CREATE TABLE Content (
    Content_ID INT AUTO_INCREMENT PRIMARY KEY,
    Course_ID INT,
    Content_Name VARCHAR(255) NOT NULL,
    Content TEXT,
    FOREIGN KEY (Course_ID) REFERENCES Courses(Course_ID)
);

-- Insert sample content data for all courses
INSERT INTO Content (Course_ID, Content_Name, Content)
SELECT
    C.Course_ID,
    CONCAT('Content for Course ', C.Course_ID, ', Content ', Numbers.n) AS Content_Name,
    CONCAT('This is content for Course ', C.Course_ID, ', Content ', Numbers.n, '.') AS Content
FROM
    Courses C
CROSS JOIN (
    SELECT 1 AS n UNION ALL
    SELECT 2 UNION ALL
    SELECT 3 UNION ALL
    SELECT 4 UNION ALL
    SELECT 5 UNION ALL
    SELECT 6 UNION ALL
    SELECT 7 UNION ALL
    SELECT 8
) AS Numbers;


CREATE TABLE Enrollments (
    Enrollment_ID INT AUTO_INCREMENT PRIMARY KEY,
    User_ID INT,
    Course_ID INT,
    TotalGrade DECIMAL(5, 2), -- You can adjust the precision and scale as needed
    FOREIGN KEY (User_ID) REFERENCES Users(User_ID),
    FOREIGN KEY (Course_ID) REFERENCES Courses(Course_ID)
);

-- Insert sample enrollment data for 50 students with different course combinations
INSERT INTO Enrollments (User_ID, Course_ID, TotalGrade)
VALUES
    (11, 1, 92.5),
    (11, 2, 88.0),

    (12, 2, 91.0),
    (12, 3, 85.5),

    (13, 3, 94.0),
    (13, 4, 90.5),

    (14, 1, 87.0),
    (14, 4, 89.5),

    (15, 1, 95.0),
    (15, 2, 92.5),
    (15, 3, 88.5),

    (16, 3, 91.0),
    (16, 4, 87.5),
    (16, 5, 93.0),

    (17, 1, 89.5),
    (17, 4, 94.5),
    (17, 6, 90.0),

    (18, 2, 93.5),
    (18, 5, 89.0),
    (18, 7, 87.0),

    (19, 3, 88.0),
    (19, 6, 92.0),
    (19, 8, 86.5),

    (20, 4, 90.0),
    (20, 7, 91.5),

    (21, 1, 92.0),
    (21, 5, 88.0),

    (22, 2, 86.5),
    (22, 6, 90.5),

    (23, 3, 94.5),
    (23, 7, 87.5),

    (24, 4, 89.0),
    (24, 8, 91.0),

    (25, 1, 87.5),
    (25, 5, 91.0),

    (26, 2, 93.0),
    (26, 6, 89.5),

    (27, 3, 91.5),
    (27, 7, 94.0),

    (28, 4, 88.5),
    (28, 8, 90.0),

    (29, 1, 90.5),
    (29, 5, 92.5),

    (30, 2, 85.0),
    (30, 6, 87.0),

    (31, 3, 93.5),
    (31, 7, 89.0),

    (32, 4, 91.0),
    (32, 8, 86.0),

    (33, 1, 88.0),
    (33, 5, 94.5),

    (34, 2, 90.0),
    (34, 6, 88.5),

    (35, 3, 87.0),
    (35, 7, 92.0),

    (36, 4, 91.5),
    (36, 8, 85.5),

    (37, 1, 89.0),
    (37, 5, 93.0),

    (38, 2, 87.5),
    (38, 6, 91.0),

    (39, 3, 91.0),
    (39, 7, 88.0),

    (40, 4, 90.0),
    (40, 8, 94.0),

    (41, 1, 86.5),
    (41, 5, 89.5),

    (42, 2, 92.0),
    (42, 6, 93.5),

    (43, 3, 88.5),
    (43, 7, 91.5),

    (44, 4, 94.0),
    (44, 8, 87.0),

    (45, 1, 91.5),
    (45, 5, 86.0),

    (46, 2, 85.5),
    (46, 6, 90.0),

    (47, 3, 92.5),
    (47, 7, 94.5),

    (48, 4, 87.5),
    (48, 8, 91.0),

    (49, 1, 90.0),
    (49, 5, 88.5),

    (50, 2, 94.5),
    (50, 6, 89.0);

CREATE TABLE Assignments (
    Assignment_ID INT AUTO_INCREMENT PRIMARY KEY,
    Course_ID INT,
    Title VARCHAR(255) NOT NULL,
    Description TEXT,
    Due_Date DATE,
    FOREIGN KEY (Course_ID) REFERENCES Courses(Course_ID)
);

-- Insert sample assignment data for 10 assignments
INSERT INTO Assignments (Course_ID, Title, Description, Due_Date)
VALUES
    (1, 'Assignment 1', 'Description for Assignment 1', '2023-01-15'),
    (1, 'Assignment 2', 'Description for Assignment 2', '2023-02-05'),
    (2, 'Assignment 1', 'Description for Assignment 1', '2023-01-20'),
    (2, 'Assignment 2', 'Description for Assignment 2', '2023-02-10'),
    (3, 'Assignment 1', 'Description for Assignment 1', '2023-01-25'),
    (3, 'Assignment 2', 'Description for Assignment 2', '2023-02-15'),
    (4, 'Assignment 1', 'Description for Assignment 1', '2023-01-30'),
    (4, 'Assignment 2', 'Description for Assignment 2', '2023-02-20'),
    (5, 'Assignment 1', 'Description for Assignment 1', '2023-02-05'),
    (5, 'Assignment 2', 'Description for Assignment 2', '2023-02-25');


CREATE TABLE StudentGrades (
    Grade_ID INT AUTO_INCREMENT PRIMARY KEY,
    Enrollment_ID INT,
    Assignment_ID INT,
    Grade DECIMAL(5, 2), -- You can adjust the precision and scale as needed
    FOREIGN KEY (Enrollment_ID) REFERENCES Enrollments(Enrollment_ID),
    FOREIGN KEY (Assignment_ID) REFERENCES Assignments(Assignment_ID)
);

-- Insert sample student grades data for 50 entries
INSERT INTO StudentGrades (Enrollment_ID, Assignment_ID, Grade)
VALUES
    (1, 1, 92.5),
    (1, 2, 88.0),
    (2, 2, 91.0),
    (2, 3, 85.5),
    (3, 3, 94.0),
    (3, 4, 90.5),
    (4, 1, 87.0),
    (4, 4, 89.5),
    (5, 1, 95.0),
    (5, 2, 92.5),
    (6, 3, 88.5),
    (6, 4, 87.5),
    (7, 1, 89.5),
    (7, 4, 94.5),
    (8, 2, 93.5),
    (8, 5, 89.0),
    (9, 3, 88.0),
    (9, 6, 92.0),
    (10, 4, 90.0),
    (10, 7, 91.5),
    (11, 1, 92.0),
    (11, 5, 88.0),
    (12, 2, 86.5),
    (12, 6, 90.5),
    (13, 3, 94.5),
    (13, 7, 87.5),
    (14, 4, 89.0),
    (14, 8, 91.0),
    (15, 1, 87.5),
    (15, 5, 91.0),
    (16, 2, 93.0),
    (16, 6, 89.5),
    (17, 3, 91.5),
    (17, 7, 94.0),
    (18, 4, 88.5),
    (18, 8, 90.0),
    (19, 1, 90.5),
    (19, 5, 92.5),
    (20, 2, 85.0),
    (20, 6, 87.0),
    (21, 3, 93.5),
    (21, 7, 89.0),
    (22, 4, 91.0),
    (22, 8, 86.0),
    (23, 1, 88.0),
    (23, 5, 94.5),
    (24, 2, 90.0),
    (24, 6, 88.5),
    (25, 3, 87.0),
    (25, 7, 92.0),
    (26, 4, 91.5),
    (26, 8, 85.5),
    (27, 1, 89.0),
    (27, 5, 93.0),
    (28, 2, 87.5),
    (28, 6, 91.0),
    (29, 3, 91.0),
    (29, 7, 88.0),
    (30, 4, 90.0),
    (30, 8, 94.0),
    (31, 1, 86.5),
    (31, 5, 89.5),
    (32, 2, 92.0),
    (32, 6, 93.5),
    (33, 3, 88.5),
    (33, 7, 91.5),
    (34, 4, 94.0),
    (34, 8, 87.0),
    (35, 1, 91.5),
    (35, 5, 86.0),
    (36, 2, 85.5),
    (36, 6, 90.0),
    (37, 3, 92.5),
    (37, 7, 94.5),
    (38, 4, 87.5),
    (38, 8, 91.0),
    (39, 1, 90.0),
    (39, 5, 88.5),
    (40, 2, 94.5),
    (40, 6, 89.0);
