FROM eguahlak/glassfish-cph
MAINTAINER AKA

COPY ./target/*.war /opt/glassfish4/glassfish/domains/domain1/autodeploy/mog-frontend.war

# RUN wget \
#    https://github.com/eguahlak/choir-frontend/blob/master/target/choir-frontend-1.0-SNAPSHOT.war?raw=true \
#    -O /opt/glassfish4/glassfish/domains/domain1/autodeploy/Choir.war

CMD [ "asadmin", "start-domain", "-v" ]
