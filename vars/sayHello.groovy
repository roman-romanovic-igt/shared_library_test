#!/usr/bin/env groovy

def call(String name="human") {
    echo "Hello, ${name}"

    downloadCxCLI('http://github.com/Checkmarx/ast-cli/releases/latest/download/ast-cli_linux_x64.tar.gz')
}

def downloadCxCLI(String urlString, String localPath = "./ast-cli_linux_x64.tar.gz") {
    def url = new URL(urlString)
    def file = new File(localPath)

    file.withOutputStream { out ->
        url.withInputStream { input ->
            out << input
        }
    }

    println "Downloaded ${file.size()} bytes to ${localPath}"
}