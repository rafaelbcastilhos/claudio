import json
import os
import boto3
import statistics
from boto3.dynamodb.conditions import Attr

dynamodb = boto3.resource("dynamodb")
table = dynamodb.Table("item")

def scan():
    response = table.scan()

    items = response['Items']

    while 'LastEvaluatedKey' in response:
        response = table.scan(ExclusiveStartKey=response['LastEvaluatedKey'])
        items.extend(response['Items'])

    return items


def get_method_size(method, size):
    response = scan()
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
    array_mean(bytes_serialize, request, serialize, deserialize)

def get_method_service(method, service):
    response = scan()
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
    array_mean(bytes_serialize, request, serialize, deserialize)

def get_method_type(method, typeData):
    response = scan()
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
    array_mean(bytes_serialize, request, serialize, deserialize)

def array_mean(bytes_serialize, request, serialize, deserialize):
    print(f"bytesSerialize: {statistics.mean(bytes_serialize)}")
    print(f"timeRequest: {statistics.mean(request)}")
    print(f"timeSerialize: {statistics.mean(serialize)}")
    print(f"timeDeserialize: {statistics.mean(deserialize)}")