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
                steps
                    sh "mvn deploy -DskipTests"
                }
            }


        }
}