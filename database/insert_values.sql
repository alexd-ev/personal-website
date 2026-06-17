-- Experience Entries
INSERT INTO experience (company, role, start_date, end_date, description) VALUES
('Accenture', 'Tech Bootcamp Participant', '2026-02', '2026-02', 
    'Participated in a 4-day tech bootcamp, learning about the use of agentic AI to tackle real-world business problems'),
('Peroptyx', 'Map Analyst', '2024-12', '2025-01', 
    'Gained an understanding of map analysis techniques, such as accuracy of precise location of queried results'),
('Packing Assistant', 'Longhurst''s Bakery', '2022-11', '2022-11', 'Assisted in packing bagels for delivery to nearby shops'),
('Assistant Cashier', 'Burgertory', '2021-12', '2021-12', 'Assisted in taking and serving orders and cleaned trays');

-- Education Entries
INSERT INTO education (institution, degree, major, start_date, end_date) VALUES
('RMIT University', 'Bachelor of Computer Science (Professional)', 'Advanced Computer Science', '2024-03', NULL),
('Richmond High School', 'VCE', NULL, '2020-02', '2023-11'),
('St. Mary''s College', NULL, NULL, '2018-02', '2019-11');

-- Project Entries
INSERT INTO projects (title, description, github_url, education_id) VALUES
('Image Classification', 'Classified colon cell images as cancerous or not, as well as the cell type', 
    'https://github.com/alex-dav/Image-Classification1', 1),
('AWS Cloud System Development', 'Song subscription web app implemented on three backends', 
    'https://github.com/alex-dav/AWS-Cloud-System-Development', 1),
('Exam Timetabling System', 'Scheduled exams to timeslots and rooms', 'URL available upon request', 1),
('Machine Learning Classification and Model Comparison', 'Classified fire intensity level of wildfire events', 
    'https://github.com/alex-dav/Machine-Learning-Classification-and-Model-Comparison', 1),
('Flight Routing System', 'Found cheapest/fastest flights between two cities', 'URL available upon request', 1),
('Machine Learning Pipeline', 'Predicted nightly prices of Airbnbs based on various features', 
    'https://github.com/alex-dav/Machine-Learning-Pipeline', 1),
('Memory Allocation', 'Simulated malloc and free functions using a custom memory allocator with two approaches', 
    'https://github.com/alex-dav/Memory-Allocation', 1),
('Reinforcement Learning', 'Trained a Pacman agent to avoid ghosts and get to the exit', 'URL available upon request', 1),
('Travelling Salesperson Problem', 'Implemented three algorithms for solving the problem', 
    'https://github.com/alex-dav/Travelling-Salesperson-Problem', 1),
('Agents in City', 'Queried agents to find base and complex items in shops', 'URL available upon request', 1),
('Multithreading & Synchronisation', 'Created a multithreaded file copier and a file copier', 
    'https://github.com/alex-dav/Multithreading-Synchronisation', 1),
('Pacman Search', 'Different heuristis were used so Pacman can find all the food and exit', 'URL available upon request', 1),
('Road Registry Platform', 'Created a mock system for managing vehicle owners'' account information', 
    'https://github.com/alex-dav/Road-Registry-Platform', 1),
('Knapsack Maze Solving', 'Collected treasures in a maze while balancing weight and time to get to the exit', 
    'https://github.com/alex-dav/Knapsack-Maze-Solving', 1),
('Machine Learning: Programming Assignment', 'Classified whether a patient has heart disease or not',
    'https://github.com/alex-dav/Machine-Learning-Programming-Assignment', 1),
('Classical AI', 'Suggested a medications determined by probability of having conditions', 
    'https://github.com/alex-dav/Classical-AI', 1),
('Minecraft Maze Solving', 'Simulated the player solving a maze in Minecraft using an external API', 
    'https://github.com/alex-dav/Minecraft-Maze-Solving', 1),
