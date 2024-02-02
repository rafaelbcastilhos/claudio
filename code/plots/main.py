import repository
import statistics

methods = ["XML", "JSON", "MSGPACK", "KRYO"]
sizes = ["1", "100", "1000"]
services = ["EC2", "ECS", "LAMBDA"]
types = ["STRUCT", "STRING", "CHAR", "DOUBLE", "INTEGER", "BOOL"]

for m in methods:
    for s in sizes:
        method_size = repository.get_method_size(m, s)

for m in methods:
    for s in services:
        method_service_all = repository.get_method_service(m, s)

for m in methods:
    for t in types:
        method_service_all = repository.get_method_service(m, t)
