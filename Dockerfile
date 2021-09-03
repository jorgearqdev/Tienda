FROM gradle:6.9.1-jdk8

WORKDIR /app
COPY . .
RUN chmod o+x /app/start.sh /app/microservicio

CMD ["sh","/app/start.sh"]