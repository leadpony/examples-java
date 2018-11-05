#!/usr/bin/env bash

curl http://localhost:8080/spring-deserializer/ -XPOST -H "Content-Type: application/json" -d '{"title":"large picture", "file":"QUJDREVGRw==", "year": 2018}'   
