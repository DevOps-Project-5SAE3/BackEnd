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
        stage('Test and JaCoCo Report') {
            steps {
                sh 'mvn clean verify'
            }
            post {
                always {
                    script {
                        sh 'mvn jacoco:report'
                    }
                }
            }
        }
        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQubeServer') {
                    script {
                        sh 'mvn sonar:sonar'
                    }
                }
            }
        }
    }
}
