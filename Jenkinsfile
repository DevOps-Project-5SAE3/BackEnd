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

                                sh "mvn deploy -DskipTests"
                            }
                        }
                    stage('Building Docker image') {
                                	   steps {
                                		 script {
                                			// Generating image from Dockerfile
                                			  sh 'docker build -t rihabnasri/devops-0.0.1.jar .'
                                			}
                                		 }
                                	    }
                      stage('Push Docker Image to Nexus') {
                            steps {

                                             // Log in to your Nexus Docker registry with your credentials
                                        withCredentials([usernamePassword(credentialsId: 'nexus-credentials', usernameVariable: 'NEXUS_USERNAME', passwordVariable: 'NEXUS_PASSWORD')]) {
                                         sh "echo $NEXUS_PASSWORD | docker login -u $NEXUS_USERNAME --password-stdin http://192.168.0.8:8081"
                                        }


                                                // Push the Docker image to your Nexus repository
                                  sh "docker push http://192.168.0.8:8081/repository/docker-registry/devops-0.0.1.jar"
                                   }
                                   }
    }
}