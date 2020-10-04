#!/usr/bin/env bash

index_name=training
mapping_file=mapping-v1.json

echo "------------"
echo "Create index"
echo "------------"
curl -X PUT localhost:9200/${index_name} -H "Content-Type: application/json" -d @${mapping_file}
