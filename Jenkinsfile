pipeline {
    agent any
    stages {

   
        stage('Checkout') {
            steps {
                // Étape pour récupérer le code source depuis le référentiel Git
                checkout([$class: 'GitSCM', branches: [[name: '*/bougacha']], userRemoteConfigs: [[url: 'https://github.com/DevOps-Project-5SAE3/BackEnd.git']]])
            }
        }
        stage('Build') {
            steps {
                script{
                    sh 'mvn --version'
                    sh 'mvn clean package -DiskpTests'
                }
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        post {
                always {
                    cleanWs()
                }
            }


    }
}