('LC3 Assembly with Minecraft', 'Used subroutines that communicate with Minecraft by retrieving data in the Minecraft world', 
    'https://github.com/alex-dav/LC3-Assembly-with-Minecraft', 1),
('Food Loss and Waste Investigation', 'Created a web app showcasing some sample food loss and waste statistics', 
    'https://github.com/alex-dav/Food-Loss-and-Waste-Investigation', 1);

INSERT INTO projects (title, description, github_url, experience_id) VALUES
('Plan4Impact', 'Event planning web app focusing on sustainability', 'https://github.com/lieuryan/Plan4Impact', 1);

-- Skills Entries
 INSERT INTO skills (name, category) VALUES
('Java', 'Programming Language'),
('C/C++', 'Programming Language'),
('Python', 'Programming Language'),
('HTML', 'Programming Language'),
('CSS', 'Programming Language'),
('SQL', 'Programming Language'),
('OCaml', 'Programming Language'),
('Prolog', 'Programming Language'),
('Answer Set Programming', 'Programming Language'),
('LC3 Assembly', 'Programming Language'),
('AWS', 'Cloud Computing'),
('Docker', 'Containerisation'),
('Windows', 'Operating Systems'),
('macOS', 'Operating Systems'),
('Ubuntu/Kali', 'Operating Systems'),
('Excel', 'Database Storage'),
('SQLiteStudio', 'Database Storage'),
('Git/GitHub', 'Version Control'),
('Agentic AI Development', 'Artificial Intelligence'),
('n8n Workflows', 'Automation'),
('Machine Learning', 'Data Science'),
('Data Analysis', 'Data Science'),
('Data Visualisation', 'Data Science'),
('Reinforcement Learning', 'Data Science'),
('Computer Vision', 'Data Science'),
('Teamwork', 'Soft Skills'),
('Problem Solving', 'Soft Skills'),
('Communication', 'Soft Skills'),
('Time Management', 'Soft Skills'),
('Report Writing', 'Soft Skills'),
('Leadership', 'Soft Skills'),
('Critical Thinking', 'Soft Skills'),
('Adaptability', 'Soft Skills'),
('Creativity', 'Soft Skills'),
('Attention to Detail', 'Soft Skills'),
('Collaboration', 'Soft Skills'),
('Presentation Skills', 'Soft Skills'),
('Project Management', 'Soft Skills'),
('Project Planning', 'Soft Skills');

-- Project-Skills Junction Entries
INSERT INTO project_skills (project_id, skill_id) VALUES
(1, 3), (1, 13), (1, 16), (1, 21), (1, 22), (1, 23), (1, 25), (1, 27), (1, 29), (1, 30), (1, 32), (1, 34),
(2, 1), (2, 3), (2, 4), (2, 5), (2, 11), (2, 12), (2, 13), (2, 15), (2, 18), (2, 22), (2, 26), (2, 27), (2, 28), (2, 29), 
    (2, 30), (2, 31), (2, 32), (2, 36), (2, 37), (2, 38), (2, 39),
(3, 3), (3, 8), (3, 9), (3, 15), (3, 18), (3, 22), (3, 23), (3, 26), (3, 27), (3, 28), (3, 29), (3, 30), (3, 31), (3, 32),
    (3, 34), (3, 36), (3, 37), (3, 38), (3, 39),
(4, 3), (4, 13), (4, 16), (4, 21), (4, 22), (4, 23), (4, 27), (4, 29), (4, 30), (4, 32), (4, 34),
(5, 8), (5, 15), (5, 18), (5, 22), (5, 23), (5, 27), (5, 29), (5, 32), (5, 35),
(6, 3), (6, 13), (6, 16), (6, 21), (6, 22), (6, 23), (6, 27), (6, 29), (6, 30), (6, 32), (6, 34),
(7, 2), (7, 15), (7, 27), (7, 29), (7, 32), (7, 34), (7, 35),
(8, 3), (8, 15), (8, 18), (8, 24), (8, 27), (8, 29), (8, 32), (8, 34), (8, 35),
