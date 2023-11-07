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

            stage('COMPILE') {
                steps {
                    echo 'COMPILING CODE'
                    sh 'mvn compile'
                }
            }

            stage('TEST') {
                steps {
                    echo 'RUNNING TESTS'
                    sh 'mvn test'
                }
            }

            stage('PACKAGE') {
                steps {
                    echo 'PACKAGING ARTIFACT'
                    sh 'mvn package'
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

            stage('NEXUS') {
                steps {
                    echo 'NEXUS DEPLOYMENT'
                    sh "mvn deploy"
                }
            }


        }
}