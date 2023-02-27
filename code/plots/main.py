import repository
import statistics


json = repository.get_method_size("JSON", "M")
xml = repository.get_method_size("XML", "S")
msgpack = repository.get_method_size("MSGPACK", "S")
kryo = repository.get_method_size("KRYO", "S")

for j in json:
    j_request = []
    j_serialize = [] 
    j_deserialize = []
    j_request.append(j['timeRequest'])
    j_serialize.append(j['timeSerialize'])
    j_deserialize.append(j['timeDeserialize'])

print(f"request: {statistics.median(j_request)}")
print(f"serialize: {statistics.median(j_serialize)}")
print(f"deserialize: {statistics.median(j_deserialize)}")
