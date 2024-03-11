import repository
import plot

methods = ["XML", "JSON", "MSGPACK", "KRYO"]
sizes = ["1", "100", "1000"]
services = ["EC2", "ECS", "LAMBDA"]
types = ["STRUCT", "STRING", "CHAR", "DOUBLE", "INTEGER", "BOOL"]

response = repository.scan()

def method_size():
    method_size = []
    categories = []
    values_bytes_serialize = []
    values_request = []
    values_serialize = []
    values_deserialize = []
    for m in methods:
        for s in sizes:
            print(f"{m} - {s}")
            method_size.append(repository.get_method_size(m, s, response))
    for s in sizes:
        values_bytes_serialize.clear()
        values_request.clear()
        values_serialize.clear()
        values_deserialize.clear()
        categories.clear()
        for ms in method_size:
            if ms.size[0] == s:
                categories.append(ms.method)
                values_bytes_serialize.append(ms.bytes_serialize)
                values_request.append(ms.request)
                values_serialize.append(ms.serialize)
                values_deserialize.append(ms.deserialize)
        plot.method_size(categories, values_bytes_serialize, s, "Quantidade média de bytes serializados")
        plot.method_size(categories, values_request, s, "Tempo médio da requisição (ms)")
        plot.method_size(categories, values_serialize, s, "Tempo médio de serialização")
        plot.method_size(categories, values_deserialize, s, "Tempo médio de deserialização")

def method_service():
    method_service = []
    categories = []
    values_bytes_serialize = []
    values_request = []
    values_serialize = []
    values_deserialize = []
    for m in methods:
        for s in services:
            print(f"{m} - {s}")
            method_service.append(repository.get_method_service(m, s, response))

    for s in services:
        values_bytes_serialize.clear()
        values_request.clear()
        values_serialize.clear()
        values_deserialize.clear()
        categories.clear()  
        for ms in method_service:
            if ms.service == s:
                categories.append(ms.method)
                values_bytes_serialize.append(ms.bytes_serialize)
                values_request.append(ms.request)
                values_serialize.append(ms.serialize)
                values_deserialize.append(ms.deserialize)

        plot.method_service(categories, values_bytes_serialize, s, "Quantidade média de bytes serializados")
        plot.method_service(categories, values_request, s, "Tempo médio da requisição (ms)")
        plot.method_service(categories, values_serialize, s, "Tempo médio de serialização")
        plot.method_service(categories, values_deserialize, s, "Tempo médio de deserialização")

def method_type():
    method_type = []
    categories = []
    values_bytes_serialize = []
    values_request = []
    values_serialize = []
    values_deserialize = []
    for m in methods:
        for t in types:
            print(f"{m} - {t}")
            method_type.append(repository.get_method_type(m, t, response))

    for t in types:
        values_bytes_serialize.clear()
        values_request.clear()
        values_serialize.clear()
        values_deserialize.clear()
        categories.clear()
        for mt in method_type:
            if mt.type == t:
                categories.append(mt.method)
                values_bytes_serialize.append(mt.bytes_serialize)
                values_request.append(mt.request)
                values_serialize.append(mt.serialize)
                values_deserialize.append(mt.deserialize)

        plot.method_type(categories, values_bytes_serialize, t, "Quantidade média de bytes serializados")
        plot.method_type(categories, values_request, t, "Tempo médio da requisição (ms)")
        plot.method_type(categories, values_serialize, t, "Tempo médio de serialização")
        plot.method_type(categories, values_deserialize, t, "Tempo médio de deserialização")
