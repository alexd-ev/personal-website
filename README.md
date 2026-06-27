# Personal Portfolio Website
## Overview
My personal portfolio website project uses my portfolio local database, which contains data about me. Specifically, the website showcases my past experience, education, projects, skills, and courses. Utilises local hosting on javalin web server with thymeleaf frontend, with future plans to host on AWS.

It runs a series of queries to do lookups to render the data on the website. Initially manually ran SQL scripts in a DBMS to create tables and insert values, but this can be modified to use Java to read CSV files and create tables and insert values in the database. The database is non volatile, so contact form submissions are persistent.

### Homepage
![Homepage Screenshot](src/main/resources/public/images/homepage.png)

### Contact Page
![Contact page Screenshot](src/main/resources/public/images/contact-page.png)

## Technical Specification
To open the website, JRE 25+ is required. If an earlier version must be used, then build and run the code as below, though this requires the full JDK. Download the released `alexds-personal-website-1.0.0.zip` archive found here: https://github.com/alexd-ev/personal-website/releases/latest. Extract the files then run this command in a terminal:
1. `java --enable-native-access=ALL-UNNAMED -jar alexds-personal-website-1.0.0.jar`
2. Go to: http://localhost:7001/

To build and run the code locally, JDK 25+ is required. If an earlier version must be used, replace the `void main()` signature with `public static void main(String[] args)` in `App.java:24`. And change the maven compiler release tag value to the version in `pom.xml:15`. If using most IDE maven plugins, the libraries are automatically downloaded and can run from IDE. Otherwise, maven is required to download the libraries and build the application (see [Building & Running the code Locally](#locally)).

To build and run the code remotely, docker engine is required. If using most IDE dev container plugins, can open the remote dev container and run from IDE. Otherwise, the dev container CLI is required. (see [Building & Running the code Remotely](#remotely-using-a-dev-container)) If only docker must be used, WIP.

## Classes backing Web Pages
```
PageIndex.java                              - Homepage
PageContact.java                            - Contact page
PageContactSubmit.java                      - Form handler
```

## Other Classes
```
App.java                                    - Main Application entrypoint
Course.java                                 - Course information loader
DateTimeUtils.java                          - Date and time formatter
Education.java                              - Education information loader
ErrorUtils.java                             - Error renderer
Experience.java                             - Experience information loader
JDBCConnection.java                         - Database connecter
Project.java                                - Project information loader
Skill.java                                  - Skill information loader
```

## Project Structure
```
personal-website/
├── .devcontainer/
│   ├── devcontainer.json                   - Configure dev container
│   └── Dockerfile                          - Configure docker image
├── .vscode/
│   ├── java-formatter.xml                  - IDE formatter
│   └── settings.json                       - IDE settings
├── database/
│   ├── AboutMe.db                          - SQLite database
│   ├── *.csv                               - Exported tables
│   └── *.sql                               - Setup tables scripts
├── src/main/
│   ├── java/com/alexd/app/
│   │   └── *.java                          - Java source files
│   └── resources/
│       ├── public/
│       │   ├── css/
│       │   │   └── style.css               - User interface styling
│       │   └── images/
│       │       └── *.png                   - Project images
│       └── templates/
│           └── *.html                      - User interface markup
├── target/                                 - Generated build directory
├── .gitignore                              - Ignore maven files
├── LICENSE                                 - GPL-3.0 licence
├── README.md                               - Documentation
└── pom.xml                                 - Configure build
```

## Libraries
* org.xerial:sqlite-jdbc (SQLite Java Database Connectivity)
* io.javalin:
    * javalin (Java web server)
    * javalin-rendering-thymeleaf (HTML template)
* org.slf4:slf4j-simple (Logging)

# Building & Running the Code
## Locally
1. Run `mvn exec:java` in a terminal, which reads the `pom.xml` file, downloads the Java libraries, builds and runs the application.
2. Go to: http://localhost:7001/

## Remotely using a Dev Container
Start docker engine, then run these commands in a terminal:
1. `devcontainer up --workspace-folder .` which builds and runs the Docker container in `.devcontainer/Dockerfile`.
2. `devcontainer exec --workspace-folder . mvn exec:java` which builds and runs the application inside the container.
3. Go to: http://localhost:7001/

# Author
`alexd-ev` (Alex Davidson)

Copyright Alex Davidson (c) 2026
