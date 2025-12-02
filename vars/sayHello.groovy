#!/usr/bin/env groovy

def call(String app_name, String project_name, String branch) {
    downloadCxCLI('http://github.com/Checkmarx/ast-cli/releases/latest/download/ast-cli_linux_x64.tar.gz')
    unpackCxCLI()
    runScan(app_name, project_name, branch)
}

def downloadCxCLI(String urlString, String localPath = "ast-cli_linux_x64.tar.gz") {
    def response = sh(script: "curl -s -L -o ${localPath} '${urlString}'", returnStdout: true).trim()

    echo "Downloaded to ${localPath}"
}

def unpackCxCLI(String localPath = "ast-cli_linux_x64.tar.gz") {
    sh "tar -xzvf ${localPath}"
    sh "./cx version"
}

def runScan(String app_name, String project_name, String branch) {
    sh "./cx scan create -s . --application-name ${app_name} --project-name ${project_name} --branch ${branch} --scan-types sast,sca,api-security,container-security"
}