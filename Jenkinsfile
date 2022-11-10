version : '3'
services:
  mysqldb:
    image: mysql:latest
    restart: unless-stopped
    environment:
      - MYSQL_ROOT_PASSWORD=root
      - MYSQL_DATABASE=achatdb
    ports:
      - 3306:3306
    networks:
      - backend-net


  app_achat_back:
    image : medalaakanzari/achat_back
    depends_on:
      - mysqldb
    restart: on-failure
    ports:
      - 8089:8089
    environment:
      SPRING_APPLICATION_JSON: '{
            "spring.datasource.url"  : "jdbc:mysql://mysqldb:3306/achatdb?createDatabaseIfNotExist=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
            "spring.datasource.username" : "root",
            "spring.datasource.password" : "root",
            "spring.jpa.show-sql" : "true",
            "spring.jpa.hibernate.ddl-auto" : "update",
            "spring.jpa.properties.hibernate.dialect": "org.hibernate.dialect.MySQL5InnoDBDialect"
          }'
    networks:
      - backend-net
      - frontend-net


  achat_front :
    image : medalaakanzari/achat_front
    ports:
      - 80:80
    depends_on :
      - achat_back
    restart : on-failure
    networks :
      - frontend-net
networks:
  backend-net :
  frontend-net :