pipeline {
    agent any

    stages {
        stage('CHECKOUT CODE') {
            steps {
                script {
                    echo 'Getting Project From Git'
                    checkout scm
                }
            }
        }

        stage('CLEAN') {
           steps {
              echo 'CLEANING PROJECT'
              sh 'mvn clean'
           }
        }

        stage('COMPILE AND PACKAGE') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('TEST') {
            steps {
                sh 'mvn test'
            }
        }

        stage('SONARQUBE') {
            steps {
                withSonarQubeEnv('sonarqube_env') {
                    script {
                        echo 'SONARQUBE ANALYSIS'
                        sh 'mvn sonar:sonar'
                    }
                }
            }
        }



       /* stage('NEXUS') {
            steps {
                script {
                    echo 'Deploying to Nexus'
                    sh "mvn deploy -DskipTests"
                }
            }
        }*/
    }
}
