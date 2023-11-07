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

            stage('Run Sonar')  {
                        steps {
                            withCredentials([string(credentialsId: 'sonar', variable: 'SONAR_TOKEN')]) {
                                sh 'mvn sonar:sonar -Dsonar.host.url=http://192.168.33.10:9000/ -Dsonar.login=$SONAR_TOKEN'
                            }
                        }
                    }


          stage("Deploy Artifact to Nexus") {
            steps {
                sh "mvn deploy -DskipTests"
            }
        } 


    }
    }