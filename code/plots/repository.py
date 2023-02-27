import json
import os
import boto3
from boto3.dynamodb.conditions import Key

dynamodb = boto3.resource("dynamodb")
table = dynamodb.Table("item")

response = table.scan(
    FilterExpression="#type = :requestType",
    ExpressionAttributeValues={":requestType": "STRUCT"},
    ExpressionAttributeNames={"#type": "type"},
)

items = response['Items']

while 'LastEvaluatedKey' in response:
    response = table.scan(ExclusiveStartKey=response['LastEvaluatedKey'])
    items.extend(response['Items'])

for item in items:
    print(item['timeDeserialize'])