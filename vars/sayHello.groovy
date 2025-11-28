#!/usr/bin/env groovy
evaluate(new File("./getArtifactUrl.groovy"))

def call(String name = 'human') {
    echo "Hello, ${name}."

    getArtifactUrl
}