pipeline {
    agent any 

    stages {
        stage('test') {
            steps {
                script {
                    def zipFile = input message: "Upload zip", parameters: [base64File("test.zip")] 
                    writeFile file: "test.zip", text: zipFile, encoding : 'Base64'

                    unzip(zipFile: "test.zip", dir: "report")
                    
                    publishHTML(target: [allowMissing         : false,
                        alwaysLinkToLastBuild: true,
                        keepAll              : true,
                        reportDir            : 'report',
                        reportFiles          : 'index.html',
                        reportName           : 'My Report',
                        reportTitles         : 'My Report'])
                }
            }
        }
    }
}