import repository
import statistics


json = repository.get_method_size("JSON", "S")
#xml = repository.get_method_size("XML", "B")
#msgpack = repository.get_method_size("MSGPACK", "S")
#kryo = repository.get_service_size("EC2", "B")

j_request = []
j_serialize = [] 
j_deserialize = []
sum_deserialize = 0
for j in json:
    sum_deserialize = sum_deserialize + j['timeDeserialize']
    j_request.append(j['timeRequest'])
    j_serialize.append(j['timeSerialize'])
    j_deserialize.append(j['timeDeserialize'])

#print(f"request: {(j_request)}")
#   print(f"serialize: {j_serialize}")
print(f"deserialize: {sum_deserialize / len(j_deserialize)}")

