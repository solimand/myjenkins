# FROM jenkins/jenkins:2.452.2-lts
FROM jenkins/jenkins:2.463
# FROM jenkins:2.46.3

# skip initial wizard
ENV JAVA_OPTS -Djenkins.install.runSetupWizard=false

# RUN jenkins-plugin-cli --plugins "blueocean:1.25.6 docker-workflow:1.29"
COPY --chown=jenkins:jenkin plugin-list.txt /usr/share/jenkins/ref/plugins.txt
RUN jenkins-plugin-cli -f /usr/share/jenkins/ref/plugins.txt