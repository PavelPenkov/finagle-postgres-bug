Running the application results in some unknown error
```
INFO: FailureAccrualFactory marking connection to "postgres" as dead. Remote Address: Inet(db/172.20.0.2:5432,Map())
```

To reproduce:

```sh
sbt docker:publishLocal
docker-compose run app
```