pipeline {
    agent any
 
    stages {
        stage('Build') {
            steps {
                //build your project
                withMaven {
                    sh 'mvn clean install'
                } 
            }
        }

        stage('Test') {
            steps {
                withMaven {
                    sh "mvn test"
                } 
            }
        }

        stage('Publish results') {
            steps {
                //publish test reports
                junit '**/target/surefire-reports/*.xml'
            }
        }
    }
}