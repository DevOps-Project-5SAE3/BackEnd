pipeline {
    agent any

    stages {
        stage('Clean') {
            steps {
                // Clean the project
                sh "mvn clean"
            }
        }

        stage('Build') {
            steps {

                // Build the Spring Boot application using Maven
                sh "mvn build"
            }
        }

        stage('Test') {
            steps {
                // Run tests
                sh "mvn test"
            }
        }
    }
}
