-- Experience Entries
INSERT INTO experience (
                           company,
                           role,
                           start_date,
                           end_date,
                           description
                       )
                       VALUES (
                           'Accenture',
                           'Tech Bootcamp Participant',
                           '2026-02',
                           '2026-02',
                           'Participated in a 4-day tech bootcamp, learned about the use of agentic AI to tackle real-world business problems'
                       ),
                       (
                           'Peroptyx',
                           'Map Analyst',
                           '2024-12',
                           '2025-01',
                           'Gained an understanding of map analysis techniques, such as accuracy of precise location of queried results'
                       ),
                       (
                           'Longhurst''s Bakery',
                           'Packing Assistant',
                           '2022-11',
                           '2022-11',
                           'Assisted in packing bagels for delivery to nearby shops'
                       ),
                       (
                           'Burgertory',
                           'Assistant Cashier',
                           '2021-12',
                           '2021-12',
                           'Assisted in taking and serving orders and cleaned trays'
                       );
-- Education Entries

INSERT INTO education (
                          institution,
                          degree,
                          major,
                          start_date,
                          end_date
                      )
                      VALUES (
                          'RMIT University',
                          'Bachelor of Computer Science',
                          'Advanced Computer Science',
                          '2024-03',
                          NULL
                      ),
                      (
                          'Richmond High School',
                          'VCE',
                          NULL,
                          '2020-02',
                          '2023-11'
                      ),
                      (
                          'St. Mary''s College',
                          NULL,
                          NULL,
                          '2018-02',
                          '2019-11'
                      );
-- Project Entries

INSERT INTO projects (
                         title,
                         description,
                         github_url,
                         education_id
                     )
                     VALUES (
                         'Food Loss and Waste Investigation',
                         'Created a web app showcasing some sample food loss and waste statistics',
                         'https://github.com/alex-dav/Food-Loss-and-Waste-Investigation',
                         1
                     ),
                     (
                         'LC3 Assembly with Minecraft',
                         'Used subroutines that communicate with Minecraft by retrieving data in the Minecraft world',
                         'https://github.com/alex-dav/LC3-Assembly-with-Minecraft',
                         1
                     ),
                     (
                         'Minecraft Maze Solving',
                         'Simulated the player solving a maze in Minecraft using an external API',
                         'https://github.com/alex-dav/Minecraft-Maze-Solving',
                         1
                     ),
                     (
                         'Classical AI',
                         'Suggested a medications determined by probability of having conditions',
                         'https://github.com/alex-dav/Classical-AI',
                         1
                     ),
                     (
                         'Machine Learning: Programming Assignment',
                         'Classified whether a patient has heart disease or not',
                         'https://github.com/alex-dav/Machine-Learning-Programming-Assignment',
                         1
                     ),
                     (
                         'Knapsack Maze Solving',
                         'Collected treasures in a maze while balancing weight and time to get to the exit',
                         'https://github.com/alex-dav/Knapsack-Maze-Solving',
                         1
                     ),
                     (
                         'Road Registry Platform',
                         'Created a mock system for managing vehicle owners'' account information',
                         'https://github.com/alex-dav/Road-Registry-Platform',
                         1
                     ),
                     (
                         'Multithreading & Synchronisation',
                         'Created a multithreaded file copier and a file copier',
                         'https://github.com/alex-dav/Multithreading-Synchronisation',
                         1
                     ),
                     (
                         'Pacman Search',
                         'Different heuristis were used so Pacman can find all the food and exit',
                         NULL,
                         1
                     ),
                     (
                         'Agents in City',
                         'Queried agents to find base and complex items in shops',
                         NULL,
                         1
                     ),
                     (
                         'Travelling Salesperson Problem',
                         'Implemented three algorithms for solving the problem',
                         'https://github.com/alex-dav/Travelling-Salesperson-Problem',
                         1
                     ),
                     (
                         'Reinforcement Learning',
                         'Trained a Pacman agent to avoid ghosts and get to the exit',
                         NULL,
                         1
                     ),
                     (
                         'Memory Allocation',
                         'Simulated malloc and free functions using a custom memory allocator with two approaches',
                         'https://github.com/alex-dav/Memory-Allocation',
                         1
                     );

INSERT INTO projects (
                         title,
                         description,
                         github_url,
                         experience_id
                     )
                     VALUES (
                         'Plan4Impact',
                         'Event planning web app focusing on sustainability',
                         'https://github.com/lieuryan/Plan4Impact',
                         1
                     );

