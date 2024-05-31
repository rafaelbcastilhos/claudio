from resume import Resume
import json
import os
import boto3
import statistics

dynamodb = boto3.resource("dynamodb")
table = dynamodb.Table("item")

def scan():
    response = table.scan()

    items = response['Items']

    while 'LastEvaluatedKey' in response:
        response = table.scan(ExclusiveStartKey=response['LastEvaluatedKey'])
        items.extend(response['Items'])

    return items


def get_method_size(method, size, response):
    request = []
    serialize = [] 
    deserialize = []
    bytes_serialize = []
    for i in response:
        if i['method'] == method and i['size'] == size:
            bytes_serialize.append(int(i['bytesSerialize']))
            request.append(int(i['timeRequest']))
            serialize.append(int(i['timeSerialize']))
            deserialize.append(int(i['timeDeserialize']))
    return Resume(method,
        None,
        None,
        size,
        statistics.mean(bytes_serialize),
        statistics.mean(request),
        statistics.mean(serialize),
        statistics.mean(deserialize))

def get_method_service(method, service, response):
    request = []
    serialize = [] 
    deserialize = []
    bytes_serialize = []
    for i in response:
        if i['method'] == method and i['service'] == service:
            bytes_serialize.append(int(i['bytesSerialize']))
            request.append(int(i['timeRequest']))
            serialize.append(int(i['timeSerialize']))
            deserialize.append(int(i['timeDeserialize']))
    return Resume(method,
        service,
        None,
        None,
        statistics.mean(bytes_serialize),
        statistics.mean(request),
        statistics.mean(serialize),
        statistics.mean(deserialize))

def get_method_type(method, typeData, response):
    request = []
    serialize = [] 
    deserialize = []
    bytes_serialize = []
    for i in response:
        if i['method'] == method and i['type'] == typeData:
            bytes_serialize.append(int(i['bytesSerialize']))
            request.append(int(i['timeRequest']))
            serialize.append(int(i['timeSerialize']))
            deserialize.append(int(i['timeDeserialize']))
    return Resume(method,
        None,
        typeData,
        None,
        statistics.mean(bytes_serialize),
        statistics.mean(request),
        statistics.mean(serialize),
        statistics.mean(deserialize))
