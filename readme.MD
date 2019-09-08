https://kafka.apache.org/downloads

unzip -> ~/kafka_2.12-2.3.0

Edit Zookeeper & Kafka configs using a text editor
```
zookeeper.properties: 
dataDir=/Users/serhiiluhovyi/kafka_2.12-2.3.0/data/zookeeper
server.properties: 
log.dirs=/Users/serhiiluhovyi/kafka_2.12-2.3.0/data/kafka
```

Edit ~/.bash_profile
```
export PATH=$PATH:/Users/serhiiluhovyi/kafka_2.12-2.3.0/bin
```
```
source ~/.bash_profile
cd ~/kafka_2.12-2.3.0
```

Start Zookeeper in one terminal window: 
```
zookeeper-server-start.sh config/zookeeper.properties
```
Start Kafka in another terminal window: 
```
kafka-server-start.sh  config/server.properties
```

```
kafka-topics.sh --zookeeper localhost:2181 --topic hello_users --create --partitions 3 --replication-factor 1 
kafka-topics.sh --zookeeper localhost:2181  --list
kafka-topics.sh --zookeeper localhost:2181 --topic hello_users --describe 

kafka-console-producer.sh --broker-list localhost:9092 --topic hello_users
kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic hello_users --from-beginning
```

```
curl -X POST 'http://localhost:8085/kafka/publish?message=qwerty'
```