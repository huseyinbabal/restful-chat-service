FROM ubuntu:14.04
RUN apt-get update -y && apt-get install -y wget build-essential supervisor
WORKDIR /opt
RUN wget http://fastdl.mongodb.org/linux/mongodb-linux-x86_64-2.6.8.tgz
RUN tar -xvzf mongodb-linux-x86_64-2.6.8.tgz \
RUN mv mongodb-linux-x86_64-2.6.8 mongodb

ADD mongodb.conf /opt/mongodb/mongodb.conf
ADD supervisor.conf /etc/supervisor/conf.d/supervisor.conf

EXPOSE 27017

CMD ["/usr/bin/supervisord", "-n"]