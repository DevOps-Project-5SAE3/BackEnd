pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                script {
                    // Checkout the code from the repository
                    checkout scm
                }
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post{
              always{
                junit 'target/surefire-reports/*.xml'
              }
            }
        }
        stage('test SonarQube') {
            steps {
                sh 'mvn sonar:sonar'
            }


        }
    }
}
