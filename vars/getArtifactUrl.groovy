def call() {
    getCxCLI
    untarAstCli
}

def getCxCLI(String urlString = 'http://github.com/Checkmarx/ast-cli/releases/latest/download/ast-cli_linux_x64.tar.gz', String localPath = 'ast-cli_linux_x64.tar.gz') {
    def url = new URL(urlString)
    def file = new File(localPath)

    file.withOutputStream { out ->
        url.withInputStream { input ->
            out << input
        }
    }

    println "Downloaded ${file.size()} bytes to ${localPath}"
}

def untarAstCli(String localPath = 'ast-cli_linux_x64.tar.gz') {
    sh "tar -xzvf ${localPath}"
    sh "./cx version"
}