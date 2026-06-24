ARG VARIANT="3-25-trixie"
FROM mcr.microsoft.com/devcontainers/java:${VARIANT}

ARG INSTALL_MAVEN="true"
ARG MAVEN_VERSION="3.9.16"

RUN if [ "${INSTALL_MAVEN}" = "true" ]; then \
    su vscode -c "umask 0002 && . /usr/local/sdkman/bin/sdkman-init.sh && sdk install maven \"${MAVEN_VERSION}\""; \
    fi

RUN if [ "${INSTALL_MAVEN}" = "true" ]; then \
    su vscode -c ". /usr/local/sdkman/bin/sdkman-init.sh && sdk default maven ${MAVEN_VERSION}"; \
    fi
