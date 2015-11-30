#!/bin/bash
echo "Copying current site to this directory ...."
cp -rvf target/site/* .
echo "DONE - ready to commit and push"
git add .
git commit -m "Updated mvn site from head."
