#!/usr/bin/env groovy

def call(String base_url, String tenant, String, client_id, String client_secret) {
    downloadCxCLI('http://github.com/Checkmarx/ast-cli/releases/latest/download/ast-cli_linux_x64.tar.gz')
    unpackCxCLI()
}

def downloadCxCLI(String urlString, String localPath = "ast-cli_linux_x64.tar.gz") {
    def response = sh(script: "curl -s -L -o ${localPath} '${urlString}'", returnStdout: true).trim()

    echo "Downloaded to ${localPath}"
}

def unpackCxCLI(String localPath = "ast-cli_linux_x64.tar.gz") {
    sh "tar -xzvf ${localPath}"
    sh "./cx version"
}

def runScan(String cx_base_url, String cx_tenant, String, cx_client_id, String cx_client_secret) {
    sh "./cx "
}