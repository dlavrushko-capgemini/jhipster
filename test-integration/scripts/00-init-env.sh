```bash
#!/bin/bash

init_var() {
    result=""
    if [[ $1 != "" ]]; then
        result=$1
    elif [[ $2 != "" ]]; then
        result=$2
    fi
    echo $result
}

JHI_REPO=$(init_var "$BUILD_REPOSITORY_URI" "$GITHUB_WORKSPACE")
JHI_CLONED=$(init_var "$BUILD_REPOSITORY_LOCALPATH" "$GITHUB_WORKSPACE")
JHI_HOME="$HOME"/generator-jhipster
JHI_INTEG="$JHI_HOME"/test-integration
JHI_SAMPLES="$JHI_INTEG"/samples
JHI_SCRIPTS="$JHI_INTEG"/scripts
JHI_FOLDER_APP="$HOME"/app
JHI_FOLDER_UAA="$HOME"/uaa

if [[ "$JHI_JDK" == "11" && "$JHI_GITHUB_CI" != "true" ]]; then
    JAVA_HOME=$(readlink -f /usr/bin/java | sed "s:bin/java::")
fi
```