#!/usr/bin/env groovy

def call(String name = 'human') {
    echo "Hello, ${name}."

    getCxCLI()
    untarAstCli()
}

def getCxCLI(String urlString = 'http://github.com/Checkmarx/ast-cli/releases/latest/download/ast-cli_linux_x64.tar.gz') {
    def url = new URL(urlString)
    def file = new File(localPath)

    sh "wget -q ${urlString}"

    println "Cx CLI downloaded"
}

def untarAstCli(String localPath = 'ast-cli_linux_x64.tar.gz') {
    println "I am in untarAstCli"
    sh "tar -xzvf ${localPath}"
    sh "./cx version"
}