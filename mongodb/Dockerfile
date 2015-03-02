FROM ubuntu:14.04
RUN apt-get update -y && apt-get install -y wget
RUN cd /opt \
		&& wget http://fastdl.mongodb.org/linux/mongodb-linux-x86_64-2.6.8.tgz \
		&& tar -xvzf mongodb-linux-x86_64-2.6.8.tgz
		&& mv mongodb-linux-x86_64-2.6.8 mongodb

COPY mongodb.conf /opt/mongodb/mongodb.conf