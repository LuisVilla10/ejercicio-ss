FROM ubuntu
WORKDIR /app
EXPOSE 8080
CMD ["/app/script.sh"]
ADD scripts/script.sql /app/script.sql
ADD scripts/script.sh /app/script.sh
RUN apt update
RUN apt install -y openjdk-8-jdk
RUN apt install -y mariadb-server
RUN chmod 755 /app/script.sql
RUN chmod 755 /app/script.sh
RUN /etc/init.d/mysql start; mysql < /app/script.sql
ADD app/tareas-0.0.1-SNAPSHOT.jar /app/
