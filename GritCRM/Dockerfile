# Use the correct base image
# version of tomcat and jdk-version
FROM tomcat:10.1-jdk21

# Remove the default application
RUN rm -rf /usr/local/tomcat/webapps/ROOT

# Copy our application into the image
COPY target/*.war /usr/local/tomcat/webapps/ROOT.war

# Expose (open) port 8080 (appplication port for Tomcat)
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]