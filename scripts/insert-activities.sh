#!/usr/bin/env bash

index_name_alias=training
activities_file=activities.json

curl -X POST localhost:9200/${index_name_alias}/_bulk -H "Content-Type: application/json" --data-binary @${activities_file}
echo