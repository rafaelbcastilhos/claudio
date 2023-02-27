import json
import os
import boto3
from boto3.dynamodb.conditions import Key

dynamodb = boto3.resource("dynamodb")
table = dynamodb.Table("item")

def get_method(method):
    response = table.scan(
        FilterExpression="#method = :requestMethod",
        ExpressionAttributeValues={":requestMethod": method},
        ExpressionAttributeNames={"#method": "method"},
        ProjectionExpression="timeSerialize,timeDeserialize,timeRequest",
    )

    items = response['Items']

    while 'LastEvaluatedKey' in response:
        response = table.scan(ExclusiveStartKey=response['LastEvaluatedKey'])
        items.extend(response['Items'])

    return items

def get_method_size(method, size):
    response = table.scan(
        FilterExpression="#method = :requestMethod and #size = :requestSize",
        ExpressionAttributeValues={":requestMethod": method, ":requestSize": size},
        ExpressionAttributeNames={"#method": "method", "#size": "size"},
        ProjectionExpression="timeSerialize,timeDeserialize,timeRequest",
    )

    items = response['Items']

    while 'LastEvaluatedKey' in response:
        response = table.scan(ExclusiveStartKey=response['LastEvaluatedKey'])
        items.extend(response['Items'])

    return items

def get_service_size(service, size):
    response = table.scan(
        FilterExpression="#service = :requestService and #size = :requestSize",
        ExpressionAttributeValues={":requestService": service, ":requestSize": size},
        ExpressionAttributeNames={"#service": "service", "#size": "size"},
        ProjectionExpression="timeSerialize,timeDeserialize,timeRequest",
    )

    items = response['Items']

    while 'LastEvaluatedKey' in response:
        response = table.scan(ExclusiveStartKey=response['LastEvaluatedKey'])
        items.extend(response['Items'])

    return items