INSERT INTO projects (
                         title,
                         description,
                         github_url,
                         education_id
                     )
                     VALUES (
                         'Machine Learning Pipeline',
                         'Predicted nightly prices of Airbnbs based on various features',
                         'https://github.com/alex-dav/Machine-Learning-Pipeline',
                         1
                     ),
                     (
                         'Flight Routing System',
                         'Found cheapest/fastest flights between two cities',
                         NULL,
                         1
                     ),
                     (
                         'Machine Learning Classification and Model Comparison',
                         'Classified fire intensity level of wildfire events',
                         'https://github.com/alex-dav/Machine-Learning-Classification-and-Model-Comparison',
                         1
                     ),
                     (
                         'Exam Timetabling System',
                         'Scheduled exams to timeslots and rooms',
                         NULL,
                         1
                     ),
                     (
                         'AWS Cloud System Development',
                         'Song subscription web app implemented on three backends',
                         'https://github.com/alex-dav/AWS-Cloud-System-Development',
                         1
                     ),
                     (
                         'Image Classification',
                         'Classified colon cell images as cancerous or not, as well as the cell type',
                         'https://github.com/alex-dav/Image-Classification',
                         1
                     );

INSERT INTO projects (
                         title,
                         description,
                         github_url
                     )
                     VALUES (
                         'Personal Website',
                         'This personal portfolio website project',
                         'https://github.com/alexd-ev/personal-website'
                     ),
                     (
                         'Skyblock Generator',
                         'My Minecraft classic skyblock island generator project',
                         'https://github.com/alexd-ev/skyblock-generator'
                     );
-- Skills Entries

INSERT INTO skills (
                       name,
                       category
                   )
                   VALUES (
                       'Java',
                       'Programming Languages'
                   ),
                   (
                       'C/C++',
                       'Programming Languages'
                   ),
                   (
                       'Python',
                       'Programming Languages'
                   ),
                   (
                       'HTML',
                       'Programming Languages'
                   ),
                   (
                       'CSS',
                       'Programming Languages'
                   ),
                   (
                       'SQL',
                       'Programming Languages'
                   ),
                   (
                       'OCaml',
                       'Programming Languages'
                   ),
                   (
                       'Prolog',
                       'Programming Languages'
                   ),
                   (
                       'Answer Set Programming',
                       'Programming Languages'
                   ),
                   (
                       'LC3 Assembly',
                       'Programming Languages'
                   ),
                   (
                       'AWS',
                       'Cloud Computing'
                   ),
                   (
                       'Docker',
                       'Containerisation'
                   ),
                   (
                       'Windows',
                       'Operating Systems'
                   ),
                   (
                       'macOS',
                       'Operating Systems'
                   ),
                   (
                       'Ubuntu/Kali',
                       'Operating Systems'
                   ),
                   (
                       'Excel',
                       'Database Storage'
                   ),
                   (
                       'SQLiteStudio',
                       'Database Storage'
                   ),
                   (
                       'Git/GitHub',
                       'Version Control'
                   ),
                   (
                       'Agentic AI Development',
                       'Artificial Intelligence'
                   ),
                   (
                       'n8n Workflows',
                       'Automation'
                   ),
                   (
                       'Machine Learning',
                       'Data Science'
                   ),
                   (
                       'Data Analysis',
                       'Data Science'
                   ),
                   (
                       'Data Visualisation',
                       'Data Science'
                   ),
                   (
                       'Reinforcement Learning',
                       'Data Science'
                   ),
                   (
                       'Computer Vision',
                       'Data Science'
                   ),
                   (
                       'Teamwork',
                       'Soft Skills'
                   ),
                   (
                       'Problem Solving',
                       'Soft Skills'
                   ),
                   (
                       'Communication',
                       'Soft Skills'
                   ),
                   (
                       'Time Management',
                       'Soft Skills'
                   ),
                   (
                       'Report Writing',
                       'Soft Skills'
                   ),
                   (
                       'Leadership',
                       'Soft Skills'
                   ),
                   (
                       'Critical Thinking',
                       'Soft Skills'
                   ),
                   (
                       'Adaptability',
                       'Soft Skills'
                   ),
                   (
                       'Creativity',
                       'Soft Skills'
                   ),
                   (
                       'Attention to Detail',
                       'Soft Skills'
                   ),
                   (
                       'Collaboration',
                       'Soft Skills'
                   ),
                   (
                       'Presentation Skills',
                       'Soft Skills'
                   ),
                   (
                       'Project Management',
                       'Soft Skills'
                   ),
                   (
                       'Project Planning',
                       'Soft Skills'
                   );
