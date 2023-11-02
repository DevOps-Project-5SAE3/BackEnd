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
                stage('Nexus Deployment') {
                            steps {
                                // Deploy the Maven artifacts to Nexus Repository Manager
                                sh "${MAVEN_HOME}/bin/mvn deploy -DskipTests"
                            }
                        }
    }
}