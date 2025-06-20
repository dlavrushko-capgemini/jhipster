#!/bin/bash

set -e
source $(dirname $0)/00-init-env.sh

if [[ $JHI_VERSION == '' ]]; then
    JHI_VERSION=0.0.0-CICD
fi

sed -e '/<artifactId>jhipster-parent<\/artifactId>/{N;s/<version>.*<\/version>/<version>'$JHI_VERSION'<\/version>/1;}' pom.xml > pom.xml.sed
mv -f pom.xml.sed pom.xml

sed -e 's/<jhipster-framework.version>.*<\/jhipster-framework.version>/<jhipster-framework.version>'$JHI_VERSION'<\/jhipster-framework.version>/1' pom.xml > pom.xml.sed
mv -f pom.xml.sed pom.xml

sed -e '/<artifactId>jhipster-parent<\/artifactId>/{N;s/<version>.*<\/version>/<version>'$JHI_VERSION'<\/version>/1;}' jhipster-dependencies/pom.xml > jhipster-dependencies/pom.xml.sed
mv -f jhipster-dependencies/pom.xml.sed jhipster-dependencies/pom.xml

sed -e '/<artifactId>jhipster-dependencies<\/artifactId>/{N;s/<version>.*<\/version>/<version>'$JHI_VERSION'<\/version>/1;}' jhipster-framework/pom.xml > jhipster-framework/pom.xml.sed
mv -f jhipster-framework/pom.xml.sed jhipster-framework/pom.xml