# pivotal-agent

New Relic Agent for monitoring RabbitMQ.

## Prerequisities 

### For Building

1. Clone <https://github.com/newrelic-platform/metrics_publish_java>

```bash
$ git clone git@github.com:newrelic-platform/metrics_publish_java.git
$ cd metrics_publish_java
```
2. Install to the local Maven repository

```bash
$ mvn install:install-file -Dfile=dist/metrics_publish-2.0.1.jar -DgroupId=newrelic-platform \
                           -DartifactId=metrics-publish -Dversion=2.0.1 -Dpackaging=jar
```

### For Running

* RabbitMQ management must be enabled

## Building with boot

Clone this repository and run:

```bash
$ boot build
```

## Example configuration file

* Must be located in *config/plugin.edn*

```clojure
{:agent-name "rabbitmq dev"
 :license-key "INSERT_NEW_RELIC_LICENSE_KEY"
 :url "http://localhost:15672"
 :user "user"
 :pass "pass"
 :debug false}
```

| key | description |
|-----|-------------|
|agent-name | Agent reports to New Relic with this name |
|license-key| New Relic License key |
|user       | Username to RabbitMQ management ui |
|pass       | Password to RabbitMQ management ui |
|debug      | e.g. Log data that is sent to New Relic when set to *true* |

## Running

```bash
java -jar target/pivotal-agent.jar
```

## TODO

* [ ] More informative error messages for missing configuration keys etc.