#!/usr/bin/env bash
multi-file-swagger api.yml > api.json
set -e

echo "Enter region:"
echo "0: us-east-1 (N. Virginia)"
echo "1: eu-central-1 (Frankfurt)"

read opt

if [ "$opt" -eq "0" ]; then
  REGION="us-east-1"
  BUCKET="ufsc-cco-tcc-us"
elif [ "$opt" -eq "1" ]; then
  REGION="eu-central-1"
  BUCKET="ufsc-cco-tcc-eu"
else
  echo "Argument region is required"
  exit 1
fi

SERVICE="tcc"
AWS_ID="826283206450"
BUCKET_DEPLOY="deploy"

echo -e "\nDeploy REST API to S3..."
aws s3 cp ./api.json s3://${BUCKET}/${BUCKET_DEPLOY}/api.json

sam package \
  --template-file infra.yml \
  --output-template-file output-template.yml \
  --s3-bucket ${BUCKET} \
  --s3-prefix ${BUCKET_DEPLOY} \
  --region ${REGION}

cfn-include ./output-template.yml -m > ./output.json

rm ./output-template.yml

sam deploy \
  --template-file output.json \
  --s3-bucket ${BUCKET} \
  --s3-prefix ${BUCKET_DEPLOY} \
  --stack-name ${SERVICE} \
  --capabilities CAPABILITY_IAM \
  --region ${REGION} \
  --parameter-overrides AwsId=${AWS_ID} Region=${REGION}

aws s3 rm s3://${BUCKET}/${BUCKET_DEPLOY}/ --recursive --quiet

rm ./output.json
rm ./api.json