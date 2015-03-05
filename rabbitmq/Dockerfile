FROM ubuntu:14.04
RUN apt-get update -y && apt-get install -y wget build-essential supervisor
RUN cd /opt \
		&& wget https://www.rabbitmq.com/releases/rabbitmq-server/v3.4.4/rabbitmq-server-generic-unix-3.4.4.tar.gz \
		&& tar -xvzf rabbitmq-server-generic-unix-3.4.4.tar.gz \
		&& mv rabbitmq_server-3.4.4 rabbitmq
ENV RABBITMQ_LOG_BASE /var/log/rabbitmq
ENV RABBITMQ_MNESIA_BASE /data/mnesia

RUN mkdir -p /var/log/supervisor
ADD supervisor.conf /etc/supervisor/conf.d/supervisor.conf

EXPOSE 5672
EXPOSE 15672

CMD ["/usr/bin/supervisord"]