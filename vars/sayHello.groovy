#!/usr/bin/env groovy

def call(String name="human") {
    echo "Hello, ${name}"

    sh "wget -q http://github.com/Checkmarx/ast-cli/releases/latest/download/ast-cli_linux_x64.tar.gz"
    echo "Downloaded"
}