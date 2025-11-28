#!/usr/bin/env groovy

def call(String name="human") {
    echo "Hello, ${name}"

    downloadCxCLI('http://github.com/Checkmarx/ast-cli/releases/latest/download/ast-cli_linux_x64.tar.gz')
    unpackCxCLI()
}

def downloadCxCLI(String urlString, String localPath = "/tmp/ast-cli_linux_x64.tar.gz") {
    def response = sh(script: "curl -s -L -o ${localPath} '${urlString}'", returnStdout: true).trim()

    echo "Downloaded to ${localPath}"
}

def unpackCxCLI(String localPath = "/tmp/ast-cli_linux_x64.tar.gz") {
    sh "tar -xzvf ${localPath} -C /tmp"
}