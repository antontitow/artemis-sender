https://www.masterspringboot.com/messaging/artemismq/jms-messaging-with-spring-boot-and-remote-artemis-mq/
https://docs.spring.io/spring-boot/docs/current/reference/html/messaging.html

Качаем https://activemq.apache.org/components/artemis/download/
Распаковали
C:\apache-artemis-2.32.0

Создали топик
C:\apache-artemis-2.32.0\bin bash
./artemis create springboot-broker --user=tony --password=Qaztit --allow-anonymous

Запустим артемис
cd C:\apache-artemis-2.32.0\bin\springboot-broker\bin cmd
artemis run
В консоле указана ссылка на админку
http://localhost:8161/console
