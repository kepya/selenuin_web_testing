pipeline {
    agent any
 
     environment {
        GIT_SSH_KEY = credentials('github-ssh-key')  // ID of the SSH key added in Jenkins credentials
    }

    stages {
        stage('Checkout from GitHub') {
            steps {
                script {
                    // Define custom GIT SSH command
                    sh "ssh-agent bash -c 'ssh-add ${GIT_SSH_KEY}; git clone git@github.com:YourUsername/YourRepo.git'"
                }
            }
        }

        stage('Test') {
            steps {
                bat "mvn -D clean test"
            }
 
            post {                
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                   publishHTML([
                       allowMissing: false, 
                       alwaysLinkToLastBuild: false, 
                       keepAll: false, 
                       reportDir: 'target/surefire-reports/', 
                       reportFiles: 'emailable-report.html', 
                       reportName: 'HTML Report', 
                       reportTitles: '', 
                       useWrapperFileDirectly: true])
                }
            }
        }
    }
}