-- Project-Skills Junction Entries

INSERT INTO project_skills (
                               project_id,
                               skill_id
                           )
                           VALUES (
                               1,
                               1
                           ),
                           (
                               1,
                               13
                           ),
                           (
                               1,
                               16
                           ),
                           (
                               1,
                               17
                           ),
                           (
                               1,
                               18
                           ),
                           (
                               1,
                               26
                           ),
                           (
                               1,
                               27
                           ),
                           (
                               1,
                               28
                           ),
                           (
                               1,
                               29
                           ),
                           (
                               1,
                               31
                           ),
                           (
                               1,
                               32
                           ),
                           (
                               1,
                               33
                           ),
                           (
                               1,
                               34
                           ),
                           (
                               1,
                               35
                           ),
                           (
                               1,
                               36
                           ),
                           (
                               1,
                               37
                           ),
                           (
                               1,
                               38
                           ),
                           (
                               1,
                               39
                           ),
                           (
                               2,
                               10
                           ),
                           (
                               2,
                               15
                           ),
                           (
                               2,
                               18
                           ),
                           (
                               2,
                               27
                           ),
                           (
                               2,
                               29
                           ),
                           (
                               2,
                               32
                           ),
                           (
                               2,
                               34
                           ),
                           (
                               2,
                               35
                           ),
                           (
                               3,
                               2
                           ),
                           (
                               3,
                               15
                           ),
                           (
                               3,
                               18
                           ),
                           (
                               3,
                               26
                           ),
                           (
                               3,
                               27
                           ),
                           (
                               3,
                               28
                           ),
                           (
                               3,
                               29
                           ),
                           (
                               3,
                               31
                           ),
                           (
                               3,
                               32
                           ),
                           (
                               3,
                               34
                           ),
                           (
                               3,
                               35
                           ),
                           (
                               3,
                               37
                           ),
                           (
                               3,
                               38
                           ),
                           (
                               3,
                               39
                           ),
                           (
                               4,
                               3
                           ),
                           (
                               4,
                               13
                           ),
                           (
                               4,
                               27
                           ),
                           (
                               4,
                               29
                           ),
                           (
                               4,
                               32
                           ),
                           (
                               4,
                               34
                           ),
                           (
                               4,
                               35
                           ),
                           (
                               5,
                               3
                           ),
                           (
                               5,
                               13
                           ),
                           (
                               5,
                               16
                           ),
                           (
                               5,
                               21
                           ),
                           (
                               5,
                               22
                           ),
                           (
                               5,
                               23
                           ),
                           (
                               5,
                               27
                           ),
                           (
                               5,
                               29
                           ),
                           (
                               6,
                               3
                           ),
                           (
                               6,
                               15
                           ),
                           (
                               6,
                               18
                           ),
                           (
                               6,
                               23
                           ),
                           (
                               6,
                               27
                           ),
                           (
                               6,
                               29
                           ),
                           (
                               6,
                               32
                           ),
                           (
                               6,
                               34
                           ),
                           (
                               6,
                               35
                           ),
                           (
                               7,
                               1
                           ),
                           (
                               7,
                               13
                           ),
                           (
                               7,
                               18
                           ),
                           (
                               7,
                               26
                           ),
                           (
                               7,
                               27
                           ),
                           (
                               7,
                               28
                           ),
                           (
                               7,
                               29
                           ),
                           (
                               7,
                               31
                           ),
                           (
                               7,
                               35
                           ),
                           (
                               7,
                               36
                           ),
                           (
                               7,
                               37
                           ),
                           (
                               7,
                               38
                           ),
                           (
                               7,
                               39
                           ),
                           (
                               8,
                               3
                           ),
                           (
                               8,
                               15
                           ),
                           (
                               8,
                               18
                           ),
                           (
                               8,
                               27
                           ),
                           (
                               8,
                               29
                           ),
                           (
                               8,
                               32
                           ),
                           (
                               8,
                               35
                           ),
                           (
                               9,
                               2
                           ),
                           (
                               9,
                               15
                           ),
                           (
                               9,
                               27
                           ),
                           (
                               9,
                               29
                           ),
                           (
                               9,
                               32
                           ),
                           (
                               9,
                               35
                           ),
                           (
                               10,
                               8
                           ),
                           (
                               10,
                               15
                           ),
                           (
                               10,
                               18
                           ),
                           (
                               10,
                               27
                           ),
                           (
                               10,
                               29
                           ),
                           (
                               10,
                               32
                           ),
                           (
                               10,
                               35
                           ),
                           (
                               11,
                               3
                           ),
                           (
                               11,
                               13
                           ),
                           (
                               11,
                               27
                           ),
                           (
                               11,
                               29
                           ),
                           (
                               11,
                               30
                           ),
                           (
                               11,
                               32
                           ),
                           (
                               11,
                               35
                           ),
                           (
                               12,
                               3
                           ),
                           (
                               12,
                               15
                           ),
                           (
                               12,
                               18
                           ),
                           (
                               12,
                               24
                           ),
                           (
                               12,
                               27
                           ),
                           (
                               12,
                               29
                           ),
                           (
                               12,
                               32
                           ),
                           (
                               12,
                               34
                           ),
                           (
                               12,
                               35
                           ),
                           (
                               13,
                               2
                           ),
                           (
                               13,
                               15
                           ),
                           (
                               13,
                               27
                           ),
                           (
                               13,
                               29
                           ),
                           (
                               13,
                               32
                           ),
                           (
                               13,
                               34
                           ),
                           (
                               13,
                               35
                           ),
                           (
                               14,
                               4
                           ),
                           (
                               14,
                               5
                           ),
                           (
                               14,
                               11
                           ),
                           (
                               14,
                               13
                           ),
                           (
                               14,
                               18
                           ),
                           (
                               14,
                               19
                           ),
                           (
                               14,
                               20
                           ),
                           (
                               14,
                               26
                           ),
                           (
                               14,
                               27
                           ),
                           (
                               14,
                               28
                           ),
                           (
                               14,
                               29
                           ),
                           (
                               14,
                               31
                           ),
                           (
                               14,
                               32
                           ),
                           (
                               14,
                               33
                           ),
                           (
                               14,
                               34
                           ),
                           (
                               14,
                               36
                           ),
                           (
                               14,
                               37
                           ),
                           (
                               14,
                               38
                           ),
                           (
                               14,
                               39
                           ),
                           (
                               15,
                               3
                           ),
                           (
                               15,
                               13
                           ),
                           (
                               15,
                               16
                           ),
                           (
                               15,
                               21
                           ),
                           (
                               15,
                               22
                           ),
                           (
                               15,
                               23
                           ),
                           (
                               15,
                               27
                           ),
                           (
                               15,
                               29
                           ),
                           (
                               15,
                               30
                           ),
                           (
                               15,
                               32
                           ),
                           (
                               15,
                               34
                           ),
                           (
                               16,
                               8
                           ),
                           (
                               16,
                               15
                           ),
                           (
                               16,
                               18
                           ),
                           (
                               16,
                               22
                           ),
                           (
                               16,
                               23
                           ),
                           (
                               16,
                               27
                           ),
                           (
                               16,
                               29
                           ),
                           (
                               16,
                               32
                           ),
                           (
                               16,
                               35
                           ),
                           (
                               17,
                               3
                           ),
                           (
                               17,
                               13
                           ),
                           (
                               17,
                               16
                           ),
                           (
                               17,
                               21
                           ),
                           (
                               17,
                               22
                           ),
                           (
                               17,
                               23
                           ),
                           (
                               17,
                               27
                           ),
                           (
                               17,
                               29
                           ),
                           (
                               17,
                               30
                           ),
                           (
                               17,
                               32
                           ),
                           (
                               17,
                               34
                           ),
                           (
                               18,
                               3
                           ),
                           (
                               18,
                               8
                           ),
                           (
                               18,
                               9
                           ),
                           (
                               18,
                               15
                           ),
                           (
                               18,
                               18
                           ),
                           (
                               18,
                               22
                           ),
                           (
                               18,
                               23
                           ),
                           (
                               18,
                               26
                           ),
                           (
                               18,
                               27
                           ),
                           (
                               18,
                               28
                           ),
                           (
                               18,
                               29
                           ),
                           (
                               18,
                               30
                           ),
                           (
                               18,
                               31
                           ),
                           (
                               18,
                               32
                           ),
                           (
                               18,
                               34
                           ),
                           (
                               18,
                               36
                           ),
                           (
                               18,
                               37
                           ),
                           (
                               18,
                               38
                           ),
                           (
                               18,
                               39
                           ),
                           (
                               19,
                               1
                           ),
                           (
                               19,
                               3
                           ),
                           (
                               19,
                               4
                           ),
                           (
                               19,
                               5
                           ),
                           (
                               19,
                               11
                           ),
                           (
                               19,
                               12
                           ),
                           (
                               19,
                               13
                           ),
                           (
                               19,
                               15
                           ),
                           (
                               19,
                               18
                           ),
                           (
                               19,
                               22
                           ),
                           (
                               19,
                               26
                           ),
                           (
                               19,
                               27
                           ),
                           (
                               19,
                               28
                           ),
                           (
                               19,
                               29
                           ),
                           (
                               19,
                               30
                           ),
                           (
                               19,
                               31
                           ),
                           (
                               19,
                               32
                           ),
                           (
                               19,
                               36
                           ),
                           (
                               19,
                               37
                           ),
                           (
                               19,
                               38
                           ),
                           (
                               19,
                               39
                           ),
                           (
                               20,
                               3
                           ),
                           (
                               20,
                               13
                           ),
                           (
                               20,
                               16
                           ),
                           (
                               20,
                               21
                           ),
                           (
                               20,
                               22
                           ),
                           (
                               20,
                               23
                           ),
                           (
                               20,
                               25
                           ),
                           (
                               20,
                               27
                           ),
                           (
                               20,
                               29
                           ),
                           (
                               20,
                               30
                           ),
                           (
                               20,
                               32
                           ),
                           (
                               20,
                               34
                           ),
                           (
                               21,
                               1
                           ),
                           (
                               21,
                               4
                           ),
                           (
                               21,
                               5
                           ),
                           (
                               21,
                               6
                           ),
                           (
                               21,
                               11
                           ),
                           (
                               21,
                               13
                           ),
                           (
                               21,
                               15
                           ),
                           (
                               21,
                               17
                           ),
                           (
                               21,
                               18
                           ),
                           (
                               21,
                               19
                           ),
                           (
                               21,
                               27
                           ),
                           (
                               21,
                               32
                           ),
                           (
                               21,
                               33
                           ),
                           (
                               21,
                               34
                           ),
                           (
                               21,
                               35
                           ),
                           (
                               22,
                               2
                           ),
                           (
                               22,
                               10
                           ),
                           (
                               22,
                               15
                           ),
                           (
                               22,
                               18
                           ),
                           (
                               22,
                               19
                           ),
                           (
                               22,
                               27
                           ),
                           (
                               22,
                               32
                           ),
                           (
                               22,
                               33
                           ),
                           (
                               22,
                               34
                           ),
                           (
                               22,
                               35
                           );
