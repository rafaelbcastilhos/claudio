import repository

json = repository.get_method("JSON")
xml = repository.get_method("XML")
msgpack = repository.get_method("MSGPACK")
kryo = repository.get_method("KRYO")

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