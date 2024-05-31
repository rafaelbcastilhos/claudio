class Resume:
    def __init__(self, method, service, typeData, size, bytes_serialize, request, serialize, deserialize):
        self.method = method
        self.service = service
        self.type = typeData
        self.size = size,
        self.bytes_serialize = bytes_serialize
        self.request = request
        self.serialize = serialize
        self.deserialize = deserialize