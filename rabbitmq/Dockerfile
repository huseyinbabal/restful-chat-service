FROM ubuntu:14.04
RUN apt-get update -y && apt-get install -y wget
RUN cd /opt \
		&& wget https://www.rabbitmq.com/releases/rabbitmq-server/v3.4.4/rabbitmq-server-generic-unix-3.4.4.tar.gz \
		&& tar -xvzf rabbitmq-server-generic-unix-3.4.4.tar.gz
		&& mv rabbitmq-server-generic-unix-3.4.4 rabbitmq
ENV RABBITMQ_LOG_BASE /var/log/rabbitmq
ENV RABBITMQ_MNESIA_BASE /data/mnesia

WORKDIR /opt/rabbitmq/bin
CMD["rabbitmq-server"]
EXPOSE 5672
EXPOSE 15672