pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
               checkout([$class: 'GitSCM', branches: [[name: '*/salma']], userRemoteConfigs: [[url: 'https://github.com/DevOps-Project-5SAE3/BackEnd.git']]])
            }
        }
        stage('cleaning project') {
            steps {
                sh 'mvn clean '
            }
        }
        stage('compiling project') {
            steps {
                sh 'mvn compile'
            }

}
stage('Run Sonar')  {
            steps {
                withCredentials([string(credentialsId: 'squ_6353e71b9fdd22953689fc0263e250626178ed35', variable: 'toktok')]) {
                    sh 'mvn sonar:sonar -Dsonar.host.url=http://192.168.1.3:9000/ -Dsonar.login=$toktok'
                }
            }
      }


        stage('Run Tests') {
            steps {
                sh 'mvn test'
            }

	}
}}
