# Personal Portfolio Website
My personal portfolio website project. 

# Building & Running the Code
## Locally
Run `mvn exec:java` in a terminal, which reads the `pom.xml` file, downloads the Java libraries, builds and runs the application.

## Remotely using a Dev Container
Run these commands in a terminal:
1. `devcontainer up --workspace-folder .` which builds and runs the Docker container in `.devcontainer/Dockerfile`.
2. `devcontainer exec --workspace-folder . mvn exec:java` which builds and runs the application inside the container.

# Author
`alexd-ev` (Alex Davidson)

Copyright Alex Davidson (c) 2026