-- Courses Entries

INSERT INTO courses (
                        education_id,
                        course_name,
                        course_code,
                        completion_date
                    )
                    VALUES (
                        1,
                        'Cloud Computing',
                        'COSC2626',
                        '2026-06'
                    ),
                    (
                        1,
                        'Innovation Ecosystem and the Future of Work',
                        'OENG1235',
                        '2026-06'
                    ),
                    (
                        1,
                        'Intelligent Decision Making',
                        'COSC2973',
                        '2026-06'
                    ),
                    (
                        1,
                        'Machine Learning',
                        'COSC2673',
                        '2026-06'
                    ),
                    (
                        1,
                        'Artificial Intelligence',
                        'COSC1127',
                        '2025-11'
                    ),
                    (
                        1,
                        'Computing Theory',
                        'COSC1107',
                        '2025-11'
                    ),
                    (
                        1,
                        'Essentials of Computing',
                        'COSC3045',
                        '2025-11'
                    ),
                    (
                        1,
                        'Operating Systems Principles',
                        'COSC1114',
                        '2025-11'
                    ),
                    (
                        1,
                        'Algorithms and Analysis',
                        'COSC2123',
                        '2025-06'
                    ),
                    (
                        1,
                        'Foundations of Artificial Intelligence',
                        'COSC2960',
                        '2025-06'
                    ),
                    (
                        1,
                        'Introduction to Cyber Security',
                        'INTE2625',
                        '2025-06'
                    ),
                    (
                        1,
                        'Software Engineering Fundamentals',
                        'ISYS1118',
                        '2025-06'
                    ),
                    (
                        1,
                        'C++ Programming Studio',
                        'COSC2804',
                        '2024-11'
                    ),
                    (
                        1,
                        'Mathematics for Computing',
                        'MATH2411',
                        '2024-11'
                    ),
                    (
                        1,
                        'C++ Programming Bootcamp',
                        'COSC2802',
                        '2024-09'
                    ),
                    (
                        1,
                        'Java Programming Studio',
                        'COSC2803',
                        '2024-06'
                    ),
                    (
                        1,
                        'Introduction to Mathematics for Computing',
                        'MATH2466',
                        '2024-06'
                    ),
                    (
                        1,
                        'Java Programming Bootcamp',
                        'COSC2801',
                        '2024-04'
                    );
