FROM ubuntu:14.04
RUN apt-get update -y && apt-get install -y wget build-essential supervisor

RUN wget http://www.rabbitmq.com/rabbitmq-signing-key-public.asc
RUN apt-key add rabbitmq-signing-key-public.asc
RUN echo "deb http://www.rabbitmq.com/debian/ testing main" > /etc/apt/sources.list.d/rabbitmq.list
RUN apt-get update
RUN apt-get -y -q install rabbitmq-server
RUN /usr/sbin/rabbitmq-plugins enable rabbitmq_management
echo "[{rabbit, [{loopback_users, []}]}]." > /etc/rabbitmq/rabbitmq.config

ADD supervisor.conf /etc/supervisor/conf.d/supervisor.conf

EXPOSE 5672
EXPOSE 15672

CMD ["/usr/bin/supervisord", "-n"]