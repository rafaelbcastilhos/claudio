import repository

json = repository.get_method_size("JSON", "S")
xml = repository.get_method_size("XML", "S")
msgpack = repository.get_method_size("MSGPACK", "S")
kryo = repository.get_method_size("KRYO", "S")

for j in json:
    print(j)
print("==========================")
for x in xml:
    print(x)
print("==========================")
for m in msgpack:
    print(m)
print("==========================")
for k in kryo:
    print(k)