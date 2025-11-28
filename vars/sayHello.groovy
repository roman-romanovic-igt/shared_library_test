#!/usr/bin/env groovy

def call() {
    println "I am in the call function"

    sh "wget -q http://github.com/Checkmarx/ast-cli/releases/latest/download/ast-cli_linux_x64.tar.gz"
    println "binary downloaded"

    sh "tar -xzvf ast-cli_linux_x64.tar.gz"
    println "ast-cli unpacked"

    println "${./cx version}"
}