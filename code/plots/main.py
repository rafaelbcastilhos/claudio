import repository
import plot


methods = ["XML", "JSON", "MSGPACK", "KRYO"]
sizes = ["1", "100", "1000"]
services = ["EC2", "ECS", "LAMBDA"]
types = ["STRUCT", "STRING", "CHAR", "DOUBLE", "INTEGER", "BOOL"]

method_size = []
method_service = []
method_type = []
categories = []
values = []

response = repository.scan()

for m in methods:
    for s in sizes:
        print(f"{m} - {s}")
        method_size.append(repository.get_method_size(m, s, response))

for s in sizes:
    values.clear()
    categories.clear()
    for ms in method_size:
        if ms.size[0] == s:
            categories.append(ms.method)
            values.append(ms.deserialize)

    plot.method_size(categories, values, s)

#for m in methods:
#    for s in services:
#        print(f"{m} - {s}")
#        method_service.append(repository.get_method_service(m, s, response))

#for m in methods:
#    for t in types:
#        print(f"{m} - {t}")
#        method_type.append(repository.get_method_type(m, t, response))
