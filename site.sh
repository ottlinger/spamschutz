#!/bin/bash
echo "Generating new mvn site ..."
./mvnw clean org.pitest:pitest-maven:mutationCoverage site:site 
echo "DONE - ready to commit and push"
git checkout gh-pages && ./copy-site.sh 
